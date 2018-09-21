package com.gaurav.thread;

public class MultiThreadInSequence {

	int status = 1;

	public static void main(String[] args) {

		MultiThreadInSequence MultiThreadInSequence = new MultiThreadInSequence();

		A1 a = new A1(MultiThreadInSequence);
		B1 b = new B1(MultiThreadInSequence);
		C1 c = new C1(MultiThreadInSequence);

		a.start();
		b.start();
		c.start();
	}
}

class A1 extends Thread {
	MultiThreadInSequence MultiThreadInSequence;

	A1(MultiThreadInSequence MultiThreadInSequence) {
		this.MultiThreadInSequence = MultiThreadInSequence;
	}

	@Override
	public void run() {

		try {
			synchronized (MultiThreadInSequence) {

				for (int i = 0; i < 100; i++) {

					if (MultiThreadInSequence.status != 1) {
						MultiThreadInSequence.wait();
					}

					if (MultiThreadInSequence.status == 1) {
					System.out.println("1  "+i);
					MultiThreadInSequence.status = 2;
					MultiThreadInSequence.notifyAll();
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}

}

class B1 extends Thread {

	MultiThreadInSequence MultiThreadInSequence;

	B1(MultiThreadInSequence MultiThreadInSequence) {
		this.MultiThreadInSequence = MultiThreadInSequence;
	}

	@Override
	public void run() {

		try {
			synchronized (MultiThreadInSequence) {

				for (int i = 0; i < 100; i++) {

					if (MultiThreadInSequence.status != 2) {
						MultiThreadInSequence.wait();
					}

					if (MultiThreadInSequence.status == 2) {
					System.out.println("22");
					MultiThreadInSequence.status = 3;
					MultiThreadInSequence.notifyAll();
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 2 :" + e.getMessage());
		}

	}
}

class C1 extends Thread {

	MultiThreadInSequence MultiThreadInSequence;

	C1(MultiThreadInSequence MultiThreadInSequence) {
		this.MultiThreadInSequence = MultiThreadInSequence;
	}

	@Override
	public void run() {

		try {
			synchronized (MultiThreadInSequence) {

				for (int i = 0; i < 100; i++) {

					if (MultiThreadInSequence.status != 3) {
						MultiThreadInSequence.wait();
					}

					if (MultiThreadInSequence.status == 3) {
					System.out.println("333");
					MultiThreadInSequence.status = 1;
					MultiThreadInSequence.notifyAll();
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 3 :" + e.getMessage());
		}

	}
}