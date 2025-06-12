package java核心编程.static_learn;


import java.util.LinkedHashMap;

public class Test222 {
    public static void main(String[] args) {
//        UserParent up = null;
//        User aaa = (User) up;
//        System.out.println(aaa);

        LinkedHashMap<String, Object> nameValuePairs = new LinkedHashMap<>();
        nameValuePairs.put(null, "ffff");
        nameValuePairs.put(null, "ddd");
        System.out.println(nameValuePairs.get(null));
    }

    public static class User extends UserParent{

    }
    public static class UserParent{

    }
}
