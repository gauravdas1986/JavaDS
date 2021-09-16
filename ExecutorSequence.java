package com.proair.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorSequence {
	int valve = 1;

	public static void main(String[] args) {
		ExecutorSequence s = new ExecutorSequence();
		ExecutorService es = Executors.newFixedThreadPool(3);

		List<Runnable> rList = new ArrayList<>();
		rList.add(new A(s));
		rList.add(new B(s));
		rList.add(new C(s));

		for (int i = 0; i < rList.size(); i++) {
			es.submit(rList.get(i));
		}
		es.shutdown();

	}
}

class A implements Runnable {
	ExecutorSequence s;

	A(ExecutorSequence s) {
		this.s = s;
	}

	public void run() {
		synchronized (s) {
			for (int i = 0; i < 10; i++) {
				while (s.valve != 1) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("A");
				s.valve = 2;
				s.notifyAll();
			}
		}
	}
}

class B implements Runnable {
	ExecutorSequence s;

	B(ExecutorSequence s) {
		this.s = s;
	}

	public void run() {
		synchronized (s) {
			for (int i = 0; i < 10; i++) {
				while (s.valve != 2) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("B");
				s.valve = 3;
				s.notifyAll();
			}
		}
	}
}

class C implements Runnable {
	ExecutorSequence s;

	C(ExecutorSequence s) {
		this.s = s;
	}

	public void run() {
		synchronized (s) {
			for (int i = 0; i < 10; i++) {
				while (s.valve != 3) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("C");
				s.valve = 1;
				s.notifyAll();
			}
		}
	}
}
