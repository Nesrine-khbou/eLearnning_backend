package com.backend.application.DTO;

public class CourseDTO {
    private String title;
    private String image;
    private String detailsLink;
    private Long instructorId;
    private Long courseDetailsId;

    // Default Constructor
    public CourseDTO() {
    }

    // Parameterized Constructor
    public CourseDTO(String title, String image, String detailsLink, Long instructorId, Long courseDetailsId) {
        this.title = title;
        this.image = image;
        this.detailsLink = detailsLink;
        this.instructorId = instructorId;
        this.courseDetailsId = courseDetailsId;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Long getCourseDetailsId() {
        return courseDetailsId;
    }

    public void setCourseDetailsId(Long courseDetailsId) {
        this.courseDetailsId = courseDetailsId;
    }
}
