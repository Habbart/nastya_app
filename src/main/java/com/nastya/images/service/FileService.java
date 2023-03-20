package com.nastya.images.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;


@Service
@Slf4j
public class FileService {


    private final Path imageStorageDir;
    private final String pathFromParams;

    public FileService(@Value("${image-storage-dir}") String pathFromParams) {
        this.imageStorageDir = Path.of(pathFromParams);;
        this.pathFromParams = pathFromParams;
    }

//    @PostConstruct
//    public void ensureDirectoryExists() throws IOException {
//        if (!Files.exists(this.imageStorageDir)) {
//            Files.createDirectories(this.imageStorageDir);
//        }
//    }

    public String uploadImage(MultipartFile file, String id){
        final String fileExtension = Optional.ofNullable(file.getOriginalFilename())
                .flatMap(FileService::getFileExtension)
                .orElse("");

        final String targetFileName = id + "." + fileExtension;
        final Path targetPath = this.imageStorageDir.resolve(targetFileName);

        try (InputStream in = file.getInputStream()) {
            try (OutputStream outputStream = Files.newOutputStream(targetPath, StandardOpenOption.CREATE)) {
                in.transferTo(outputStream);
            }
        } catch (IOException e){
            log.error("Ошибка при сохранении файла" + e);
        }

        return targetFileName;
    }

    public Resource downloadImage(String fileName) {
        final Path targetPath = this.imageStorageDir.resolve(fileName);
        if (!Files.exists(targetPath)) {
            throw new IllegalArgumentException("Нет файла с таким именем");
        }
        return new PathResource(targetPath);
    }

    private static Optional<String> getFileExtension(String fileName) {
        final int indexOfLastDot = fileName.lastIndexOf('.');

        if (indexOfLastDot == -1) {
            return Optional.empty();
        } else {
            return Optional.of(fileName.substring(indexOfLastDot + 1));
        }
    }
}
