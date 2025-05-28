package com.example.TinyURL.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ShortenResponse", description = "Response containing the short code and full URL")
public class ShortenResponse {

    @Schema(description = "The 8-character short code", example = "a1b2c3d4")
    private String code;

    @Schema(description = "Publicly accessible short URL", example = "http://localhost:8080/a1b2c3d4")
    private String shortUrl;

    public ShortenResponse() {
    }

    public ShortenResponse(String code, String shortUrl) {
        this.code = code;
        this.shortUrl = shortUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

}
