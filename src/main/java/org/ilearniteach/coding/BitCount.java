package org.ilearniteach.coding;

public class BitCount {
	
	public static int bitCount(int x) {
		int count = 0;
		while (x>0) {
			int a = x & 0x1;
			count += a;
			x = x >>> 1;
		}
		
		return count;
	}
	
	public static int bitCountParallel(int x) {
//		x = (x & 0x55555555)  + ( x& 0xAAAAAAAA) >>> 1;
		x = (x & 0x55555555)  + ( (x>>>1) & 0x55555555) ;
		x = (x & 0x33333333)  + ( (x>>>2) & 0x33333333) ;
		x = (x & 0x0f0f0f0f)  + ( (x>>>4) & 0x0f0f0f0f) ;
		x = (x & 0x00ff00ff)  + ( (x>>>8) & 0x00ff00ff) ;
		x = (x & 0x0000ffff)  + ( (x>>>16) & 0x0000ffff) ;
		
		return x;
	}
	
	
	
	public static void main(String[] args) {
		int x = 5;
		int c = Integer.bitCount(5);
		System.out.println(c);
		
		c = bitCount(5);
		System.out.println(c);
		
		c = bitCountParallel(5);
		System.out.println(c);
	}
}
