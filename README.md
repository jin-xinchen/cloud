# cloud
# 1. Enabling automatic build in IntelliJ Community
## 1.1 Enabling automatic build
>File->Settings->Build,Execution,Deployment->Compiler->choose
 + Automatically show first error in editor; 
 +  Display notification on build completion; 
 +  Build project automatically;
 +  Compile independent mdules in parallel;

## 1.2 Update the value of
>press ctrl+shift+Alt+/ and search for the registry in Intellj. 
 In the Registry, enable:
  compiler.automake.allow.when.app.running and actionSystem.assertFocusAccessFromEdt.

*Note： restart IntelliJ*

## 1.3 Adding devtools to your project

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
      <optional>true</optional>
    </dependency>

## 1.4 Adding plugin to your pom.xml

    <build>
      <plugins>
        <plugin>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-maven-plugin</artifactId>
          <configuration>
            <excludes>
              <exclude>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
              </exclude>
              <exclude>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-configuration-processor</artifactId>
              </exclude>
            </excludes>
            <fork>true</fork>
            <addResources>true</addResources>
          </configuration>
        </plugin>
      </plugins>
    </build>


# 2. IntelliJ Workspace
## 2.1 Editor Encoding: UTF-8
 >File->Settings->Editor->File Encodings -> Global Encoding: UTF-8; Project Encoding: UTF-8; Default encoding for properties files: UTF-8; Transparent native-to-ascii conversion (checked)
## 2.2 Enable annotation processing
  >File->Build,Execution,Deployment->Compiler->Annotation Processors->Enable annotation processing(checked)

## 2.3 Java Compilerjava
  >File->Build,Execution,Deployment->Compiler->Java Compiler->Module,Target bytecode version = 8;
  
## 2.4 File Type 
  >

tools: https ://md.openwrite.cn

