package De05;

import java.util.Scanner;

public class Xe {
	
	static Scanner sc = new Scanner(System.in);
	
	private String so;
	private String ten;
	private long gia;
	private char tthai;
	
	private DCo d;
	
	public Xe() {
		d = new DCo();
		so = new String("");
		ten = new String("");
		gia = 0;
		tthai = 'K';
	}
	
	public Xe(Xe x) {
		d = new DCo(x.d);
		so = new String(x.so);
		ten = new String(x.so);
		gia = x.gia;
		tthai = x.tthai;
	}
	
	public void nhap() {
		d.nhap();
		System.out.println("Nhap thong tin xe: ");
		System.out.println("Bien so xe: "); so = sc.nextLine();
		System.out.println("Ten chu xe: "); ten = sc.nextLine();
		System.out.println("Gia tien: "); gia =sc.nextLong();
		sc.nextLine();
		System.out.println("Trang thai cua xe (C/K): "); tthai =sc.nextLine().charAt(0);
	}
	
	public void in() {
		d.in();
		System.out.println("Thong tin xe: ");
		System.out.println("Bien so xe: " + so);
		System.out.println("Ten chu xe: " + ten);
		System.out.println("Gia tien: " + gia);
		System.out.println("Trang thai cua xe: " + tthai + "\n");
	}
	
	public String toString() {
		
		return(d.toString() + ("Thong tin xe: ")+
		("Bien so xe: " + so)+
		("Ten chu xe: " + ten)+
		("Gia tien: " + gia)+
		("Trang thai cua xe: " + tthai + "\n"));
	}
	
	public float lePhi() {
		return gia/10;
	}
	
	public static boolean soSanh(int m, int y) {//so sanh xem co nho hon ko
		if(y < 2000) {
			return true;
		}else if(y == 2000) {
			if(m < 10) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Nhap # danh sach xe: \n");
		int n = sc.nextInt();
		sc.nextLine();
		
		Xe[] ds1 = new Xe[n];
		
		for(int i = 0 ; i< n;i++) {
			ds1[i] = new Xe();
			ds1[i].nhap();
		}
		for(int i = 0 ; i< n;i++) {
			ds1[i].in();
		}
		System.out.println("DANH SACH TAT CA SO XE BI THU HOI HOAC CO GIA TRI DUOI 10.000.000:\n");
		for(int i = 0 ; i< n;i++) {
			if((ds1[i].tthai == 'K' || ds1[i].tthai == 'k') || ds1[i].gia < 10000000) {
				System.out.println(ds1[i].so + "\n");
			}
		}
		
		System.out.println("TONG LE PHI TRUOC BA CHO TUNG LOAI DONG CO DUOC SAN XUAT TRUOC THANG 10 NAM 2000: \n");
		boolean[] daLuu = new boolean[n];
		for(int i = 0 ; i< n;i++) {
			if(!daLuu[i]) {
				daLuu[i] = true;
				double tong = 0;
				
				String[] nsx = ds1[i].d.getngay().split("[-/]");
				if(nsx.length == 3) {
					int m = Integer.parseInt(nsx[1]);
					int y = Integer.parseInt(nsx[2]);
					
					if(soSanh(m,y)) {
						tong = ds1[i].lePhi(); 
					}	
					for(int j = i+1;j<n;j++) {
						String[] nsxJ = ds1[j].d.getngay().split("[-/]");
						
						if(nsxJ.length == 3) {
							int mJ = Integer.parseInt(nsxJ[1]);
							int yJ = Integer.parseInt(nsxJ[2]);
							
							if(!daLuu[j] && ds1[j].d.getDco().equalsIgnoreCase(ds1[i].d.getDco())) {
								if(soSanh(mJ, yJ)) {
									tong += ds1[j].lePhi();}
								daLuu[j] = true;
							}							
						}	
					}
					System.out.println("Dong co " + ds1[i].d.getDco() + " co tong le phi la: " + tong);
				}
			}
		}
	}
}

