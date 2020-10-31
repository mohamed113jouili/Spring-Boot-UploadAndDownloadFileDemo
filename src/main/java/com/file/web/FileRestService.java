package com.file.web;




import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.file.dao.FileRepository;
import com.file.dao.FileU;
import com.file.service.FileService;
import com.file.web.modeles.ApiError;

import org.springframework.core.io.Resource;



@CrossOrigin("*")
@RestController
public class FileRestService {
	@Autowired
	FileRepository fileRepository;
	
	
	@Autowired
	FileService fileService;
	
	//upload file
	
	@RequestMapping(value="/upload/file",method=RequestMethod.POST)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws MaxUploadSizeExceededException {
		
	
		fileService.uploadFile(file);
		
		 
		 ApiError apiError = new ApiError(HttpStatus.OK, "Success", "success upload");
		 
		//ResponseFile responseFile=new ResponseFile(apiError, "");
			
		
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	
	
	
	
	//download file
	
	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		
		 // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(fileService.DownloadFile(fileName).getFile().getAbsolutePath());
        } catch (IOException ex) {
            //info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileService.DownloadFile(fileName).getFilename() + "\"")
                .body(fileService.DownloadFile(fileName));
	}

	

	// get all files
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public List<FileU> getFiles() {

		return fileService.getAllFiles();

	}
	
	
	
	// delete file by id 
		@RequestMapping(value = "/file/{id}", method = RequestMethod.DELETE)
		public boolean deletefileByid(@PathVariable Long id) {

           fileService.deleteFileByid(id);
			return true;

		}
	
	
	
    String	getUrlFromFile(MultipartFile file){
	 String p=StringUtils.cleanPath(file.getOriginalFilename());

	
	     return p;
}


	
	
}
