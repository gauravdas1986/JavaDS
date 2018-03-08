package com.wipro;

public class LongestPalindromeSubstring {
public static void main(String[] args) {
	String str = "CBANANANA";
	int start = -1;
	int maxSize=1;
	char[] strArr = str.toCharArray();
	int size = str.length();
	boolean[][] flagArr = new boolean[size][size];
	for(int i=0;i<size;i++){
		flagArr[i][i]=true;
	}
	for(int j=0;j<size-1;j++){
		if(strArr[j+1] == strArr[j]){
			flagArr[j][j+1] = true;
			maxSize = 2;
			start=j;
		}
	}
	
	for(int l=3;l<size;l++){
		System.out.println();
	for(int k=l;k<=size;k++){
		System.out.print(k+" "+strArr[k-l]+" "+strArr[k-1]+" "+(k-l+1)+" "+(k-2)+" "+flagArr[k-l+1][k-2]);
		if(strArr[k-l] == strArr[k-1] && flagArr[k-l+1][k-2]){
			flagArr[k-l][k-1]=true;
			start=k-l;
			maxSize=l;
		}
	}
	}
	System.out.println();
	for(int x=0;x<size;x++){
		for(int y=0;y<size;y++){
			System.out.print(" ");
			System.out.print(flagArr[x][y]?1:0 );
		}
		System.out.println();
	}
	System.out.println(start+"__"+ maxSize);
System.out.println(str.substring(start, start+maxSize));
}
}
