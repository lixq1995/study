package test.designmode.interfaceuse09;


import javafx.scene.image.Image;

public class AliyunImageStore {
    //... 省略属性、构造函数等...

    public void createBucketIfNotExisting(String bucketName) {
        // ... 创建 bucket 代码逻辑...
        // ... 失败会抛出异常..
    }

    public String generateAccessToken() {
        // ... 根据 accesskey/secrectkey 等生成 access token
        return "generateAccessToken";
    }

    public String uploadToAliyun(Image image, String bucketName, String accessToken) {
        //... 上传图片到阿里云...
        //... 返回图片存储在阿里云上的地址 (url）...
        return "uploadToAliyun";
    }

    public Image downloadFromAliyun(String url, String accessToken) {
        //... 从阿里云下载图片...
        Image image = new Image("image");
        return image;
    }
}
