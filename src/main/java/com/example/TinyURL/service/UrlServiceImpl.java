package com.example.TinyURL.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.TinyURL.models.Url;
import com.example.TinyURL.repository.UrlRepository;

import jakarta.transaction.Transactional;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepo;

    public UrlServiceImpl(UrlRepository urlRepo) {
        this.urlRepo = urlRepo;
    }

    @Override
    @Transactional
    public Url shorten(String originalUrl) {
        // Generate an 8-char random code; we'll refine this later
        String code = UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 8);
        Url url = new Url(code, originalUrl);
        return urlRepo.save(url);
    }
}
