package com.nastya.images.controller;


import com.nastya.images.entity.TopicEntity;
import com.nastya.images.service.WorkService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private WorkService mainService;

    @GetMapping()
    public List<TopicEntity> getTopics() {
        return mainService.getTopics();
    }

    @PostMapping()
    public TopicEntity changeTopicName(@RequestBody TopicEntity topic) {
        return mainService.changeTopicName(topic);
    }

    @DeleteMapping()
    public String deleteTopic(@RequestParam @NotBlank String topicId) {
        return mainService.deleteTopic(topicId);
    }
}
