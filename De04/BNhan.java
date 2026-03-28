package De04;

import java.util.Scanner;

public class BNhan {
	
	static Scanner sc = new Scanner(System.in);
	
	private String hten;
	private boolean gtinh; //true trai?
	private int nsinh;
	private float cnang;
	
	public BNhan() {
		hten = new String("");
		gtinh = true;
		nsinh = 2000;
		cnang = 50;
	}
	
	public BNhan(BNhan a) {
		hten = new String(a.hten);
		gtinh = a.gtinh;
		nsinh = a.nsinh;
		cnang = a.cnang;
	}
	
	public void nhap() {
		System.out.println("Nhap thong tin benh nhan: ");
		System.out.println("Ho ten: ");
		hten = sc.nextLine();
		System.out.println("Gioi tinh (0)Nam (1)Nu:");
		int c = sc.nextInt();
		/*if(c == 0) {
			gtinh = true;
		}else if(c == 1) gtinh = false;*/
		//trick lo
		gtinh = (c == 0);
		
		System.out.println("Nam sinh: ");
		nsinh = sc.nextInt();
		sc.nextLine();
		System.out.println("Can nang: ");
		cnang = sc.nextFloat();
		sc.nextLine();
	}
	
	public void in() {
		System.out.println("Thong tin benh nhan: ");
		System.out.println("Ho ten: " +hten);
		
		if(gtinh == true)	System.out.println("Gioi tinh: nam");
		else if(gtinh == false)	System.out.println("Gioi tinh: nu");

		System.out.println("Nam sinh: " +nsinh);

		System.out.println("Can nang: " + cnang + "\n");
	}
	
	public String toString() {
		String s = new String();
		s += ("Thong tin benh nhan: ");
		s +=("Ho ten: " +hten);
		
		if(gtinh == true)	s+=("Gioi tinh: nam");
		else if(gtinh == false)	s+=("Gioi tinh: nu");

		s+=("Nam sinh: " +nsinh);

		s+=("Can nang: " + cnang + "\n");
		return s;
	}
	
	public static void main(String[] args) {
		BNhan bn1 = new BNhan();
		bn1.nhap();
		bn1.in();
		BNhan b2 = new BNhan(bn1);

	}

}
