package com.example.TinyURL.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.TinyURL.models.Url;
import com.example.TinyURL.repository.UrlRepository;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlRepository urlRepo;

    public UrlController(UrlRepository urlRepo) {
        this.urlRepo = urlRepo;
    }

    // GET /api/urls — retrieve all URL entries
    @GetMapping
    public List<Url> getAllUrls() {
        return urlRepo.findAll();
    }
}