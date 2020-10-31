package com.file.service;


import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.file.dao.FileU;

public interface FileService {
	
	
	void saveFile(String path);
	
	 List<FileU> getAllFiles();
	 
	 void deleteFileByid(long id);
	 
	 void uploadFile(MultipartFile file) ;
		
	 Resource DownloadFile(String fileName);

}
