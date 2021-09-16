package com.proair.test;

public class ThreadSequence {

	    int status=1;
	    public static void main(String[] args) {

	        ThreadSequence ThreadSequence = new ThreadSequence();

	        A1 a=new A1(ThreadSequence);
	        B1 b=new B1(ThreadSequence);
	        C1 c=new C1(ThreadSequence);

	        a.start();
	        b.start();
	        c.start();
	    }
	}

	class A1 extends Thread{
	    ThreadSequence ThreadSequence;

	    A1(ThreadSequence ThreadSequence){
	        this.ThreadSequence = ThreadSequence;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (ThreadSequence) {

	                for (int i = 0; i < 100; i++) {

	                    while(ThreadSequence.status!=1){
	                        ThreadSequence.wait();
	                    }

	                    System.out.print("A ");
	                    ThreadSequence.status = 2;
	                    ThreadSequence.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 1 :"+e.getMessage());
	        }

	    }

	}

	class B1 extends Thread{

	    ThreadSequence ThreadSequence;

	    B1(ThreadSequence ThreadSequence){
	        this.ThreadSequence = ThreadSequence;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (ThreadSequence) {

	                for (int i = 0; i < 100; i++) {

	                    while(ThreadSequence.status!=2){
	                        ThreadSequence.wait();
	                    }

	                    System.out.print("B ");
	                    ThreadSequence.status = 3;
	                    ThreadSequence.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 2 :"+e.getMessage());
	        }

	    }
	}


	class C1 extends Thread{

	    ThreadSequence ThreadSequence;

	    C1(ThreadSequence ThreadSequence){
	        this.ThreadSequence = ThreadSequence;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (ThreadSequence) {

	                for (int i = 0; i < 100; i++) {

	                    while(ThreadSequence.status!=3){
	                        ThreadSequence.wait();
	                    }

	                    System.out.print("C ");
	                    ThreadSequence.status = 1;
	                    ThreadSequence.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 3 :"+e.getMessage());
	        }

	    }
	}
