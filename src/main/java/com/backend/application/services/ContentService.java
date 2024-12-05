package com.backend.application.services;

import com.backend.application.entities.Content;
import com.backend.application.repositories.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public Optional<Content> getContentById(Long id) {
        return contentRepository.findById(id);
    }

    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }

    public Content updateContent(Long id, Content contentRequest) {
        Content existingContent = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id: " + id));

        existingContent.setTitle(contentRequest.getTitle());
        existingContent.setVideoUrl(contentRequest.getVideoUrl());
        existingContent.setCategory(contentRequest.getCategory());
        existingContent.setCourse(contentRequest.getCourse());
        existingContent.setVideoDuration(contentRequest.getVideoDuration()); // Update the video duration

        return contentRepository.save(existingContent);
    }
}
