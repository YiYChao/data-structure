package top.chao.mooc.map;

import java.util.HashMap;
import java.util.Map;

/**
 *  @Description: Map的通用方法，以及Map的遍历
 *  @author YiYChao
 *  @Date: 2020/11/4 16:04
 *  @version V1.0
 */
public class MapDemo1 {
    public static void main(String[] args) {

    }

    public static Map<String, Integer> generateMap(int capacity){
        Map<String, Integer> map = new HashMap<>();
        String[] charArr = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "g"};
        for (int i = 0; i < capacity; i++){
            String key = charArr[(int)(Math.random() * 10) * 10] + i * 100;
            map.put(String.valueOf(key), i);
        }
        return map;
    }
}
