package com.java.misc;

import java.util.concurrent.TimeUnit;

public class PCExample {

	private int count;

	private synchronized void produce(){
		count++;
		System.out.println("PC produced ::::: "+ count);
		notify();
	}

	private synchronized void consume(){
		while(count==0){
			try{
				wait();
			}catch(InterruptedException e){

			}
		}
		System.out.println("PC consumed ::::: "+ count);
		count--;
	}

	public static void main(String[] args) throws InterruptedException{
		final PCExample pc = new PCExample();

		Runnable producerThread = new Runnable() {
			@Override
			public void run() {
				while(true){
					pc.produce();
					try{
						TimeUnit.SECONDS.sleep(2);
					}catch(InterruptedException e){

					}
				}
			}
		};

		Runnable consumerThread = new Runnable() {
			@Override
			public void run() {
				while(true){
					pc.consume();;
					try{
						TimeUnit.SECONDS.sleep(2);
					}catch(InterruptedException e){

					}
				}
			}
		};
		
		new Thread(producerThread).start();
		TimeUnit.SECONDS.sleep(2);
		new Thread(consumerThread).start();
	}
}
