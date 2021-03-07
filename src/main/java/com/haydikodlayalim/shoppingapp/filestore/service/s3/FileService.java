package com.haydikodlayalim.shoppingapp.filestore.service.s3;

import java.io.InputStream;

public interface FileService {

    void save(String id, String contentType, InputStream isFile);

    void delete(String id);

    byte[] get(String id);
}
