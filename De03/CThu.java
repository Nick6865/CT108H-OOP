package De03;

import java.util.Scanner;

public class CThu extends CNguoi{
	
	static Scanner sc = new Scanner(System.in);
	
	private int so;
	private String vtri;
	private long bthang;
	private String mua; //mua giai la so nam ha??
	private String clb;
	
	public CThu() {
		super();
		so = 0;
		vtri = new String("");
		bthang = 0;
		mua = new String("");
		clb = new String("");
	}
	
	public CThu(CThu c) {
		super(c);
		so = c.so;
		vtri = new String(c.vtri);
		bthang = c.bthang;
		mua = new String(c.mua);
		clb = new String(c.clb);
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("So ao: ");
		so = sc.nextInt();
		sc.nextLine();
		System.out.println("Vi tri (ThuMon/HauVe/TrungVe/TienVe/TienDao): ");
		vtri = sc.nextLine();
		System.out.println("So ban thang: ");
		bthang = sc.nextLong();
		sc.nextLine();
		System.out.println("Mua gia thi dau");
		mua = sc.nextLine();
		System.out.println("Thuoc cau lac bo: ");
		clb = sc.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.println("So ao: " + so);

		System.out.println("Vi tri: " + vtri);

		System.out.println("So ban thang: " + bthang);

		System.out.println("Mua gia thi dau" + mua);

		System.out.println("Thuoc cau lac bo: " + clb);
	}
	
	public String toString() {
		return(
			super.toString()+
			("So ao: " + so)+

			("Vi tri: " + vtri)+

			("So ban thang: " + bthang)+

			("Mua gia thi dau" + mua)+

			("Thuoc cau lac bo: " + clb)
			);
	}
	
	public long luong() {
		if(vtri.compareToIgnoreCase("thumon") == 0) {
			return 3000000;
		}else if(vtri.compareToIgnoreCase("hauve") == 0) {
			return 4000000;
		}else if(vtri.compareToIgnoreCase("trungve") == 0) {
			return 4500000;
		}else if(vtri.compareToIgnoreCase("tienve") == 0) {
			return 5000000;
		}else if(vtri.compareToIgnoreCase("tiendao") == 0) {
			return 7000000;
		}
		return 0;
	}
	
	public long luongBT() {
		
		return (luong() + (bthang * 500000));
	}
	
	public double luongThue() {
		return luongBT() - (luongBT()/10);
	}
	
	public static void main(String[] args) {
		System.out.println("Nhap danh sach gom # con nguoi va cau thu: \n");
		int n = sc.nextInt();
		CNguoi[] ds = new CNguoi[n];
		int c;
		for(int i = 0; i< n; i++) {
			System.out.println("Ban la (0)Nguoi thuong hay la (1)Cau thu ?\n");
			do {
				c = sc.nextInt();
				if(c < 0 || c >1) {
					System.out.println("Error!! Please type again!");
				}
			}while(c < 0 || c >1);
			if(c == 0) {
				ds[i] = new CNguoi();
			}
			else ds[i] = new CThu();
			
			ds[i].nhap();
		}
		System.out.println("Danh sach: \n");
		for(int i = 0; i<n;i++) {
			ds[i].in();
		}
		//luong co ban 7tr
		//thu mon 3tr, hau ve 4; trung ve 4.5 tien ve 5 tien dao 7
		//moi ban thang +500
		// -10% thue
		for(int i = 0 ; i<n; i++) {
			if(ds[i] instanceof CThu) {
				CThu a = (CThu) ds[i];
				a.in();
				System.out.println("Tien luong cua cau thu la: " + a.luongThue() + "\n");
			}
		}
		
		boolean[] daTinh = new boolean[n];
		
		System.out.println("THONG KE BAN THANG THEO TUOI VA MUA");
		//lay mua giai tru cho nam sinh => tuoi, phai loc lay clb nua
		//khong phai! thong ke theo mua giai va clb => chi can so sanh clb-mua(nam), con tre trung gia tao bien de ghi nho la dc
		for(int i = 0; i< n; i++) {
			if(!daTinh[i] && ds[i] instanceof CThu) {
				CThu a = (CThu) ds[i]; 
				
				String clbVaMuaI = a.clb + " - " + a.mua;
				
				long tre = 0;
				long trung = 0;
				long gia = 0;
				long tongBT = 0;
				
				daTinh[i] = true;
				
				try {
					String[] ntn1 = a.getN().split("[-/]");
					int tuoi1 = Integer.parseInt(a.mua) - Integer.parseInt(ntn1[2]);
					
					if(tuoi1 >= 18 && tuoi1 <= 24) tre += a.bthang;
					else if(tuoi1 >=25 && tuoi1 <=28) trung += a.bthang;
					else if(tuoi1 >28) gia += a.bthang;
					tongBT += a.bthang;
				}catch (Exception e) {}
				
				for(int j = i+1; j<n ;j++) {
					if(ds[j] instanceof CThu && !daTinh[j]) {
						CThu b = (CThu) ds[j];
						String clbVaMuaJ = b.clb + "-" + b.mua;
						
						if(clbVaMuaJ.equalsIgnoreCase(clbVaMuaI)) {
							daTinh[j] = true;
							
							try {
								String[] ntnJ = b.getN().split("[-/]");
								int tuoiJ = Integer.parseInt(b.mua) - Integer.parseInt(ntnJ[2]);
								
								if(tuoiJ >= 18 && tuoiJ <= 24) tre += b.bthang;
								else if(tuoiJ >=25 && tuoiJ <=28) trung += b.bthang;
								else if(tuoiJ >28) gia += b.bthang;
								tongBT += b.bthang;
							}catch (Exception e) {}
						}
					}
				}
				System.out.println("Thong ke cho: " + clbVaMuaI);
		        System.out.println(" - Nhom Tre (18-24t)  : " + tre + " ban");
		        System.out.println(" - Nhom Trung (25-28t): " + trung + " ban");
		        System.out.println(" - Nhom Gia (>28t)    : " + gia + " ban");
		        System.out.println(" -> TONG CONG         : " + tongBT + " ban\n");
			}
		}
		
		//TIM TONG BAN THANG CUA TUNG CLB VA TIEN LUONG CAO NHAT CUA CAU THU
		System.out.println("TONG BAN THANG CUA CAC CLB VA TIEN LUONG CAO NHAT TRONG CLB DO: \n");
		boolean[] daLuu = new boolean[n];
		for(int i = 0; i < n ; i++) {
			if(!daLuu[i]) {
				daLuu[i] = true;
				
				if(ds[i] instanceof CThu) {
					CThu a = (CThu) ds[i];
					
					String club = a.clb;
					double luong = a.luongThue();
					
					double maxLuong = luong;
					int max = i;
					long maxBT = a.bthang;
					
					for(int j = i+1;j<n;j++) {
						if(!daLuu[j]) {
							if(ds[j] instanceof CThu) {
								
								
								CThu b = (CThu) ds[j];
								
								String clubJ= b.clb;
								double luongJ =b.luongThue();
								
								if(clubJ.equalsIgnoreCase(club)) {
									daLuu[j] = true;
									maxBT += b.bthang;
									
									if(luongJ > maxLuong) {	maxLuong = luongJ; max = j;}
								
								
							}
						}
					}
					System.out.println(club + " co tong ban thang la: " + maxBT);
					System.out.println("Cau thu " + max + " co luong cao nhat clb: " + maxLuong);
				}
				
			}
			
			
		}
		
		
	}

	}
}
