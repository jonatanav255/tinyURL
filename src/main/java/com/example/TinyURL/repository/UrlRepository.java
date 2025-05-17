package com.example.TinyURL.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TinyURL.models.Url;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByCode(String code);
}