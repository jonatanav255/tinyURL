package com.example.TinyURL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.TinyURL.dto.ShortenRequest;
import com.example.TinyURL.dto.ShortenResponse;
import com.example.TinyURL.models.Url;
import com.example.TinyURL.service.UrlService;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    // private final UrlRepository urlRepo;
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // POST /api/urls — shorten a new URL
        @PostMapping
        public ResponseEntity<ShortenResponse> shortenUrl(@Valid @RequestBody ShortenRequest req) {
            // 1) Delegate to service to create & save the Url entity
            Url saved = urlService.shorten(req.getOriginalUrl());

            // 2) Build the public short URL
            String fullShort = "http://localhost:8080/" + saved.getCode();

            // 3) Wrap into response DTO
            ShortenResponse resp = new ShortenResponse(saved.getCode(), fullShort);

            // 4) Return 200 OK with the DTO as JSON
            return ResponseEntity.ok(resp);
        }

    // GET /api/urls — retrieve all URL entries
    // @GetMapping
    // public List<Url> getAllUrls() {
    //     return urlRepo.findAll();
    // }
}
