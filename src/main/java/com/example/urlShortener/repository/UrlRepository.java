package com.example.urlShortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.urlShortener.entity.UrlEntity;
import java.util.List;


@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
	
	Optional<UrlEntity> findByFullUrlString(String fullUrlString);

}
