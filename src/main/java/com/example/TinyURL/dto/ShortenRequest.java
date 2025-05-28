package com.example.TinyURL.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(name = "ShortenRequest", description = "Payload to create a new short URL")
public class ShortenRequest {

    @Schema(
            description = "The long URL to shorten",
            example = "https://example.com/page"
    )
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
