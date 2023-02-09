package test.local.pojo;

import lombok.Data;

/**
 * @author by Lixq
 * @Classname User
 * @Description TODO
 * @Date 2021/7/15 22:04
 */
@Data
public class User {
    private String name;
    private String age;
    private String sex;

    public User(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String age) {
        this.age = age;
    }

    public User() {
    }
}
