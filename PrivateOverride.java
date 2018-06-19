package p1;

public class PrivateOverride {
	 public static void main(String [] args) {
         Derived D = new PrivateOverride().new Derived();
         D.func2(); 
}
class Base {
	//Private wont work,,,make it public to override
    private void func(){
          System.out.println("In base func method");         
    };
    public void func2() {
        System.out.println("func2");
        func();
    }
}

class Derived extends Base {
    public void func(){   //  Is this an overriding method?
          System.out.println("In Derived Class func method"); 
    }
}

}