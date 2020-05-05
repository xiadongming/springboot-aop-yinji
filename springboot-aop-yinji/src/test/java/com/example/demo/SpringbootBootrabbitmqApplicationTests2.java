package com.example.demo;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBootrabbitmqApplicationTests2 {
/**
 * list装少量map，，map是以mr为key
 * map中装多个list
 *
 * **/
	@Test
	public void contextLoads() throws IOException {
		Gson gson = new Gson();
		File file = new File("D:\\datayinji\\data3.txt");// Text文件
		BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
		String s = null;
		HashMap<String,HashMap<String,String>> allMap = new HashMap<String,HashMap<String,String>>();
		HashMap<String,ArrayList<HashMap<String,String>>> resultMap = new HashMap<String,ArrayList<HashMap<String,String>>>();
		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			System.out.println(s);
			HashMap<String, String> startMap = new HashMap<String, String>();
			//切割得到数组
			String[] s1 = s.split("\\s+");
			String a = s1[0];
			String b = s1[1];
			String c = s1[2];
			startMap.put(b,c);
           if(!resultMap.containsKey(a)){
			   ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String,String>>();
			   arrayList.add(startMap);
			   resultMap.put(a,arrayList);
		   }else{
			   ArrayList<HashMap<String, String>> arrayList = resultMap.get(a);
			   arrayList.add(startMap);
			   resultMap.put(a,arrayList);
		   }
		}
		System.out.println(gson.toJson(resultMap));
		BufferedWriter out = new BufferedWriter(new FileWriter("D:\\datayinji\\result.txt"));
		out.write(gson.toJson(resultMap));
		out.close();
	}

}
