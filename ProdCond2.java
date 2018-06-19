package p1;

import java.util.ArrayList;
import java.util.List;

class ProducerConsumer {
	List l = new ArrayList();
	int count;
//	public ProducerConsumer(List l) {
//		this.l = l;
//	}
	
	public void produce() {
		while (true) {
			synchronized (this) {

				
					while (l.size() == 10) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(l);
					l.add(count);
					notify();
				}

			}
	}
	
	public void consume() {
		while (true) {
			synchronized (this) {

				
					while (l.size() == 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(l);
					l.remove(l.size()-1);
					notify();
				}

			}
	}
	
}


public class ProdCond2 {
	public static void main(String[] args) {
		final List l = new ArrayList();
		final ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
				public void run() {
					pc.produce();
					System.out.println("produced "+l);
					
				}}
				);
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				pc.consume();
				System.out.println(l);
				
			}});
		t1.start();
		t2.start();
		
	}

}
