package com.backend.application.DTO;

import org.springframework.web.multipart.MultipartFile;

public class InstructorResponse {

    private Long id;
    private String name;
    private String email;
    private String image;
    private String description;
    private String headline;

    public InstructorResponse(Long id, String name, String email, String image, String description, String headline) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.description = description;
        this.headline = headline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}