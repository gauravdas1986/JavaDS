package com.wipro;

public class FirstNonRepeating {
public static void main(String[] args) {
	String str = "JHUYTGFRTJHYTF";
	int index = -1;
	int[] chArr = new int[256];
	for(int i=0;i<128;i++){
		chArr[i]=0;
	}
	char[] strArr = str.toCharArray();
	for(char ch : strArr){
		chArr[ch]++;
//		System.out.println(ch+"+"+chArr[ch]);
	}
	for(int j=0;j<strArr.length;j++){
		if(chArr[strArr[j]] == 1){
			System.out.println(strArr[j]);
			break;
		}
	}
}
}
