package test.designmode.factorydesign44.reconsitution2.factorymethod;

import com.test.designmode.factorydesign44.nodesignpattern.parsercalss.IRuleConfigParser;

/**
 * 工厂方法模式
 *
 * 工厂方法模式的典型代码实现。这样当我们新增一种parser的时候，只需要新增一个实现了IRuleConfigParserFactory接口的Factory类即可。
 * 所以，工厂方法模式比起简单工厂模式更加符合开闭原则。
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
