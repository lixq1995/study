package test.spring5.shejimoshi.daili.staticproxy4db.db;

/**
 * @author by Lixq
 * @Classname DynamicDataSourceEntity
 * @Description TODO
 * @Date 2022/3/16 23:01
 */
public class DynamicDataSourceEntity {

    // 默认数据源，自己设置默认值
    public final static String DEFAULE_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity() {
    }

    /**
     * 获取当前正在使用的数据源名字
     */
    public static String get() {
        return local.get();
    }

    /**
     * 还原当前切换的数据源
     */
    public static void restore() {
        local.set(DEFAULE_SOURCE);
    }

    /**
     * 清空数据源
     */
    public static void clear() {
        local.remove();
    }

    /**
     * 设置已知名字的数据源
     * //DB_2018
     * //DB_2019
     * @param source
     */
    public static void set(String source) {
        local.set(source);
    }

    /**
     * 根据年份动态设置数据源
     * @param year
     */
    public static void set(int year) {
        local.set("DB_" + year);
    }

}
