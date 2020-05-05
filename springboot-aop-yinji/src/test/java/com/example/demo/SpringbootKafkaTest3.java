package com.example.demo;

import com.example.demo.dto.TaskResultInfoKafkaDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootKafkaTest3 {
    @Test
    public void test(){
        Gson gson = new Gson();
        String jsonString = getJson();
        TaskResultInfoKafkaDTO taskResultInfoKafkaDTO = gson.fromJson(jsonString, TaskResultInfoKafkaDTO.class);
        System.out.println("打印结果：  "+taskResultInfoKafkaDTO);


    }

    private String getJson() {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("key7","777");
        hashMap.put("key8","888");
        hashMap.put("key9","999");
        Gson gson = new Gson();
        System.out.println("json串是：=====   "+gson.toJson(hashMap));
        return gson.toJson(hashMap);
    }

}
