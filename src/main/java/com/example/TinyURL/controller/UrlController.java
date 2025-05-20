package com.example.TinyURL.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.TinyURL.models.Url;
import com.example.TinyURL.repository.UrlRepository;
import com.example.TinyURL.service.UrlService;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    // private final UrlRepository urlRepo;
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // GET /api/urls — retrieve all URL entries
    // @GetMapping
    // public List<Url> getAllUrls() {
    //     return urlRepo.findAll();
    // }
}