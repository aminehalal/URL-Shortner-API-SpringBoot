package com.urlshortner.url.controller;

import com.urlshortner.url.model.dto.UrlDTO;
import com.urlshortner.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/")
public class ShortingUrlController {

    @Autowired
    private UrlService urlService;



    // http://localhost:8080/w3IVIJJ
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{code}")
    public ResponseEntity<Void> getUrl(@PathVariable String code) {
        urlService.incrementNumVisits(code);
        UrlDTO url = urlService.findByCode(code);
        if (url != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(url.getUrl()));
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
