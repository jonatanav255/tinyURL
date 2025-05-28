package com.example.TinyURL.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.TinyURL.dto.ShortenRequest;
import com.example.TinyURL.dto.ShortenResponse;
import com.example.TinyURL.models.Url;
import com.example.TinyURL.service.UrlService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/urls")
@Tag(name = "URL Controller", description = "Endpoints for shortening and redirecting URLs")
public class UrlController {

    // private final UrlRepository urlRepo;
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // POST /api/urls — shorten a new URL
    @PostMapping
    @Operation(
            summary = "Shorten a URL",
            description = "Takes an original URL and returns an 8-character code along with the full short URL",
            responses = {
                @ApiResponse(responseCode = "200", description = "Shortening succeeded"),
                @ApiResponse(responseCode = "400", description = "Validation failed (e.g. blank or malformed URL)")
            }
    )
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

    // // GET /{code} — redirect to the original URL
    // @GetMapping("/{code}")
    // public ResponseEntity<Void> redirectToOriginal(@PathVariable String code) {
    //     return ResponseEntity.notFound().build();
    // }
    // GET /api/urls/{code} — redirect
    @GetMapping("/{code}")
    @Operation(
            summary = "Redirect to original",
            description = "Looks up the code and issues an HTTP 302 redirect to the original URL",
            responses = {
                @ApiResponse(responseCode = "302", description = "Redirecting to original URL"),
                @ApiResponse(responseCode = "404", description = "Code not found")
            }
    )
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String code) {
        return urlService.findByCode(code)
                .map(url
                        -> ResponseEntity
                        .status(HttpStatus.FOUND)
                        .location(URI.create(url.getOriginalUrl()))
                        .<Void>build() // ← hint Void here
                )
                .orElseGet(()
                        -> ResponseEntity
                        .notFound()
                        .<Void>build() // ← …and Void here
                );
    }

    @GetMapping("/test-error")
    public void triggerError() {
        throw new IllegalStateException("This is a test error");
    }
}
