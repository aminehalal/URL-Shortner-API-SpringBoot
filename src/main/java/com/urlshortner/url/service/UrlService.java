package com.urlshortner.url.service;

import com.urlshortner.url.model.dto.UrlCodeDTO;
import com.urlshortner.url.model.dto.UrlDTO;
import com.urlshortner.url.model.entity.Url;
import com.urlshortner.url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;


    public UrlCodeDTO saveUrl(Url url){
        urlRepository.save(url);
        return new UrlCodeDTO(url.getCode()) ;
    }

    @Transactional
    public void incrementNumVisits(String code) {
        Url url = urlRepository.findByCode(code);
        if (url != null) {
            url.setNumVisits(url.getNumVisits() + 1);
            urlRepository.save(url);
        }
    }

    public UrlDTO findByCode(String code){
        return UrlDTO.fromEntityToDTO(urlRepository.findByCode(code));
    }

}
