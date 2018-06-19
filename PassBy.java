package p1;

public class PassBy {
	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setName("AAAA");
		changeName(emp);
		System.out.println(emp.getName());
	}
	public static void changeName(Employee emp) {
		emp = new Employee();
		emp.setName("BBB");
	}
}
