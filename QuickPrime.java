package p1;

public class QuickPrime {
public static void main(String[] args) {
	System.out.println(checkPrime(1137));
}
static boolean checkPrime(long num){
    long sq = (long) Math.sqrt(num);
    for(long i=2; i<=sq; i++){
        if(num%i ==0)
            return false; // we know it's not prime!
    }
    return true;
}
}



