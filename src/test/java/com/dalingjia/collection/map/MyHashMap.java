package com.dalingjia.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyHashMap {

	public static void main(String[] args) {
		
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
		     @Override
		     public void run() {
		         for (int i = 0; i < 10000; i++) {
		             new Thread(new Runnable() {
		                 @Override
		                 public void run() {
		                     map.put(UUID.randomUUID().toString(), "");
		                 }
		             }, "ftf" + i).start();
		         }
		     }
		}, "ftf");
        t.start();
        
        try {
			t.join();//main线程必须让t线程执行完毕
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"------------\t"+entry.getValue());
		}
	}

}
