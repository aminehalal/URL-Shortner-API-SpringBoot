package com.urlshortner.url.controller;

import com.urlshortner.url.model.dto.UrlCodeDTO;
import com.urlshortner.url.model.dto.UrlDTO;
import com.urlshortner.url.model.entity.Url;
import com.urlshortner.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    private UrlService urlService;

    // http://localhost:8080/api/url
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/url")
    public UrlCodeDTO createShortUrl(@RequestBody Url url) {
        return urlService.saveUrl(url);
    }

    // http://localhost:8080/api/get-url?code=w3IVIJJ
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-url")
    public UrlDTO getUrl(@RequestParam("code") String code) {
        return urlService.findByCode(code);
    }
}
