package com.storage.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	
	public final String DIRETORIO = "/app/pdfs/";
	
	public void salvarArquivo(MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get("/app/pdfs/"+file.getOriginalFilename());
		Files.write(path, bytes);
	}
	
}
