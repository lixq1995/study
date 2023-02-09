package test.spring5.shejimoshi.gongchang.simplefactory1.one;

/**
 * @author by Lixq
 * @Classname JavaCourse
 * @Description TODO
 * @Date 2021/12/6 22:21
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
