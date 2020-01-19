package top.chao.map;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> printVertically(String s) {
        String[] tmp = s.split(" ");    // 切割字符串
        int maxLength = 0;
        // 找出最大长度
        for (int i = 0; i < tmp.length; i++) {
            maxLength = tmp[i].length() > maxLength ? tmp[i].length() : maxLength;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tmp.length; j++) {
                if (i < tmp[j].length()){
                    sb.append(tmp[j].charAt(i));
                }else{
                    sb.append(" ");
                }
            }
            String str = sb.toString();
            for (int j = str.length() - 1; j >= 0 ; j--) {
                if (str.charAt(j) == ' '){
                    str = str.substring(0, j);
                }else {
                    break;
                }
            }
            list.add(i, str);
            System.out.println(str);
        }
        return list;
    }

    public static void main(String[] args) {
//        new Solution2().printVertically("CONTEST IS COMING");
        new Solution2().printVertically("TO BE OR NOT TO BE");

    }
}
