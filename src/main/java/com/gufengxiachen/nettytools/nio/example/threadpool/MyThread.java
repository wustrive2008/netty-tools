package com.gufengxiachen.nettytools.nio.example.threadpool;

public class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行"+ThreadPoolTest.i);
		ThreadPoolTest.i++;
	}
}
