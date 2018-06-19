package p1;

public class OverloadTest {
	public static void main(String[] args) {
		new OverloadTest().display(null);
	}
	public void display(Object obj) {
		System.out.println("Object");
	}
	public void display(String str) {
		System.out.println("String");
	}
	public void display(int in) {
		System.out.println("Integer");
	}
}
