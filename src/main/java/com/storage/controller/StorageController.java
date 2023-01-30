package com.storage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.storage.service.StorageService;

@RestController
@RequestMapping("/api/storages")
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?>armazenaPdf(@RequestParam("file") MultipartFile file){
		try {
			storageService.salvarArquivo(file);
			return ResponseEntity.ok().body("Arquivo Pdf gravado com sucesso!!");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro ao gravar o arquivo");
		}
	}
	
}
