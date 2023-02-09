package test.spring5.shejimoshi.gongchang.abstractfactory3.one;

/**
 * @author by Lixq
 * @Classname CourseFactory
 * @Description TODO
 * @Date 2021/12/6 23:32
 */
public interface CourseFactory {
    INote createNote();

    IVideo createVideo();
}
