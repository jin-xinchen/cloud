package jin.tool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.io.input.NullInputStream;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.concurrent.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class handlefile {
    /**
     *  Zip files v1.0
     *  Thank you creep
     *  From : https://zhuanlan.zhihu.com/p/364142487
     *  https://juejin.cn/post/6952794190107377677
     *  https://juejin.cn/post/6949355730814107661
     *  压缩三个大小为3.5GB的文件,147s
     * @param fileNames includes relative path
     * @param zipOutName
     **/
    public static void batchZipFiles(List<String> fileNames, String zipOutName) {
        //设置读取数据缓存大小
        byte[] buffer = new byte[4096];
        ZipOutputStream zipOut = null;
        try {
            zipOut = new ZipOutputStream(new FileOutputStream(zipOutName));
            for (String fileName : fileNames) {
                File inputFile = new File(fileName);
                if (inputFile.exists()) {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
                    //将文件写入zip内，即将文件进行打包
                    zipOut.putNextEntry(new ZipEntry(inputFile.getName()));
                    //写入文件的方法，同上
                    int size = 0;
                    //设置读取数据缓存大小
                    while ((size = bis.read(buffer)) >= 0) {
                        zipOut.write(buffer, 0, size);
                    }
                    //关闭输入输出流
                    zipOut.closeEntry();
                    bis.close();
                }
            }
        } catch (Exception e) {
//            log.error("batchZipFiles error:sourceFileNames:" + JSONObject.toJSONString(fileNames), e);
        } finally {
            if (null != zipOut) {
                try {
                    zipOut.close();
                } catch (Exception e) {
//                    log.error("batchZipFiles error:sourceFileNames:" + JSONObject.toJSONString(fileNames), e);
                }
            }
        }
    }
    /**
     *  批量压缩文件 v2.0
     *
     *  Thank you creep
     *  From : https://zhuanlan.zhihu.com/p/364142487
     *  压缩三个大小为3.5GB的文件,85s
     *  利用java.nio包下面的api，首先用Channels.newChannel()方法将zipOutputStream输出流创建一个写的通道通道，在读取文件内容的时候直接用FileInputStream.getChannel()
     * @param fileNames 需要压缩的文件名称列表(包含相对路径)
     * @param zipOutName 压缩后的文件名称
     **/
    public static void batchZipFiles_v2(List<String> fileNames, String zipOutName) throws Exception {
        ZipOutputStream zipOutputStream = null;
        WritableByteChannel writableByteChannel = null;
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipOutName));
            writableByteChannel = Channels.newChannel(zipOutputStream);
            for (String sourceFile : fileNames) {
                File source = new File(sourceFile);
                zipOutputStream.putNextEntry(new ZipEntry(source.getName()));
                FileChannel fileChannel = new FileInputStream(sourceFile).getChannel();
                while (fileChannel.read(buffer) != -1) {
                    //更新缓存区位置
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        writableByteChannel.write(buffer);
                    }
                    buffer.rewind();
                }
                fileChannel.close();
            }

        } catch (Exception e) {
//            log.error("batchZipFiles error  fileNames:" + JSONObject.toJSONString(fileNames), e);
        } finally {
            zipOutputStream.close();
            writableByteChannel.close();
            buffer.clear();
        }
    }
    /**
     *  批量压缩文件 v3.0
     *  Thank you creep
     *  From : https://zhuanlan.zhihu.com/p/364142487
     *  压缩三个大小为3.5GB的文件,161s
     *  内存映射文件
     * @param fileNames 需要压缩的文件名称列表(包含相对路径)
     * @param zipOutName 压缩后的文件名称
     **/
    public static void batchZipFiles_v3(List<String> fileNames, String zipOutName) {
        ZipOutputStream zipOutputStream = null;
        WritableByteChannel writableByteChannel = null;
        MappedByteBuffer mappedByteBuffer = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipOutName));
            writableByteChannel = Channels.newChannel(zipOutputStream);
            for (String sourceFile : fileNames) {
                File source = new File(sourceFile);
                long fileSize = source.length();
                zipOutputStream.putNextEntry(new ZipEntry(source.getName()));
                int count = (int) Math.ceil((double) fileSize / Integer.MAX_VALUE);
                long pre = 0;
                long read = Integer.MAX_VALUE;
                //由于一次映射的文件大小不能超过2GB，所以分次映射
                for (int i = 0; i < count; i++) {
                    if (fileSize - pre < Integer.MAX_VALUE) {
                        read = fileSize - pre;
                    }
                    mappedByteBuffer = new RandomAccessFile(source, "r").getChannel()
                            .map(FileChannel.MapMode.READ_ONLY, pre, read);
                    writableByteChannel.write(mappedByteBuffer);
                    pre += read;
                }
                //释放资源
//                ?Method m = FileChannelImpl.class.getDeclaredMethod("unmap", MappedByteBuffer.class);
//                ?m.setAccessible(true);
//                ?m.invoke(FileChannelImpl.class, mappedByteBuffer);
                mappedByteBuffer.clear();
            }
        } catch (Exception e) {
//            log.error("zipMoreFile error  fileNames:" + JSONObject.toJSONString(fileNames), e);
        } finally {
            try {
                if (null != zipOutputStream) {
                    zipOutputStream.close();
                }
                if (null != writableByteChannel) {
                    writableByteChannel.close();
                }
                if (null != mappedByteBuffer) {
                    mappedByteBuffer.clear();
                }
            } catch (Exception e) {
//                log.error("zipMoreFile error  fileNames:" + JSONObject.toJSONString(fileNames), e);
            }
        }
        /*
        这里有两个坑的地方是：

1.利用MappedByteBuffer.map文件时如果文件太大超过了Integer.MAX时(大约是2GB)就会报错：

所以这里需要分次将要写入的文件映射为内存文件。

2.这里有个bug，就是将文件映射到内存后，在写完就算clear了mappedByteBuffer，也不会释放内存，这时候就需要手动去释放，详细见上代码。
         */
    }
    /**
     *  批量压缩文件 v4.0
     *  https://commons.apache.org/proper/commons-compress/
     *  https://juejin.cn/post/6949355730814107661
     *  https://juejin.cn/post/6952794190107377677
     <dependency>
     <groupId>org.apache.commons</groupId>
     <artifactId>commons-compress</artifactId>
     <version>1.20</version>
     </dependency>
     <dependency>
     <groupId>commons-io</groupId>
     <artifactId>commons-io</artifactId>
     <version>2.4</version>
     <scope>compile</scope>
     </dependency>
     * @param fileNameList 需要压缩的文件名称列表(包含相对路径)
     * @param zipOutName 压缩后的文件名称
     **/
    public static void compressFileList(String zipOutName, List<String> fileNameList) throws IOException, ExecutionException, InterruptedException {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("compressFileList-pool-").build();
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), factory);
        ParallelScatterZipCreator parallelScatterZipCreator = new ParallelScatterZipCreator(executor);
        OutputStream outputStream = new FileOutputStream(zipOutName);
        ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
        zipArchiveOutputStream.setEncoding("UTF-8");
        for (String fileName : fileNameList) {
            File inFile = new File(fileName);
            final InputStreamSupplier inputStreamSupplier = () -> {
                try {
                    return new FileInputStream(inFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return new NullInputStream(0);
                }
            };
            ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(inFile.getName());
            zipArchiveEntry.setMethod(ZipArchiveEntry.DEFLATED);
            zipArchiveEntry.setSize(inFile.length());
            zipArchiveEntry.setUnixMode(UnixStat.FILE_FLAG | 436);
            parallelScatterZipCreator.addArchiveEntry(zipArchiveEntry, inputStreamSupplier);
        }
        parallelScatterZipCreator.writeTo(zipArchiveOutputStream);
        zipArchiveOutputStream.close();
        outputStream.close();
//        log.info("ParallelCompressUtil->ParallelCompressUtil-> info:{}", JSONObject.toJSONString(parallelScatterZipCreator.getStatisticsMessage()));
    }

}

