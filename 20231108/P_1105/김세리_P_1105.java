package _20231108;

import java.util.Scanner;

public class _1105_팔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long L = sc.nextLong();
		long R = sc.nextLong();
		int ans=0;
		int Lsize = (int)Math.log10(L)+1; //L 자릿수
		int Rsize = (int)Math.log10(R)+1; //R 자릿수

		while(Rsize > 0) {
			System.out.println(L +" "+ R);
			Lsize = (int)Math.log10(L)+1; //L 자릿수
			Rsize = (int)Math.log10(R)+1; //R 자릿수
			if(Lsize == Rsize) {
				if(Lsize==1) {
					if(L==8 && R==8) {
						ans++; break;
					}else {
						break;						
					}
				}
				else if(L/(int)(Math.pow(10, Lsize-1))==8 && R/(int)(Math.pow(10, Rsize-1))==8) {
					ans++;
					System.out.println("여기");
					L = L%(int)(Math.pow(10, Lsize-1));
					R = R%(int)(Math.pow(10, Rsize-1));
					if(L==0) break;
				}else {
					L = L%(int)(Math.pow(10, Lsize-1));
					R = R%(int)(Math.pow(10, Rsize-1));
					if(L==0) break;
					
				}

			}
			else if(Lsize != Rsize) {
				break;
			}

		}
		System.out.println(ans);
	}//main

}
