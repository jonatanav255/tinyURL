package com.example.TinyURL.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ShortenRequest {

    @NotBlank(message = "URL must not be empty")
    @Pattern(
            regexp = "https?://.+",
            message = "Must be a valid HTTP or HTTPS URL"
    )
    private String originalUrl;

    // JAX-B / Jackson needs a no-arg constructor
    public ShortenRequest() {
    }

    // getters & setters
    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

}
