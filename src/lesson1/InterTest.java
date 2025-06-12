package lesson1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixin on 2020/6/9.
 */
class InterTest {
    public static void main(String[] args) {
//        Integer integer = Integer.valueOf(null);
        Map<String,Object> value = new HashMap<>();
        value.put("aaaa" , null);
        value.put("bbbb" , 1);
        value.put("cccc" , 1.1);
        value.put("dddd" , true);
        List<String> list3 = new ArrayList();
        list3.add("哈喽");
        value.put("eeee" , list3);
        value.put("ffff" , new AAABean());
        Map<String,String> mobileCoreMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : value.entrySet()) {
            mobileCoreMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        System.out.println(mobileCoreMap);

    }
}
