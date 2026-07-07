package com.example.urlShortener.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlShortener.dto.ResponseDto;
import com.example.urlShortener.service.UrlService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UrlController {
	
	private final UrlService urlService;
	
	
	@PostMapping("/shorten")
	public ResponseDto createUrl(@RequestBody String url) {
		return urlService.create(url);
		
	}
	
	@GetMapping("/{shortCode}")
	public String getUrl(@RequestBody String shortCode) {
		return urlService.geturl(shortCode);
	
	}
	

}
