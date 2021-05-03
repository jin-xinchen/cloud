package jin.tool.annotation;

@PrintMsg(count = 2020)
public class AnnotationTest {
    public static void main(String[] args) {
        PrintMsg annotation = AnnotationTest.class.getAnnotation(PrintMsg.class);
        System.out.println(annotation.count());
        System.out.println(annotation.name());
    }
}
//G:\ideaIU\ideaProjects\cookcode\src\main\java>javac com\hustdj\jdkStudy\annotation\PrintMsg.java
// G:\ideaIU\ideaProjects\cookcode\src\main\java>javac com\hustdj\jdkStudy\annotation\PrintNameProcessor.java
// G:\ideaIU\ideaProjects\cookcode\src\main\java>
//  javac -processor com.hustdj.jdkStudy.annotation.PrintNameProcessor com\hustdj\jdkStudy\annotation\AnnotationTest.java
// 警告: 来自注释处理程序
// 'com.hustdj.jdkStudy.annotation.PrintNameProcessor' 的受支持 source 版本
// 'RELEASE_8' 低于 -source '1.9'注: my name is com.hustdj.jdkStudy.annotation.AnnotationTest
// 1 个警告
//demo annotation
