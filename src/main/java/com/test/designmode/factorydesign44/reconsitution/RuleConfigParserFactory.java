package com.test.designmode.factorydesign44.reconsitution;

import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.*;

/**
 * 将抽取的代码再提取到一个工厂类中， 即简单工厂模式
 * 每次需要使用即调用该工厂类创建对象即可
 */
// todo 存在问题：如果需要再增加新的配置文件类型，比如txt，那需要修改代码，再新增一个txt对象，并且新增一个if判断。  违反开闭原则
public class RuleConfigParserFactory {

    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}
