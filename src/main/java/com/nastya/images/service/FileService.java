package com.nastya.images.service;

import com.nastya.images.dao.ImageDao;
import com.nastya.images.dto.ImageDto;
import com.nastya.images.entity.ImageEntity;
import com.nastya.images.exception.DeleteFileException;
import com.nastya.images.exception.NoImagesFoundException;
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

    private final ImageDao imageDao;
    private final Path imageStorageDir;
    private final String pathFromParams;

    public FileService(@Value("${image-storage-dir}") String pathFromParams, ImageDao imageDao) {
        this.imageStorageDir = Path.of(pathFromParams);;
        this.pathFromParams = pathFromParams;
        this.imageDao = imageDao;
    }

//    @PostConstruct
//    public void ensureDirectoryExists() throws IOException {
//        if (!Files.exists(this.imageStorageDir)) {
//            Files.createDirectories(this.imageStorageDir);
//        }
//    }

    public String uploadImage(ImageDto dto){
        //todo добавить валидацию дто
        final String fileExtension = Optional.ofNullable(dto.getName())
                .flatMap(FileService::getFileExtension)
                .orElse("");

        final String targetFileName = dto.getFrontId() + "." + fileExtension;
        final Path targetPath = this.imageStorageDir.resolve(targetFileName);

        try (OutputStream outputStream = Files.newOutputStream(targetPath, StandardOpenOption.CREATE)) {
            outputStream.write(dto.getContent());
        } catch (IOException e){
            log.error("Ошибка при сохранении файла" + e);
        }

        return targetFileName;
    }

    public ImageDto downloadImage(String fileName) {
        final Path targetPath = this.imageStorageDir.resolve(fileName);
        if (!Files.exists(targetPath)) {
            throw new IllegalArgumentException("Нет файла с таким именем");
        }
        PathResource pathResource = new PathResource(targetPath);
        ImageDto resultDto = new ImageDto();
        resultDto.setName(pathResource.getFilename());
        ImageEntity imageEntity = imageDao.findByPath(fileName);
        String frontId = imageEntity.getFrontId();
        resultDto.setFrontId(frontId);
        try(InputStream in = pathResource.getInputStream()){
            byte[] content = in.readAllBytes();
            resultDto.setContent(content);
        } catch (IOException e){
            log.error("Ошибка при сохранении файла" + e);
        }
        return resultDto;
    }

    private static Optional<String> getFileExtension(String fileName) {
        final int indexOfLastDot = fileName.lastIndexOf('.');

        if (indexOfLastDot == -1) {
            return Optional.empty();
        } else {
            return Optional.of(fileName.substring(indexOfLastDot + 1));
        }
    }

    public void deleteFileFromDisc(String filename) {
        final Path targetPath = this.imageStorageDir.resolve(filename);
        if (!Files.exists(targetPath)) {
            return;
        }
        try {
            Files.delete(targetPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DeleteFileException(String.format("Ошибка при удалении файла %s", filename));
        }
    }
}
