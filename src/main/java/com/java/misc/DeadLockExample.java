package com.java.misc;
/*2 threads executing method1 with lock1 on object 
 * thread 1 holding on to the lock to “resource A” but waiting for the lock on “resource B” 
 * and thread 2 holding on to the lock for “resource B” but waiting for the lock on “resource A”.
 * 
 * 
 */
public class DeadLockExample  extends Thread{
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	private void method1(){
		synchronized (lock1) {
			delay(500);
			System.out.println("In method1 ::::  "+Thread.currentThread().getName());
			synchronized (lock2) {
				System.out.println("method 1 is executing");
			}
		}
	}
	
	private void method2(){
		synchronized (lock2) {
			delay(500);
			System.out.println("In method2 ::::  "+Thread.currentThread().getName());
			synchronized (lock1) {
				System.out.println("method 2 is executing");
			}
		}
	}
	
	@Override
	public void run(){
		method1();
		method2();
	}

	public static void main(String[] args) {
		DeadLockExample e1 = new DeadLockExample();
		DeadLockExample e2 = new DeadLockExample();
		
		Thread t1 = new Thread(e1);
		Thread t2 = new Thread(e2);
		t1.start();
		t2.start();
		

	}
	
	private void delay(long millisec){
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
