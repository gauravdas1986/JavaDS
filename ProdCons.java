package p1;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {
	List l;
	int count;

	public Producer(List l) {
		this.l = l;
	}

	public void run() {
		while (count<=120) {
		synchronized (l) {

			
				while (l.size() == 10) {
					try {
						l.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				l.add(count++);
				System.out.println("ADDED "+l);
				l.notify();
			}

		}
	}
}

class Consumer implements Runnable {
	List l;
	int count;

	public Consumer(List l) {
		this.l = l;
	}

	public void run() {
		while (count<=120) {
		synchronized (l) {

			
				while (l.size() == 0) {
					try {
						l.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(l);
				l.remove(l.size()-1);
				l.notify();
			}

		}
	}
}


public class ProdCons {
	public static void main(String[] args) {
		List l = new ArrayList();
		Thread t1 = new Thread(new Producer(l));
		Thread t2 = new Thread(new Consumer(l));
		t1.start();
		t2.start();
		
	}

}
