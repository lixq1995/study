package test.spring5.shejimoshi.gongchang.simplefactory1.three;

import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.ICourse;

import java.util.Objects;

/**
 * @author by Lixq
 * @Classname CourseFactory3
 * @Description TODO
 * @Date 2021/12/6 22:52
 */
public class CourseFactory3 {

    public ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (Objects.nonNull(clazz)) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
