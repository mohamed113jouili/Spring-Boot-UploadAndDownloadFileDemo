# 1-Discription UploadAndDownloadFileDemo Project 

 Spring Boot 2.2.2.RELEASE  Upload/Download File to/from Database 

 tutorial how to upload and download files to/from database with a Spring Boot Rest APIs
 
 description of the project layer
 
 ##  com.file.dao : includes FileRepository.java and  FileU.java 
 ##  com.file.service : includes FileService.java and  FileServiceImp.java
 ##  com.file.web : includes  FileRestService.java
 ##  com.file.web.exeception : includes  AppExceptionHandeller.java,FileStorageException.java
 
 ![project](https://user-images.githubusercontent.com/61349826/97783082-98a59e80-1b95-11eb-8e8f-100a95b98b49.png)

 # 2- Configuration
 
 we need to change  path  in FileServiceImp , uploadDir="/Users/mac/Desktop/upload" to  uploadDir=".../..." 
 
 configuration the maximum and minimum file size and other to start the ExceptionHandler
 
 add in application.properties this ligne code 
 
# Enable multipart uploads
spring.servlet.multipart.enabled=true
# Threshold after which files are written to disk.
spring.servlet.multipart.file-size-threshold=2KB
# Max file size.
spring.servlet.multipart.max-file-size=100MB
# Max Request Size
spring.servlet.multipart.max-request-size=215MB
# enable request with large body 
spring.server.tomcat.max-swallow-size = -1 
# enable MaxUploadSizeExceededException with ExceptionHandler 
spring.servlet.multipart.resolve-lazily=true
 
 
 # 3-Test Postmean 

### Test  Upload file from server :success upload

![success](https://user-images.githubusercontent.com/61349826/97783084-9e02e900-1b95-11eb-94ca-41993e557445.png)

### Test  Upload file from server :error upload because file is null

![error](https://user-images.githubusercontent.com/61349826/97783088-a22f0680-1b95-11eb-97f9-45a75414f959.png)

## Test  Upload file from server (error upload because large  size file )

![EroorSize](https://user-images.githubusercontent.com/61349826/97783093-a824e780-1b95-11eb-832d-8105a7bc0f16.png)

## Test Download  file from server :success Downloads file

![download](https://user-images.githubusercontent.com/61349826/97783156-2aada700-1b96-11eb-87b8-78ec67e5e612.png)

## Test Download  file from server :error download because  file does not exist 

 ![errorDownload](https://user-images.githubusercontent.com/61349826/97783671-9cd3bb00-1b99-11eb-9f53-b16283e07fa4.png)

 

 
 
 
 


