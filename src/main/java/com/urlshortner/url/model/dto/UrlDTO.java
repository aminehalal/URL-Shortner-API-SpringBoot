package com.urlshortner.url.model.dto;

import com.urlshortner.url.model.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlDTO {

    private Integer id;
    private String url;
    private String code;
    private Integer numVisits;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static UrlDTO fromEntityToDTO(Url url) {
        return UrlDTO.builder()
                .id(url.getId())
                .url(url.getUrl())
                .code(url.getCode())
                .numVisits(url.getNumVisits())
                .createdAt(url.getCreatedAt())
                .updatedAt(url.getUpdatedAt())
                .build();
    }


}
