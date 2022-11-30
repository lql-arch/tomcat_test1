package JSON;

import com.alibaba.fastjson.JSON;
import login.User;

public class jsonAanPojo {
    public static void main(String[] args) {
        //1.将java->Json
        User user = new User();
        user.setId(1);
        user.setUsername("yeyr2");
        user.setPassword("111");
        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr+"\n");

        //2.json->java
        //通过parse方法进行反序列化(err)
//        User user2 = (User)JSON.parse(jsonStr);
//        System.out.println(user2.getUsername()+"\n");

        //通过parseObject方法进行反序列化  通过这种方法返回的是一个JSONObject
        Object obj = JSON.parseObject(jsonStr);
        System.out.println(obj);
        System.out.println("obj name:"+obj.getClass().getName()+"\n");

        //通过这种方式返回的是一个相应的类对象
        User jsonObject = JSON.parseObject(jsonStr,User.class);
        System.out.println(jsonObject+"\n");
    }
}
