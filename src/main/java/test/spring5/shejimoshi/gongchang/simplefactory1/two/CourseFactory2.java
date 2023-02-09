package test.spring5.shejimoshi.gongchang.simplefactory1.two;

import com.test.spring5.shejimoshi.gongchang.simplefactory1.one.ICourse;
import org.apache.commons.lang3.StringUtils;

/**
 * @author by Lixq
 * @Classname CourseFactory2
 * @Description TODO
 * @Date 2021/12/6 22:32
 */
public class CourseFactory2 {
    public ICourse create(String className) {
        try {
            if (StringUtils.isNotEmpty(className)) {
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
