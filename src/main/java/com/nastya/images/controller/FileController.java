package com.nastya.images.controller;

import com.nastya.images.dto.ImageDto;
import com.nastya.images.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class FileController {

    public static final String BANNER = "banner";
    private FileService fileService;

    @PostMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String uploadImage(@RequestBody ImageDto dto) {
        return fileService.uploadImage(dto);
    }

    @GetMapping("/{fileName}")
    public ImageDto downloadImage(@PathVariable("fileName") String fileName) {
        return fileService.downloadImage(fileName);
    }

    @GetMapping("/banners")
    public ImageDto getBanners() {
        return fileService.downloadImage(BANNER);
    }
}
