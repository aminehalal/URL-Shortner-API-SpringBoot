package com.urlshortner.url.model.entity;

import com.urlshortner.url.util.RandomStringGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String url;

    @Column(unique = true)
    private String code;

    @Column()
    private Integer numVisits = 0;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        if (code == null || code.isEmpty()) {
            code = RandomStringGenerator.generateRandomString();
        }
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
