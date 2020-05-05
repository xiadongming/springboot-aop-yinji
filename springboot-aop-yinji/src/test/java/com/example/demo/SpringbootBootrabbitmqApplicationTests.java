package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBootrabbitmqApplicationTests {
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
		Set keySet = new HashSet();//装不重复key

		HashMap<String,HashMap<String,String>> allMap = new HashMap<String,HashMap<String,String>>();
		HashMap<String,ArrayList<HashMap<String,String>>> resultMap = new HashMap<String,ArrayList<HashMap<String,String>>>();

		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			System.out.println(s);
			HashMap<String,String> startMap = new HashMap<String,String>();


			//切割得到数组
			String[] s1 = s.split("\\s+");
			String a = s1[0];
			String b = s1[1];
			String c = s1[2];
			keySet.add(a);

			startMap.put("dataPath",b);
			startMap.put("xmlPath",c);
			allMap.put(a,startMap);

		}
		br.close();
		System.out.println(allMap);
		String s1allMap = gson.toJson(allMap);
		System.out.println(s1allMap);
		//遍历不重复key
		Iterator iterator = keySet.iterator();
		while(iterator.hasNext()){
			//不同的建，放不同的list中
			ArrayList<HashMap<String,String>> objects = new ArrayList<>();
            //不重复key
			String next = (String)iterator.next();
			System.out.println("遍历keySet：  "+next);
			//遍历allMap

			Set<String> strings = allMap.keySet();
			Iterator<String> iterator1 = strings.iterator();
			while (iterator1.hasNext()){
				String next1 = iterator1.next();
				if(next.equals(next1)){
					objects.add(allMap.get(next1));
				}
			}
			resultMap.put(next,objects);
			System.out.println("最后的结果是：：：：："+resultMap);
		}



	}

}
