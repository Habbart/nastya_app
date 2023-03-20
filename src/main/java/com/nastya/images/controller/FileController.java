package com.nastya.images.controller;

import com.nastya.images.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class FileController {

    private FileService fileService;

    @PostMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String uploadImage(@RequestBody MultipartFile imageFile, @PathVariable("id") String id) throws IOException {
        return fileService.uploadImage(imageFile, id);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> downloadImage(@PathVariable("fileName") String fileName) {
        return ResponseEntity.ok(fileService.downloadImage(fileName));
    }


}
