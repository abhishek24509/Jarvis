package com.java.misc;

import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

	private int count;

	public synchronized void consume() {
		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException ie) {
				// keep trying
			}
		}
		System.out.println("consumed:" + count);
		count--; // consumed
	}

	public synchronized void produce() {
		count++;
		System.out.println("produced:" + count);
		notify(); // notify consumer that count has been incremented

	}

	public static void main(String[] args) throws InterruptedException {
		final ProducerConsumer pc = new ProducerConsumer();

		// anonymous inner class
		Runnable producerThread = new Runnable() {
			@Override
			public void run() {
				while (true) {
					pc.produce();
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
					}
				}
			}
		};

		// anonymous inner class
		Runnable consumerThread = new Runnable() {
			@Override
			public void run() {
				while (true) {
					pc.consume();
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
					}
				}
			}
		};

		new Thread(producerThread).start();
		TimeUnit.SECONDS.sleep(2);
		new Thread(consumerThread).start();

	}
}