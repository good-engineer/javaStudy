package main;
import java.util.*;

public class PrintAllStrings {
	
	private static final Scanner sc = new Scanner(System.in);
	private void combination(char[] str, int n, char[] cache, int r, int index) {
		if(index==r) {
			System.out.println(cache);
		}
		else {
		for(int i=0; i<n;i++) {
			cache[index]=str[i];
			combination(str,n,cache,r,index+1);
		}
		}
	}
	
	private void permute(String str, int from, int to) {
		char [] arr = str.toCharArray();
		if(from==to)
			System.out.println(str);
		else {
			for(int i=from; i<=to; i++) {
				str = swap(str,from,i);
				permute(str,from+1,to);
				str = swap(str,from,i);
			}
		}
	}
	public String swap(String str, int a, int b) {
		char [] arr = str.toCharArray();
		char temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		
		String str = sc.nextLine();
		PrintAllStrings printAllStrings = new PrintAllStrings();
        //printAllStrings.permute(str, 0, str.length()-1);
		char [] cache = new char[3];
		int r = 3;
		printAllStrings.combination(str.toCharArray(), str.length(), cache, r, 0);
	}

}
