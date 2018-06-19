package p1;

import java.util.HashMap;

public class DuplicateKey {
public static void main(String[] args) {
	HashMap hs = new HashMap();
	BadKey bk1 = new BadKey("AAA");
	BadKey bk2 = new BadKey("AAA");
	BadKey bk3 = new BadKey("AAA");
	BadKey bk4 = new BadKey("AAA");
	hs.put(bk1, 1);
	hs.put(bk2, 2);
	hs.put(bk3, 3);
	hs.put(bk4, 4);
	System.out.println(hs.get(bk2));
}
}
class BadKey{
	String key;
	public BadKey(String key) {
		this.key = key;
	}
}
