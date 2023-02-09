package test.designmode.factorydesign44.reconsitution2;

import com.test.designmode.factorydesign44.reconsitution2.factorymethod.*;

import java.util.HashMap;
import java.util.Map;

// 因为工厂类只包含方法，不包含成员变量，完全可以复用，
// 不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。

// todo 当我们需要添加新的规则配置解析器的时候，我们只需要创建新的 parser 类和 parser factory 类，
// todo 并且在 RuleConfigParserFactoryMap 类中，将新的 parser factory 对象添加到 cachedFactories 中即可。代码的改动非常少，基本上符合开闭原则。
public class RuleConfigParserFactoryMap { // 工厂的工厂
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}