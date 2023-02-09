package test.designmode.interfaceuse09.refactorcode;

import javafx.scene.image.Image;

// 上传下载流程改变：私有云不需要支持 access token
public class PrivateImageStore1 implements ImageStore  {
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        //... 上传图片到私有云...
        //... 返回图片的 url...
        return "upload";
    }
    public Image download(String url) {
        //... 从私有云下载图片...
        Image image = new Image("image");
        return image;
    }
    private void createBucketIfNotExisting(String bucketName) {
        // ... 创建 bucket...
        // ... 失败会抛出异常..
    }
}
