//package com.majorproject.ecommerce_web.service;
//
//import java.io.File;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service
//public class fileService {
//
//	@Value("${File.upload-dir:./uploads}")
//	private String baseStoragePath;
//	
//	
//	@Value("${app.max-file-size}")
//	private long FileMaxSize;
//	
//	
//	@PostConstruct
//	public void init() {
//		
//		log.info("Initializing base storage directory : {} ",baseStoragePath);
//		File baseDir = new File(baseStoragePath);
//		
//		if(!baseDir.exists()) {
//			boolean  created =baseDir.mkdirs();
//		 log.info("Storage directory created :{}",created);	
//		
//		}else {
//			log.info("Storage directory already existes.");
//			
//		}		
//	}
//	
//	public String saveFile (MultipartFile file, String subFolder) {
//		
//		va
//		
//		
//		
//		
//		return subFolder;
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//}
