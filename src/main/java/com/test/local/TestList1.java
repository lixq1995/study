package com.test.local;


import com.alibaba.fastjson.JSONArray;
import com.test.local.pojo.StockDetailsInfo;
import com.test.local.pojo.User;
import lombok.SneakyThrows;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestList1 {

    @SneakyThrows
    public static void main(String[] args) throws Exception {
        ArrayList<CasePushMsg> casePushMsgArrayList = new ArrayList<>();
        for (CasePushMsg casePushMsg : casePushMsgArrayList) {

        }
        System.out.println("执行完");

        Optional<Object> o = Optional.ofNullable(null);
        System.out.println("o : " + o);


        List<User> list1 = new ArrayList<User>();
        User user = new User("张三", "15", "男");
        User user1 = new User("李四", "10", "男");
        User user2 = new User("王五", "12", "男");
        list1.add(user);
        list1.add(user1);
        list1.add(user2);
        List<String> ages = list1.stream().map(student -> student.getAge()).collect(Collectors.toList());

        String a = "[{\"currentPrice\":\"27.00\",\"highestPriceToday\":\"27.64\",\"id\":42,\"lowestPriceToday\":\"25.94\",\"openingDate\":1625673600000,\"openingPriceToday\":\"25.98\",\"quoteChange\":\"7.44%\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"turnoverRate\":\"11.45%\",\"volume\":\"4159094\"},{\"currentPrice\":\"25.13\",\"highestPriceToday\":\"25.59\",\"id\":4396,\"lowestPriceToday\":\"22.59\",\"openingDate\":1625587200000,\"openingPriceToday\":\"22.90\",\"quoteChange\":\"7.67%\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"turnoverRate\":\"8.41%\",\"volume\":\"3054077\"},{\"currentPrice\":\"23.34\",\"highestPriceToday\":\"23.65\",\"id\":8748,\"lowestPriceToday\":\"22.22\",\"openingDate\":1625500800000,\"openingPriceToday\":\"22.63\",\"quoteChange\":\"2.91%\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"turnoverRate\":\"8.87%\",\"volume\":\"3223543\"},{\"currentPrice\":\"22.68\",\"highestPriceToday\":\"22.68\",\"id\":13099,\"lowestPriceToday\":\"20.79\",\"openingDate\":1625414400000,\"openingPriceToday\":\"20.80\",\"quoteChange\":\"9.99%\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"turnoverRate\":\"8.78%\",\"volume\":\"3189082\"},{\"currentPrice\":\"20.62\",\"highestPriceToday\":\"21.46\",\"id\":17448,\"lowestPriceToday\":\"19.82\",\"openingDate\":1625155200000,\"openingPriceToday\":\"20.05\",\"quoteChange\":\"2.89%\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"turnoverRate\":\"4.54%\",\"volume\":\"1651024\"},{\"currentPrice\":\"29.70\",\"highestPriceToday\":\"29.70\",\"id\":21797,\"innerDisk\":\"1517216\",\"lowestPriceToday\":\"26.85\",\"openingDate\":1625760000000,\"openingPriceToday\":\"27.20\",\"outerDisk\":\"1474926\",\"peRatioDynamic\":\"34.81\",\"peRatioStatic\":\"129.59\",\"peRatioTtm\":\"73.77\",\"quoteChange\":\"10.00\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"totalMarketCapitalization\":\"1079.02\",\"turnoverRate\":\"8.24\",\"vibrationAmplitude\":\"10.56\",\"volume\":\"2992143\",\"yesterdayPrice\":\"27.00\"},{\"currentPrice\":\"32.67\",\"highestPriceToday\":\"32.67\",\"id\":26201,\"innerDisk\":\"1454712\",\"lowestPriceToday\":\"30.97\",\"openingDate\":1626019200000,\"openingPriceToday\":\"31.80\",\"outerDisk\":\"2097318\",\"peRatioDynamic\":\"38.29\",\"peRatioStatic\":\"142.55\",\"peRatioTtm\":\"81.14\",\"quoteChange\":\"10.00\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"totalMarketCapitalization\":\"1186.92\",\"turnoverRate\":\"9.78\",\"vibrationAmplitude\":\"5.72\",\"volume\":\"3552030\",\"yesterdayPrice\":\"29.70\"},{\"currentPrice\":\"33.07\",\"highestPriceToday\":\"33.66\",\"id\":30605,\"innerDisk\":\"1559417\",\"lowestPriceToday\":\"31.80\",\"openingDate\":1626105600000,\"openingPriceToday\":\"32.80\",\"outerDisk\":\"1488061\",\"peRatioDynamic\":\"38.76\",\"peRatioStatic\":\"144.30\",\"peRatioTtm\":\"82.14\",\"quoteChange\":\"1.22\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"totalMarketCapitalization\":\"1201.45\",\"turnoverRate\":\"8.39\",\"vibrationAmplitude\":\"5.69\",\"volume\":\"3047478\",\"yesterdayPrice\":\"32.67\"},{\"currentPrice\":\"32.30\",\"highestPriceToday\":\"34.50\",\"id\":35009,\"innerDisk\":\"1227152\",\"lowestPriceToday\":\"31.88\",\"openingDate\":1626192000000,\"openingPriceToday\":\"32.50\",\"outerDisk\":\"1288749\",\"peRatioDynamic\":\"37.86\",\"peRatioStatic\":\"140.94\",\"peRatioTtm\":\"80.22\",\"quoteChange\":\"-2.33\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"totalMarketCapitalization\":\"1173.48\",\"turnoverRate\":\"6.93\",\"vibrationAmplitude\":\"7.92\",\"volume\":\"2515901\",\"yesterdayPrice\":\"33.07\"},{\"currentPrice\":\"35.53\",\"highestPriceToday\":\"35.53\",\"id\":39413,\"innerDisk\":\"1719795\",\"lowestPriceToday\":\"30.51\",\"openingDate\":1626278400000,\"openingPriceToday\":\"32.38\",\"outerDisk\":\"1526693\",\"peRatioDynamic\":\"41.64\",\"peRatioStatic\":\"155.03\",\"peRatioTtm\":\"88.25\",\"quoteChange\":\"10.00\",\"stockCode\":\"600111\",\"stockName\":\"北方稀土\",\"totalMarketCapitalization\":\"1290.83\",\"turnoverRate\":\"8.94\",\"vibrationAmplitude\":\"15.54\",\"volume\":\"3246488\",\"yesterdayPrice\":\"32.30\"}]\n";
        List<StockDetailsInfo> stockDetailsInfos = JSONArray.parseArray(a, StockDetailsInfo.class);
        int openingDatesize = stockDetailsInfos.size();
        // 按时间倒序排序
        stockDetailsInfos.sort(Comparator.comparing(StockDetailsInfo::getOpeningDate).reversed());
        List<Double> quoteChangeList = new ArrayList<>();
        double turnoverRate = 0;
        for (StockDetailsInfo detailsInfo : stockDetailsInfos) {
            // 统计换手率
            if (detailsInfo.getQuoteChange().contains("%")) {
                detailsInfo.setQuoteChange(detailsInfo.getQuoteChange().replace("%",""));
            }
            if (detailsInfo.getTurnoverRate().contains("%")) {
                detailsInfo.setTurnoverRate(detailsInfo.getTurnoverRate().replace("%",""));
            }
            if ("".equals(detailsInfo.getTurnoverRate())) {
                detailsInfo.setTurnoverRate("0");
            }
            double v = Double.parseDouble(detailsInfo.getTurnoverRate());
            turnoverRate = turnoverRate + Double.parseDouble(detailsInfo.getTurnoverRate());
            // 将涨幅大于0的放入一个集合中
            if (Double.parseDouble(detailsInfo.getQuoteChange()) >= 0) {
                quoteChangeList.add(Double.parseDouble(detailsInfo.getQuoteChange()));
            }


        }
        double endDateTurnoverRate = Double.parseDouble(stockDetailsInfos.get(0).getTurnoverRate());
        // 除最后一天的平均换手率
        double avgTurnoverRate = (turnoverRate-endDateTurnoverRate)/(openingDatesize - 1);
        // 换手率大于2倍的
        if (endDateTurnoverRate/avgTurnoverRate > 2) {
            System.out.println("大于2");
        }
        // 连续上涨的
        int size = quoteChangeList.size();
        double b = size/openingDatesize;
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String num = df.format((float)size/openingDatesize);


        if (size/openingDatesize > 0.66) {
            System.out.println("连续上涨");
        }
        System.out.println(quoteChangeList);

    }
}
