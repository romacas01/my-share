package com.rodrigo.myshare.model;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] bytes;

    private String name;
    private String description;

    @ManyToOne
    private Category category;
    private LocalDateTime dateUploaded = LocalDateTime.now();
    private String username;
    private String hash;
}
