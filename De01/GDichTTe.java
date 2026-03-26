package De01;

import java.util.Scanner;

public class GDichTTe extends GDich {
	private float dgia;
	private int sluong;
	private char loai;
	private float tgia;
	
	public GDichTTe() {
		super();
		sluong = 0;
		loai = 'V';
		tgia = 0;
	}
	
	public GDichTTe(GDichTTe g) {
		super(g);
		dgia = g.dgia;
		sluong = g.sluong;
		loai = g.loai;
		tgia = g.tgia;
	}
	
	public void nhap() {
		super.nhap();
		
		System.out.println("=====Giao Dich Tien Te====\n");
		System.out.println("Nhap don gia: ");
		Scanner sc = new Scanner(System.in);
		dgia = sc.nextFloat();
		System.out.println("Nhap so luong: ");
		sluong = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap loai tien te: ");
		do {
			loai = sc.nextLine().charAt(0);
			if(!valid()) {
				System.out.println("Error! Please type again");
				System.out.println("Eg: 'V' = vnd; 'U' = usd; 'E' = euro");
			}
		}while (!valid());
		System.out.println("Nhap ti gia: ");
		tgia = sc.nextFloat();
	}
	
	public void in() {
		System.out.println("GIAO DICH TIEN TE\n");
		
		super.in();
		System.out.println("[ Don gia: " + dgia + ", so luong: " + sluong + ", tien te: " + loai + ", ti gia: " + tgia + " ]");		
	}
	
	private boolean valid() {
		switch(loai) {
			case 'V': //vnd
				return true;
			case 'U': //usd
				return true;
			case 'E': //eur
				return true;
			default:
				return false;
		}
	}
	
	public double thanhTien() { 
		//tien viet thi khong can nhan ti gia
		if(loai == 'V') {
			return sluong * dgia;
		}
		return  sluong * dgia * tgia;
	}
	
	public static void main(String[] args) {
		int n;
		int c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap # giao dich: ");
		n = sc.nextInt();
		
		sc.nextLine();
		
		GDich ds[];
		ds = new GDich[n];
		
		//GDich[] ds = new GDich[n];
		
		for(int i = 0; i< n ; i++) {
			System.out.println("Nhap giao dich " + (i+1) + ": ");
			System.out.println("Day la (0)Giao dich hay (1)Giao dich tien te");
			do {
				c = sc.nextInt();
				if(c<0 || c>1) {
					System.out.println("Error! Please enter again:");
				}
			}while(c<0 || c>1);
			
			sc.nextLine();
			
			if(c == 0) {
				ds[i] = new GDich();
			}else ds[i] = new GDichTTe();
			ds[i].nhap();
			
		}
		
		System.out.println("\n===== DANH SACH GIAO DICH CO THANH TIEN > 100.000 VND =====");
		boolean coGD = false;
		
		for(int j = 0; j<n ; j++) {
			if(ds[j] instanceof GDichTTe) {//kiem tra co phai giao dich tien te khong
				GDichTTe realgd = (GDichTTe) ds[j];
				if(realgd.thanhTien() > 100000 && realgd.getTT() == true) {
					coGD = true;
					System.out.printf("Ma: %d voi so tien: %.0f VND\n", ds[j].getMa(), realgd.thanhTien());
				}
			}
		}
		if(coGD == false) {
			System.out.println("Khong co giao dich nao tren 10000!!\n");
		}
		
		//thong ke giao dich theo ngay
		System.out.println("=========THONG KE TIEN THEO THANG NAM=========\n");
		boolean[] daTinh = new boolean[n];
		
		for(int q = 0; q < n; q++) {
			//kiem tra co phai la giao dich tt ko
			if(daTinh[q] == false && ds[q] instanceof GDichTTe) {
				GDichTTe gdi = (GDichTTe) ds[q];
				//chi tinh khi giao dich thanh cong
				if(gdi.getTT()) {
					String[] ngayThangNam = ds[q].getNgay().split("[-/]");
					//ham nay se split ra r chia vao chuoi vs 26-3-2026 -> [26][3][2026]
					//vi chac an la se dung khi nhap nen ko can kiem tra
					String thangVaNam = ngayThangNam[1] + "-" + ngayThangNam[2];
					
					double tongTien = gdi.thanhTien();
					daTinh[q] = true;
					
					//vong lap con di tim may thang chung thangNam
					for(int k = q+1; k < n ; k++ ) {
						if(daTinh[k] == false && ds[k] instanceof GDichTTe) {
							GDichTTe gdk = (GDichTTe) ds[k];
							
							String[] ngayThangNamK = ds[k].getNgay().split("[-/]");
							String thangVaNamK = ngayThangNamK[1] + "-" + ngayThangNamK[2];
								//trung thang nam -> cong tien
							if(thangVaNamK.equals(thangVaNam)) {
								tongTien += gdk.thanhTien();
								daTinh[k] = true;
							}
						}
					}
					System.out.printf("%s: co tong tien la: %.0f VND", thangVaNam, tongTien);				
				}
			}
		}
	}
}
