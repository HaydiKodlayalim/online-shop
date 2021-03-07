package com.haydikodlayalim.shoppingapp.filestore.service;

import java.io.File;
import java.nio.file.Files;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStoreService {

    public Mono<byte[]> getImage(String id) throws Exception {
        File file = ResourceUtils.getFile("classpath:docs/app_model.png");
        return Mono.just(Files.readAllBytes(file.toPath()));
    }
}
