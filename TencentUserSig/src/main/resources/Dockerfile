FROM openjdk:15-jdk
ADD TencentUserSig-1.0-SNAPSHOT.jar api-tencentUserSig.jar
ADD application.yml application.yml
ADD application-prd.yml application-prd.yml
ADD application-dev.yml application-dev.yml
ENV JVM_ARGS -Dservice.name=${APP_NAME} -Duser.timezone=UTC
CMD ["java","-Duser.timezone=UTC","-Xmx1024M -jar","api-mail.jar"]
EXPOSE 6869
