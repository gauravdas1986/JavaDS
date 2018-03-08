package com.wipro;

import java.util.HashMap;
import java.util.Map;

public class CashDispatch {
	public static void main(String[] args) {
		int[] denom = {1, 5, 10, 20, 50, 100 };
		int cash = 4124;
		Map m = denomMap(cash, denom);
		
		System.out.println(m);

	}

	public static Map denomMap(int cash, int[] denom) {
		Map m = new HashMap();
		int currDenom=0;
		int denomCount=0;
		for (int i = 1; i <= denom.length; i++) {
			if (cash > denom[denom.length - i]) {
				System.out.println(cash+"_"+denom[denom.length-i]);
				denomCount = cash / denom[denom.length - i];
				currDenom=denom[denom.length - i];
				System.out.println("Putting into map : "+denom[denom.length - i]+" and "+ denomCount);
				m.put(denom[denom.length - i], denomCount);
				break;
			}
		}
		System.out.println("remaining "+(cash-(currDenom*denomCount)));
		if(cash-(currDenom*denomCount)!=0)
		denomMap((cash-(currDenom*denomCount)),denom);
		// for(int i=0;i<denomCount;i++)

		return m;
	}
}
