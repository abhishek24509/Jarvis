package com.java.misc;

public class DeadLockTest extends Thread {
	 
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
 
    public void method1() {
        synchronized (lock1) {
            delay(500);  //some operation
            System.out.println("method1: " + Thread.currentThread().getName());
            synchronized (lock2) {
                System.out.println("method1 is executing .... ");
            }
        }
    }
 
    public void method2() {
        synchronized (lock2) {
            delay(500);   //some operation
            System.out.println("method1: " + Thread.currentThread().getName());
            synchronized (lock1) {
                System.out.println("method2 is executing .... ");
            }
        }
    }
 
    @Override
    public void run() {
        method1();
        method2();
    }
 
    public static void main(String[] args) {
    	DeadLockTest thread1 = new DeadLockTest();
    	DeadLockTest thread2 = new DeadLockTest();
 
        thread1.start();
        thread2.start();
    }
 
    /**
     * The delay is to simulate some real operation happening.
     * @param timeInMillis
     */
    private void delay(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}
 