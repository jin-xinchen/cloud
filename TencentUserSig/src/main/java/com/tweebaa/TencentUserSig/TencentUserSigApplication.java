package com.tweebaa.TencentUserSig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
public class TencentUserSigApplication {
    public static void main(String[] args) {
     var cxt = SpringApplication.run(TencentUserSigApplication.class,args);
    }

}
/*
tbConfig:
  sdkAppId: 1600524662
  secretKey: 42f2167fa79b9bf8ec22c9ea7a1d9ea70fa6a78be421118151b0bb31f3775c28
  expire: 604800
https://cloud.tencent.com/document/product/269/32688
https://search.maven.org/artifact/com.github.tencentyun/tls-sig-api-v2/2.0/jar


mkdir tencent
scp C:/Users/JinTweebaa/Documents/tweebaa/cloud/TencentUserSig/src/main/resources/application.yml jin@47.101.219.248:/home/jin/tencent

scp C:/Users/JinTweebaa/Documents/tweebaa/cloud/TencentUserSig/src/main/resources/application-prd.yml jin@47.101.219.248:/home/jin/tencent
scp C:/Users/JinTweebaa/Documents/tweebaa/cloud/TencentUserSig/src/main/resources/application-dev.yml jin@47.101.219.248:/home/jin/tencent
scp C:/Users/JinTweebaa/Documents/tweebaa/cloud/TencentUserSig/src/main/resources/Dockerfile jin@47.101.219.248:/home/jin/tencent

scp C:\Users\JinTweebaa\Documents\tweebaa\cloud\TencentUserSig\target\TencentUserSig-1.0-SNAPSHOT.jar jin@47.101.219.248:/home/jin/tencent

sudo docker build -t api-tencentusersig:v1 .

sudo docker run --name api-tencentusersig -d -p 6869:6869 api-tencentusersig:v1 java -Duser.timezone=UTC -jar api-tencentUserSig.jar --tbConfig.sdkAppId=1400526442 --tbConfig.secretKey=62f2147fa79b9bf8ec22c9ea7a1d9ea70fa4a78be621118151b0bb31f3775c28
sudo docker run --name api-tencentusersig -p 6869:6869 api-tencentusersig:v1 java -Duser.timezone=UTC -jar api-tencentUserSig.jar --tbConfig.sdkAppId=1400526442 --tbConfig.secretKey=62f2147fa79b9bf8ec22c9ea7a1d9ea70fa4a78be621118151b0bb31f3775c28

sudo docker rm -f -v api-tencentusersig

 */
