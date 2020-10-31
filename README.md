# UploadAndDownloadFileDemo

 Spring Boot Upload/Download File to/from Database example

 tutorial how to upload and download files to/from database with a Spring Boot Rest APIs
 
 description of the project layer
 
 ## 1- com.file.dao : includes FileRepository.java and  FileU.java 
 ## 2- com.file.service : includes FileService.java and  FileServiceImp.java
 ## 3- com.file.web : includes  FileRestService.java
 ## 3.1- com.file.web.exeception : contient AppExceptionHandeller.java,FileStorageException.java
 
 ![project](https://user-images.githubusercontent.com/61349826/97783082-98a59e80-1b95-11eb-8e8f-100a95b98b49.png)

 # Configuration
 
 we need to change  path  in FileServiceImp , uploadDir="/Users/mac/Desktop/upload" to  uploadDir=".../..." 
 
 configuration the maximum and minimum file size and other to start the ExceptionHandler
 
 add in application.properties this ligne code 
 
spring.servlet.multipart.enabled=true
spring.servlet.multipart.file-size-threshold=2KB
spring.servlet.multipart.max-file-size=100MB
spring.servlet.multipart.max-request-size=215MB
spring.server.tomcat.max-swallow-size = -1 
spring.servlet.multipart.resolve-lazily=true
 
 
 # Test Postmean 

## Test  Upload file in server :success upload

![success](https://user-images.githubusercontent.com/61349826/97783084-9e02e900-1b95-11eb-94ca-41993e557445.png)

## Test  Upload file in server :error upload because file is null

![error](https://user-images.githubusercontent.com/61349826/97783088-a22f0680-1b95-11eb-97f9-45a75414f959.png)

## Test  Upload file in server (error upload because large  size file )

![EroorSize](https://user-images.githubusercontent.com/61349826/97783093-a824e780-1b95-11eb-832d-8105a7bc0f16.png)

## Test Download  file in server :success Downloads file

![download](https://user-images.githubusercontent.com/61349826/97783156-2aada700-1b96-11eb-87b8-78ec67e5e612.png)

 
 

 
 
 
 


