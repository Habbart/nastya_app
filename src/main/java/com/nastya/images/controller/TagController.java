package com.nastya.images.controller;


import com.nastya.images.dto.TopicDto;
import com.nastya.images.service.TagService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TagController {

    private TagService tagService;

    @GetMapping()
    public List<String> getTopics() {
        return tagService.getAllTags();
    }

    @PostMapping()
    public String changeTopicName(@RequestBody TopicDto topic) {
        return tagService.changeTagName(topic);
    }

    @DeleteMapping()
    public String deleteTopic(@RequestParam @NotBlank String tagName) {
        return tagService.deleteTag(tagName);
    }
}
