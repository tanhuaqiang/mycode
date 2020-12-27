package com.dalingjia.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongEventTest {

	public static void main(String[] args) {
		//创建线程池
		ExecutorService executor = Executors.newCachedThreadPool();
		//创建工程
		LongEventFactory factory = new LongEventFactory();
		//创建bufferSize，也就是RingBuffer大小，必须是2的N次方
		int ringBufferSize = 1024 * 1024;

		/**
		 * 1，BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
		 *         	WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
		 * 2，SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
		 *         	WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
		 * 3，YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
		 *         	WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
		 */
		/* 创建disruptor
		 * 1.第一个参数为工厂类对象，用于创建一个个的LongEvent，LongEvent是实际的消费数据。
		 * 2.第二个参数为缓存区大小
		 * 3.第三个参数为线程池，进行Disruptor内部的数据接收处理调度
		 * 4.第四个参数ProducerType.SINGLE(表示一个生产者) 和 ProducerType.MULTI(多个生产者)
		 * 5.第五个参数是一种策略，就是生产和消费的策略
		 * */
		Disruptor<LongEvent> disruptor = new Disruptor<>(
				factory,
				ringBufferSize,
				executor,
				ProducerType.SINGLE,
				new YieldingWaitStrategy()
		);
		
		//连接消费事件方法
		disruptor.handleEventsWith(new LongEventHandler());
		
		//启动
		disruptor.start();
		
		//Disruptor的事件发布过程是一个两阶段提交过程
		//使用该方法获得具体存放数据的容器RingBuffer（环形结构）
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		
		LongEventProducer producer = new LongEventProducer(ringBuffer);

		//allocate(int capacity): 从堆空间中分配一个容量大小为capacity的byte数组作为缓冲区的byte数据存储器
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		for(long input = 0; input < 100; input++){
			byteBuffer.putLong(0,input);
			producer.onData(byteBuffer);
		}
		
		disruptor.shutdown(); //关闭disruptor，方法会阻塞，直到所有的时间得到处理
		executor.shutdown(); //关闭executor，disruptor不会自动关闭executor
		
	}

}
