
package GiaoDichTaiKhoan;

import java.util.Scanner;

public class TaiKhoan {
	private String matk;
	private String tenchu;
	private String loai;
	private double sodu;
	
	private GiaoDich[] gd;
	
	Scanner sc = new Scanner(System.in);
	
	public TaiKhoan() {
		matk = new String("");
		tenchu = new String("none");
		loai = new String("none");
		sodu = 0.0;
		
	}
	
	public TaiKhoan(TaiKhoan k) {
		matk = new String(k.matk);
		tenchu = new String(k.tenchu);
		loai = new String(k.loai);
		sodu = k.sodu;
	}
	
	public void nhap() {
		System.out.println("NHAP THONG TIN TAI KHOAN:\n");
		System.out.println("Nhap ma tai khoan: ");
		matk = sc.nextLine();
		System.out.println("Nhap ten chu: ");
		tenchu = sc.nextLine();
		System.out.println("Nhap loai tai khoan (TietKiem/ThanhToan)");
		loai = sc.nextLine();
		System.out.println("Nhap so du: ");
		sodu = sc.nextDouble();
		sc.nextLine();
	}
	
	public void in() {
		System.out.println("THONG TIN TAI KHOAN:\n");
		System.out.println("Ma tai khoan:" + matk);
		System.out.println("Ten chu: " + tenchu);
		System.out.println("Loai tai khoan: " + loai);
		System.out.println("So du: " + sodu + "\n");
	}
	
	public String toString() {
		return("Ma tai khoan:" + matk + ", Ten chu: " + tenchu + ", Loai tai khoan: " + loai + ", So du: " + sodu + "\n");
	}
	
	
	public static void main(String[] args) {
		TaiKhoan tk1 = new TaiKhoan();
		tk1.nhap();
		tk1.in();
		
		TaiKhoan tk2 = new TaiKhoan(tk1);
		tk2.in();
	}

}
