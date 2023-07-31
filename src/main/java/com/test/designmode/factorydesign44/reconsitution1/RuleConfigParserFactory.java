package com.test.designmode.factorydesign44.reconsitution1;

import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 重构优化：
 * reconsitution1代码实现中，我们每次调用 RuleConfigParserFactory 的 createParser() 的时候，都要创建一个新的 parser
 * 但是实际上，parser 可以复用
 * 为了节省内存和对象创建的时间，我们可以将parser事先创建好缓存起来。当调用createParser()函数的时候，我们从缓存中取出parser对象直接使用。
 * 有点类似单例模式和简单工厂模式的结合
 */
// todo 存在问题：如果需要再增加新的配置文件类型，比如txt，那需要修改代码，再新增一个txt对象。  违反开闭原则
public class RuleConfigParserFactory {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;// 返回null还是IllegalArgumentException全凭你自己说了算
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
