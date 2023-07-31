package com.test.designmode.interfaceuse09.refactorcode;

import javafx.scene.image.Image;

// ImageStore 的使用举例
public class ImageProcessingJob1 {
    private static final String BUCKET_NAME = "ai_images_bucket";
    //... 省略其他无关代码...

    public void process() {
        Image image = new Image("image"); // 处理图片，并封装为 Image 对象
        ImageStore imageStore = new PrivateImageStore1();
        imageStore.upload(image, BUCKET_NAME);
    }
}
