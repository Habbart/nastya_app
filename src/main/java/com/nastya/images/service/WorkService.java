package com.nastya.images.service;

import com.nastya.images.dao.ImageDao;
import com.nastya.images.dao.WorkDao;
import com.nastya.images.dto.ImageDto;
import com.nastya.images.dto.WorkDto;
import com.nastya.images.dto.WorkDtoWithTags;
import com.nastya.images.entity.ImageEntity;
import com.nastya.images.entity.WorkEntity;
import com.nastya.images.exception.CoverDoulbedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.nastya.images.Constants.WHOOPS;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkService {

    private final WorkDao workDao;
    private final ImageDao imageDao;
    private final FileService fileService;
    private final TagService tagService;


    public WorkDtoWithTags getWorks(List<String> topicIds) {
        List<WorkEntity> workEntities = new ArrayList<>();
        try {
            if (topicIds.isEmpty()) {
                workEntities = workDao.findAll();
            } else {
                workEntities = workDao.findByWorkTopicsIn(topicIds);
            }
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        /*
        проходим по каждому workEntity
        у каждой сущноти ищем картинку-сущность с отметкой, что оно на обложке
        у остальные картинок-сущностей берём айдишники и складываем в imagesIds
        вытаскиваем картинку по названию картинки-сущности
        формируем ImageDto
        вытаскивае все теги и складываем в список тэгов
        формируем WorkDto
         */

        List<WorkDto> dtos = new ArrayList<>();
        for (WorkEntity workEntity : workEntities) {

            ImageDto imageDto = null;
            List<String> imagesIds = new ArrayList<>();
            boolean isFound = false;
            for (ImageEntity portfolioImage : workEntity.getPortfolioImages()) {
                String imageId = portfolioImage.getFrontId();
                imagesIds.add(imageId);
                if (portfolioImage.isCoverArt()) {
                    String path = portfolioImage.getPath();
                    if (isFound) {
                        throw new CoverDoulbedException(String.format("Найден второй файл с флагом обложки: %s", path));
                    }
                    //при обращении два раза ходим в базу -> возможное место для оптимизации
                    imageDto = fileService.downloadImage(path);
                    isFound = true;
                }
            }
            WorkDto dto = WorkDto.builder()
                    .frontId(workEntity.getFrontId())
                    .title(workEntity.getTitle())
                    .imageDtos(new ArrayList<>())
                    .imagesIds(imagesIds)
//                    .description() //todo определить откуда будем брать описание
                    .build();

            dto.getImageDtos().add(imageDto);
            dtos.add(dto);
        }

        WorkDtoWithTags result = new WorkDtoWithTags();
        result.setDtos(dtos);
        if (!topicIds.isEmpty()) {
            List<String> allTags = tagService.getAllTags();
            result.setTags(allTags);
        }

        return result;
    }

    public WorkDto changeWork(WorkDto work) {
        //todo доделать изменение работы - надо уточнить, что именно может меняться, возможно надо будет два эндпоинта делать
        return null; //workDao.save(work);
    }

    public Boolean deleteWorkOrImage(String workId, String imageId) {
        List<String> fileNamesToDelete = new ArrayList<>();
        try {
            if (imageId.isBlank()) {
                WorkEntity workEntity = workDao.findByFrontId(workId);
                fileNamesToDelete.add(workEntity.getTitleImage().getPath());
                for (ImageEntity portfolioImage : workEntity.getPortfolioImages()) {
                    fileNamesToDelete.add(portfolioImage.getPath());
                }
                //todo надо проверить, что во время удаления работы не удалятся топики, которые есть в других работах
                workDao.deleteByFrontId(workId);
            } else {
                ImageEntity imageEntity = imageDao.findByFrontId(imageId);
                fileNamesToDelete.add(imageEntity.getPath());
                imageDao.deleteByFrontId(imageId);
            }
            removeFilesFromDisc(fileNamesToDelete);
        } catch (Exception e) {
            log.error(WHOOPS + e);
        }
        return Boolean.TRUE;
    }

    private void removeFilesFromDisc(List<String> fileNamesToDelete) {
        for (String s : fileNamesToDelete) {
            fileService.deleteFileFromDisc(s);
        }
    }
}
