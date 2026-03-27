package De02;

import java.util.Scanner;

public class Xe {
	private String soxe;
	private String loai;
	private String ngay;
	private char   tthai; //c k
	
	Scanner sc = new Scanner(System.in);
	
	public Xe() {
		soxe = new String("");
		loai = new String("");
		ngay = new String("");
		tthai= 'k';
	}
	
	public Xe(Xe x) {
		soxe = new String(x.soxe);
		loai = new String(x.loai);
		ngay = new String(x.ngay);
		tthai= x.tthai;
	}
	
	public void nhap() {
		System.out.println("Nhap so xe: ");
		soxe = sc.nextLine();
		System.out.println("Nhap loai xe: ");
		loai = sc.nextLine();
		System.out.println("Nhap ngay: ");
		ngay = sc.nextLine();
		System.out.println("Nhap trang thai (C/K): ");
		tthai= sc.nextLine().charAt(0);
	}
	
	public void in() {
		System.out.println("So xe: " + soxe);
		System.out.println("Loai xe: " + loai);
		System.out.println("Ngay: " + ngay);
		System.out.println("Trang thai (C/K): " + tthai);
	}
	
	public String toString() {
		return(
		("So xe: " + soxe)+
		("Loai xe: " + loai)+
		("Ngay: " + ngay)+
		("Trang thai (C/K): " + tthai));
	}
	
	public char getTT() {
		return tthai;
	}
	
	public String getLX() {
		return loai;
	}
	
	public String N() {
		return ngay;
	}
	
	public static void main(String[] args) {
		Xe xe1 = new Xe();
		xe1.nhap();
		xe1.in();
		Xe xe2 = new Xe(xe1);
	}

}