package com.test.designmode.interfaceuse09.refactorcode;

import javafx.scene.image.Image;

public class AliyunImageStore1 implements ImageStore {
    //... 省略属性、构造函数等...
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        String accessToken = generateAccessToken();
        //... 上传图片到阿里云...
        //... 返回图片在阿里云上的地址 (url)...
        return "upload";
    }

    public Image download(String url) {
        String accessToken = generateAccessToken();
        //... 从阿里云下载图片...
        Image image = new Image("image");
        return image;
    }

    private void createBucketIfNotExisting(String bucketName) {
        // ... 创建 bucket...
        // ... 失败会抛出异常..
    }

    private String generateAccessToken() {
        // ... 根据 accesskey/secrectkey 等生成 access token
        return "generateAccessToken";
    }
}