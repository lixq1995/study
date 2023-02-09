package newjdk8.lambda;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import newjdk8.dto.Person;

import java.util.*;

public class MapTest {
    private static Map<String, Integer> items = new HashMap<>();
    static {
        items.put("A", 10);
        items.put("B", 20);
        items.put("D", 40);
        items.put("C", 30);
        items.put("F", 60);
        items.put("E", 50);
    }

    public static void main(String[] args) {
        //Java8之前遍历是这样遍历map
        for(Map.Entry<String,Integer> entry:items.entrySet()){
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        System.out.println("--------");

        //Java8遍历map
        items.forEach((key,value)-> System.out.println("key:" + key + " value:" + value));

        Map<String, Integer> map = ImmutableMap.of("0", 3, "1", 8, "0.29", 7, "1.67", 3);
//        System.out.println("原始的map：" + map);
//        System.out.println("根据map的key降序：" + sortByKey(map, true));
//        System.out.println("根据map的key升序：" + sortByKey(map, false));
//        System.out.println("根据map的value降序：" + sortByValue(map, true));
//        System.out.println("根据map的value升序：" + sortByValue(map, false));

        Map result = Maps.newLinkedHashMap();
        items.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        System.out.println("items排序后 = " + items);
    }

    /**
     * 根据map的key排序
     *
     * @param map 待排序的map
     * @param isDesc 是否降序，true：降序，false：升序
     * @return 排序好的map
     * @author zero 2019/04/08
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /**
     * 根据map的value排序
     *
     * @param map 待排序的map
     * @param isDesc 是否降序，true：降序，false：升序
     * @return 排序好的map
     * @author zero 2019/04/08
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }
}

