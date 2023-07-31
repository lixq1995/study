package com.test.designmode.interfaceuse09.refactorcode;

import javafx.scene.image.Image;

/**
 * 代码重构，使用接口实现。提高代码复用
 */
public interface ImageStore {

    String upload(Image image, String bucketName);

    Image download(String url);
}

