package test.designmode.interfaceuse09;

import javafx.scene.image.Image;

// AliyunImageStore 类的使用举例
public class ImageProcessingJob {
    private static final String BUCKET_NAME = "ai_images_bucket";
    //... 省略其他无关代码...

    public void process() {
        Image image = new Image("image"); // 处理图片，并封装为 Image 对象
        AliyunImageStore imageStore = new AliyunImageStore(/* 省略参数 */);
        imageStore.createBucketIfNotExisting(BUCKET_NAME);
        String accessToken = imageStore.generateAccessToken();
        imageStore.uploadToAliyun(image, BUCKET_NAME, accessToken);


        // 私有云不需要获取登录token
        Image image1 = new Image("image"); // 处理图片，并封装为 Image 对象
        PrivateImageStore imageStore1 = new PrivateImageStore(/* 省略参数 */);
        imageStore1.uploadToPrivateCloud(image1, BUCKET_NAME);

        // todo 代码缺陷
        // 1.暴露方法名，调用者根据名字能够大概了解实现细节
    }

}
