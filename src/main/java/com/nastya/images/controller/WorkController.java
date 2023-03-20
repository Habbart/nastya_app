package com.nastya.images.controller;


import com.nastya.images.entity.WorkEntity;
import com.nastya.images.service.WorkService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
@RequiredArgsConstructor
public class WorkController {

    private WorkService mainService;


    @GetMapping()
    public List<WorkEntity> getWorks(@RequestParam(required = false) List<String> topicIds) {
        //todo надо передавать имя топика а не id, переделать на имя
        return mainService.getWorks(topicIds);
    }

    @PostMapping()
    public WorkEntity changeWork(@RequestBody WorkEntity image) {
        return mainService.changeWork(image);
    }

    @DeleteMapping()
    public Boolean changeWork(@RequestParam @NotBlank String workId,
                             @RequestParam(required = false) String imageId) {
        return mainService.deleteWorkOrImage(workId, imageId);
    }


}
