package com.test.spring5.shejimoshi.celue.promotion;

/**
 * 无优惠
 * Created by Tom
 */
public class EmptyStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
