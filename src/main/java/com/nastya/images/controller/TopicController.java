package com.nastya.images.controller;


import com.nastya.images.entity.Image;
import com.nastya.images.entity.ImageType;
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
    public List<ImageType> getTopics() {
        return mainService.getTopics();
    }

    @PostMapping()
    public Image changeTopicName(@RequestBody ImageType imageType){
        return mainService.changeTopicName(imageType);
    }

    @DeleteMapping()
    public String deleteTopic(@RequestParam @NotBlank String topicId){
        return mainService.deleteTopic(topicId);
    }
}
