package com.file.service;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import  org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.dao.FileRepository;
import com.file.dao.FileU;
import com.file.web.exeception.FileStorageException;




@Service
public class FileServiceImp implements FileService {
    public String uploadDir="/Users/mac/Desktop/upload";
    
    @Autowired
    FileRepository fileRespository;

	@Override
	public void uploadFile(MultipartFile file)   {
		
		String p=StringUtils.cleanPath(file.getOriginalFilename());

		 Path copyLocation=Paths.get(uploadDir + File.separator + p);
		 
		
		 
		 //System.out.println("Path..."+ copyLocation);
		    try {
				Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
				
				
				// save file in data base 
				saveFile(p);
				
				 
			} catch (IOException e) {
			
				//System.out.println("empty file ...");
				//e.printStackTrace();

	           throw new FileStorageException("Could not store file " + file.getOriginalFilename()
               + ". Please try again!");

			}         
	}

	@Override
	public Resource DownloadFile(String fileName) {
		// Load file as Resource
        Resource resource = loadFileAsResource(fileName);

       
        
        return resource;
	}

	@Override
	public void saveFile(String p) {
		
		String url="http://localhost:8080/downloadFile/"+p;
		 FileU fileU=new FileU(getNameFromPath(p), url);
		 fileRespository.save(fileU);
		
	}
	

	@Override
	public List<FileU> getAllFiles() {
	
		return fileRespository.findAll();
	}

	@Override
	public void deleteFileByid(long id) {

      fileRespository.deleteById(id);
		
	}
	
	String getNameFromPath(String path){
		 
		int index=path.indexOf(".");
	
		
		return path.substring(0, index);
	}
	
	public Resource loadFileAsResource(String fileName) {
	    
		 Path filePath=Paths.get(uploadDir + File.separator + fileName);
		 try {
		
	         Resource resource = new UrlResource(filePath.toUri());
	         
	         if(resource.exists()) {
	                return resource;
	            } else {
	                throw new FileStorageException("Could not download file " + fileName
	     	               + ". Please try again!");
	            }
		 }
		 
		 catch (MalformedURLException ex) {
	            //throw new MyFileNotFoundException("File not found " + fileName, ex);
	            throw new FileStorageException("Could not download file " + fileName
	               + ". Please try again!");
	        }

		
		
	}
	
	

}




