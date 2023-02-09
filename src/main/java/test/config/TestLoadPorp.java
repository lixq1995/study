package test.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author by Lixq
 * @Classname TestLoadPorp
 * @Description TODO
 * @Date 2021/12/13 22:37
 */
public class TestLoadPorp {

    private String propertiesName = "test.properties";

    private void init() throws IOException {
        InputStream resourceAsStream = TestLoadPorp.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String driverName = properties.getProperty("driverName");

    }
}
