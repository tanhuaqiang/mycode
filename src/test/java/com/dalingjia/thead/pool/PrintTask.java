package com.dalingjia.thead.pool;

import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction{
	//每个小任务最多打印50个数
	private static final int Threshold = 50;
	private int start;
	private int end;
	
	public PrintTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		
	}

}
