package De02;

import java.util.Scanner;

public class ChuyenXe {
	static Scanner sc = new Scanner(System.in);
	
	private int msx;
	private String tenlx;
	private String nden;
	private double dthu; //loi nhuan 30% doanh thu
	
	private Xe xe;
	
	public ChuyenXe() {
		msx = 0;
		tenlx = new String("");
		nden = new String("");
		dthu = 0.0;
		xe = new Xe();
	}
	
	public ChuyenXe(ChuyenXe c) {
		msx = c.msx;
		tenlx = new String(c.tenlx);
		nden = new String(c.nden);
		dthu = c.dthu;
		xe = new Xe(c.xe);
	}
	
	public void nhap() {
		System.out.println("Nhap ma so xe: ");
		msx = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ten tai xe: ");
		tenlx = sc.nextLine();
		System.out.println("Nhap noi den:");
		nden = sc.nextLine();
		System.out.println("Nhap doanh thu:");
		dthu = sc.nextDouble();
		sc.nextLine();
		xe.nhap();
	}
	
	public void in() {
		System.out.println("Ma so xe: " + msx);

		System.out.println("Ten tai xe: " + tenlx);

		System.out.println("Noi den: " + nden);

		System.out.printf("Doanh thu: %.02f\n",dthu);

		xe.in();
	}
	
	public String toString() {
		return(("Ma so xe: " + msx)+

		("Ten tai xe: " + tenlx)+

		("Noi den: " + nden)+

		("Doanh thu: " + dthu + "\n")+

		xe.toString());
	}
	
	public double loiNhuan() {
		return dthu * 30 / 100;
	}
	
	public static void main(String[] args) {
		System.out.println("Nhap # chuyen xe");
		int n = sc.nextInt();
		ChuyenXe[] ds1 = new ChuyenXe[n];
		
		for(int i = 0; i < n; i++) {
			ds1[i] = new ChuyenXe();
			ds1[i].nhap();
		}
		System.out.println("\n DANH SACH CAC CHUYEN XE");
		for(int i = 0; i < n; i++) {
			ds1[i].in();
		}
		
		System.out.println("\n XE KHONG DAT TIEU CHUAN");
		
		for(int i = 0; i < n; i++) {
			if(ds1[i].xe.getTT() == 'K' || ds1[i].xe.getTT() == 'k' || ds1[i].dthu < 100000) {
				ds1[i].in();
			}
		}
		
		System.out.println("\n TINH LOI NHUAN THEO THANG NAM");
		
		boolean[] daLuu = new boolean[n];
		
		for(int i = 0; i < n ; i++) {
			if(!daLuu[i]) {
				String[] thangNam = ds1[i].xe.N().split("[-/]");
				String TNcut = (thangNam.length == 3) ? (thangNam[1] + "-" + thangNam[2] + "-" + ds1[i].xe.getLX()) : (ds1[i].xe.N() + " " + ds1[i].xe.getLX());
				double tong = ds1[i].loiNhuan();
				daLuu[i] = true;
				
				for(int j = i + 1; j < n; j++) {
					if(!daLuu[j]) {
						String[] thangNamJ = ds1[j].xe.N().split("[-/]");
						String TNcutJ = (thangNamJ.length == 3) ? (thangNamJ[1] + "-" + thangNamJ[2] + "-" + ds1[j].xe.getLX()) : (ds1[j].xe.N() + " " + ds1[j].xe.getLX());
						
						if(TNcutJ.equalsIgnoreCase(TNcut)) {
							tong += ds1[j].loiNhuan();
							daLuu[j] = true;
						}
					}
				}
			
			System.out.println(TNcut + " co doanh thu la: " + tong);
			}
		}
	}

}
