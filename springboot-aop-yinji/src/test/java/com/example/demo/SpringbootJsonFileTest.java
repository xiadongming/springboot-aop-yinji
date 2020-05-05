package com.example.demo;

import com.example.demo.commonutils.JsonFileParsServiceUtils;
import com.example.demo.dto.TaskResultInfoKafkaDTO;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJsonFileTest {
    @Test
    public void test() throws IOException {
        JsonFileParsServiceUtils.JsonPars();

    }
}
