package com.dalingjia.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class LongEventProducer {

	private final RingBuffer<LongEvent> ringBuffer;
	
	public LongEventProducer(RingBuffer<LongEvent> ringBuffer){
		this.ringBuffer = ringBuffer;
	}
	
	/**
	 * onData用来发布事件，每调用一次就发布一次事件
	 * 他的参数会用该事件传递给消费者
	 * */
	public void onData(ByteBuffer input){
		//1.把ringBuffer看做一个事件队列，那么next就是得到下一个事件槽
		long sequence = ringBuffer.next();
		try{
			//2.用上面的索引取出一个空的事件用于填充（获取该序号对应的事件对象）
			LongEvent event = ringBuffer.get(sequence);
			//3.获取要通过事件传递的业务数据
			event.setValue(input.getLong(0));
		} finally {
			//4.发布事件
			//注意，最后的ringBuffer.publish 方法必须包含在finally中以确保必须得到调用
			//如果某个请求的sequence未被提交，则对应的消费者获取不了数据
			ringBuffer.publish(sequence);
		}
	}
}
