package com.nastya.images.controller;


import com.nastya.images.dto.WorkDto;
import com.nastya.images.dto.WorkDtoWithTags;
import com.nastya.images.service.WorkService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/works")
@RequiredArgsConstructor
public class WorkController {

    private final WorkService mainService;

    @GetMapping()
    public WorkDtoWithTags getWorks(@RequestParam(required = false) List<String> topicIds) {
        if (topicIds == null) {
            topicIds = Collections.emptyList();
        }
        return mainService.getWorks(topicIds);
    }

    @PostMapping()
    public WorkDto changeWork(@RequestBody WorkDto image) {
        return mainService.changeWork(image);
    }

    @DeleteMapping()
    public Boolean deleteWork(@RequestParam @NotBlank String workId,
                              @RequestParam(required = false) String imageId) {
        return mainService.deleteWorkOrImage(workId, imageId);
    }

}
