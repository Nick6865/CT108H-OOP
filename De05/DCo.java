package De05;

import java.util.Scanner;

public class DCo {
	
	static Scanner sc = new Scanner(System.in);
	
	private String ten;
	private float dtich;
	private String ngay;
	
	public DCo() {
		ten = new String();
		dtich = 0.0f;
		ngay = new String();
	}
	
	public DCo(DCo e) {
		ten = new String(e.ten);
		dtich = e.dtich;
		ngay = new String(e.ngay);
	}
	
	public void nhap() {
		System.out.println("Nhap thong tin dong co: ");
		System.out.println("Ten dong co: ");
		ten = sc.nextLine();
		System.out.println("Dung tich (lit): "); dtich = sc.nextFloat();
		sc.nextLine();
		System.out.println("Ngay san xuat (DD-MM-YYYY): "); ngay =sc.nextLine();
	}
	
	public void in() {
		System.out.println("Thong tin dong co: ");
		System.out.println("Ten dong co: " + ten);
		
		System.out.println("Dung tich (lit): " +dtich);
		
		System.out.println("Ngay san xuat (DD-MM-YYYY): " + ngay + "\n");
	}
	
	public String toString() {
		return(("Thong tin dong co: ")+
		("Ten dong co: " + ten)+
		
		("Dung tich (lit): " +dtich)+
		
		("Ngay san xuat (DD-MM-YYYY): " + ngay + "\n"));
	}
	
	public String getngay() {
		return ngay;
	}
	
	public String getDco() {
		return ten;
	}
	
	public static void main(String[] args) {
		DCo d1 = new DCo();
		d1.nhap();
		d1.in();
		DCo d2 = new DCo(d1);
		d2.in();
	}

}
