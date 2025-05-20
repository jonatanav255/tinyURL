package com.example.TinyURL.service;

import java.util.Optional;

import com.example.TinyURL.models.Url;

public interface UrlService {

    Url shorten(String originalUrl);
    Optional<Url> findByCode(String code);
}
