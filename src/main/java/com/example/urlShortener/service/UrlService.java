package com.example.urlShortener.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.urlShortener.dto.ResponseDto;
import com.example.urlShortener.entity.UrlEntity;
import com.example.urlShortener.repository.UrlRepository;
import com.example.urlShortener.util.UrlValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {
	
	private final UrlRepository urlRepository;
//	private final UrlValidation urlValidation;

	public ResponseDto create(String url) {
		//validate url
		//save url if it didn't exist
		//create random string
		Optional<UrlEntity> byFullUrlString = urlRepository.findByFullUrlString(url);
		
		if(byFullUrlString == null) {
			urlRepository.save(null);
		}
		
		String shortcode = "TODO";
		ResponseDto responseDto = new ResponseDto();
		responseDto.setShortCode(shortcode);
		return responseDto;
	}

	public String geturl(String shortCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
