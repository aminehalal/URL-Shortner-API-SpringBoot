package com.urlshortner.url.repository;

import com.urlshortner.url.model.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url,Integer> {
    Url findByCode(String code);
}
