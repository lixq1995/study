package com.test.designmode.factorydesign44.reconsitution2;


import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.IRuleConfigParser;
import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.RuleConfig;
import com.test.designmode.factorydesign44.reconsitution2.factorymethod.IRuleConfigParserFactory;


/**
 * 在RuleConfigSource的基础上优化
 * 将if else代码抽取出来
 */
public class RuleConfigSource1 {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new Exception("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}

