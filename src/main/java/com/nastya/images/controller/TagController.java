package com.nastya.images.controller;


import com.nastya.images.dto.TagDto;
import com.nastya.images.service.TagService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private TagService tagService;

    @GetMapping()
    public List<String> getTags() {
        return tagService.getAllTags();
    }

    @PostMapping()
    public String changeTagName(@RequestBody TagDto tag) {
        return tagService.changeTagName(tag);
    }

    @DeleteMapping()
    public String deleteTag(@RequestParam @NotBlank String tagName) {
        return tagService.deleteTag(tagName);
    }
}
