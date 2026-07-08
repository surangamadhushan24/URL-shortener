package com.example.urlShortener.service;

import java.net.URI;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.example.urlShortener.dto.ResponseDto;
import com.example.urlShortener.entity.UrlEntity;
import com.example.urlShortener.repository.UrlRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {
	
	private final UrlRepository urlRepository;
//	private final UrlValidation urlValidation;

	public ResponseDto create(String url) {
		//validate url
		
		Optional<UrlEntity> exsistingUrlString = urlRepository.findByFullUrlString(url);
		System.out.println(exsistingUrlString);
		ResponseDto responseDto = new ResponseDto();
		
		if(exsistingUrlString.isEmpty()) {
			String shortcode = RandomStringUtils.secure().nextAlphanumeric(5);
			System.out.println("shortcode is" + shortcode);
			UrlEntity urlEntity = new UrlEntity();
			urlEntity.setFullUrlString(url);
			urlEntity.setShortcode(shortcode);
			
			urlRepository.save(urlEntity);	
			responseDto.setShortCode(urlEntity.getShortcode());
			return responseDto;
				
		}	
		responseDto.setShortCode(exsistingUrlString.get().getShortcode());
		return responseDto;
	}


	public URI getRederctionUri(String shortCode) {
		// TODO Auto-generated method stub
		String urlToBeParsed = urlRepository.findByShortcode(shortCode)
				.map(UrlEntity::getFullUrlString)
				.orElse("/")
				.trim();
		  System.out.println("URL = [" + urlToBeParsed + "]");
		return URI.create(urlToBeParsed);
	}

}
