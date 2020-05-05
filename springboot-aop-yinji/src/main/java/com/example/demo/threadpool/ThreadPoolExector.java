package com.example.demo.threadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolExector {
/**
 * 由线程池执行此方法
 * */
    @Async("taskExecutor")
    public void task(){
        System.out.println("线程池："+Thread.currentThread().getName());
    }

}
