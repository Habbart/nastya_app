package com.nastya.images.controller;


import com.nastya.images.entity.Topic;
import com.nastya.images.service.TopicService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private TopicService topicService;

    @GetMapping()
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }

    @PostMapping()
    public Topic changeTopicName(@RequestBody Topic topic) {
        return topicService.changeTopicName(topic);
    }

    @DeleteMapping()
    public String deleteTopic(@RequestParam @NotBlank String topicId) {
        return topicService.deleteTopic(topicId);
    }
}
