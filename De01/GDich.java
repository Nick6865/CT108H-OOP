package De01;

import java.util.Scanner;

public class GDich {
	private int mdg;
	private String hten;
	private String ngay; //ngay-thang-nam
	private boolean tthai;
	
	public GDich() {
		mdg = 0;
		hten = new String("empty");
		ngay = new String("0-0-0");
		tthai= false;
	}
	
	public GDich(GDich g) {
		mdg = g.mdg;
		hten = new String(g.hten);
		ngay = new String(g.ngay);
		tthai= g.tthai;
	}
	
	public int getMa() {
		return mdg;
	}
	
	public boolean getTT() {
		return tthai;
	}
	
	public boolean validNgay(int d, int m, int y) {
		int max[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(y % 400 == 0 || y % 4 == 0 && y % 100 != 0)	
			max[2] = 29; 
		boolean v = false;
		if(d > 0 && m > 0 && y > 0 && m < 13 && d <= max[m] )
			v = true;
		return v;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma giao dich: \n");
		mdg = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ten nguoi giao dich: \n");
		hten = sc.nextLine();
		
		boolean ngayValid = false;
		do{
			System.out.println("Nhap ngay giao dich (DD-MM-YYYY): \n");
			ngay = sc.nextLine();
			try {
				String NTN[] = ngay.split("[-/]");
				if(NTN.length == 3) {
					int d = Integer.parseInt(NTN[0]);
					int m = Integer.parseInt(NTN[1]);
					int y = Integer.parseInt(NTN[2]);
				
					if(validNgay(d,m,y)) {
						ngayValid = true;
					}else {
						System.out.println("Error! this date is not exist! Please type again");
					}
				}else {
					System.out.println("Error! Please type again (DD-MM-YYYY)");
				}
			} catch(Exception e) {
				System.out.println("PLEASE TYPE AGAIN!!!!!");
			}
		}while(!ngayValid);
		
		System.out.println("Trang thai giao dich: \n");
		tthai = sc.nextBoolean();
		
		System.out.println("=====HOAN THANH NHAP=====\n");
	}
	
	public void in() {
		System.out.println("Chi tiet Giao Dich: \n");
		System.out.println("[Ma giao dich: " + mdg + ", ngay giao dich: " + ngay + ", ten nguoi giao dich: " + hten + ", giao dich: " + tthai + "]");
	}
	
	public String toString() {
		return ("[Ma giao dich: " + mdg + ", ngay giao dich: " + ngay + ", ten nguoi giao dich: " + hten + ", giao dich: " + tthai + "]");
	}
	
	public String getNgay() {
		return ngay;
	}
	
	public static void main(String[] args) {
		GDich gd1 = new GDich();
		gd1.nhap();
		
		GDich gd2 = new GDich(gd1);
		
		gd1.in();
		
		gd2.in();
	}
}
