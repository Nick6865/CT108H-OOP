package De03;

import java.util.Scanner;

public class CNguoi {
	
	static Scanner sc = new Scanner(System.in);
	
	private String id;
	private String hten;
	private String ngay;
	private char   phai;
	
	public CNguoi() {
		id = new String("");
		hten = new String("");
		ngay = new String("");
		phai = 'M';
	}
	
	public CNguoi(CNguoi a) {
		id = new String(a.id);
		hten = new String(a.hten);
		ngay = new String(a.ngay);
		phai = a.phai;
	}
	
	public void nhap() {
		System.out.println("Nhap thong tin: ");
		System.out.println("Nhap CMND: ");
		id = sc.nextLine();
		System.out.println("Nhap ho ten: ");
		hten = sc.nextLine();
		System.out.println("Nhap ngay thang nam sinh: ");
		ngay = sc.nextLine();
		System.out.println("Nhap phai (M/F): ");
		phai = sc.nextLine().charAt(0);
	}
	
	public void in() {
		System.out.println("Hien thi thong tin: ");
		System.out.println("CMND: " + id);

		System.out.println("Ho ten: " +hten);

		System.out.println("Ngay thang nam sinh: " + ngay);

		System.out.println("Phai: " + phai + "\n");

	}
	
	public String toString() {
		return(
			("CMND: " + id)+
			("Ho ten: " +hten)+
			("Ngay thang nam sinh: " + ngay) +
			("Phai: " + phai + "\n"));
	}
	
	public String getN() {
		return ngay;
	}
	
	
	
	public static void main(String[] args) {
		CNguoi c1 = new CNguoi();
		c1.nhap();
		c1.in();
		CNguoi c2 = new CNguoi(c1);
	}

}
