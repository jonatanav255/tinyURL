package com.example.TinyURL.service;

import com.example.TinyURL.models.Url;

public interface UrlService {

    Url shorten(String originalUrl);
}
