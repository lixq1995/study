package test.spring5.shejimoshi.celue.promotion;

import org.apache.commons.lang3.StringUtils;

/**
 * 促销活动案例演示
 * Created by Tom
 */
public class PromotionActivityTest {
    public static void main(String[] args) {
        // 使用示例，根据不同的促销活动，执行具体的促销代码逻辑
        test1();

        // 一般代码实际使用如下，业务逻辑根据用户实际参与的促销活动，进行判断，走到对应的促销类逻辑代码中去执行
        test2();

        // 策略工厂模式测试，在test2的基础上优化，省去if else
        test3();

    }

    private static void test1() {
        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
        activity618.execute();

        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
        activity1111.execute();
    }

    private static void test2() {
        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";
        if(StringUtils.equals(promotionKey,"COUPON")){
            promotionActivity = new PromotionActivity(new CouponStrategy());
        }else if(StringUtils.equals(promotionKey,"CASHBACK")){
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }//......
        promotionActivity.execute();
    }

    private static void test3() {
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }

}
