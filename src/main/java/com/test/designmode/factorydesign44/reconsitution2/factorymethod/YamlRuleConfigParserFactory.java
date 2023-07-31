package com.test.designmode.factorydesign44.reconsitution2.factorymethod;

import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.IRuleConfigParser;
import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
