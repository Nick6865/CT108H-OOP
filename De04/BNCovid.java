package De04;

import java.util.Scanner;
//khoi can lam ham tinh ngay import luon
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BNCovid extends BNhan{
	
	static Scanner sc = new Scanner(System.in);
	
	private String ngay; //n-t-n cach ly
	private char loai; //f1 f2vv
	private String odich;
	private String noi; //noi cach ly
	
	public BNCovid() {
		super();
		ngay = new String("");
		loai = '0';
		odich = new String("");
		noi = new String("");
	}
	
	public BNCovid(BNCovid c) {
		super(c);
		ngay = new String(c.ngay);
		loai = c.loai;
		odich = new String(c.odich);
		noi = new String(c.noi);
	}
	
	public void nhap() {
		super.nhap();
		sc.nextLine();
		System.out.println("Nhap thong tinh benh nhan covid:");
		System.out.println("Ngay cach ly (NN-TT-NNNN): ");
		ngay = sc.nextLine();
		System.out.println("Loai nguoi nhiem F(0/1/2/...): ");
		loai = sc.nextLine().charAt(0);
		System.out.println("Thuoc o dich: ");
		odich = sc.nextLine();
		System.out.println("Noi cach ly: ");
		noi = sc.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.println("Thong tinh benh nhan covid:");
		System.out.println("Ngay cach ly (NN-TT-NNNN): " + ngay);
		System.out.println("Loai nguoi nhiem F(" + loai + "): ");

		System.out.println("Thuoc o dich: " + odich);

		System.out.println("Noi cach ly: " + noi +"\n");

	}
	
	public String toString() {
		return(
		super.toString() +
		("Thong tinh benh nhan covid:")+
		("Ngay cach ly (NN-TT-NNNN): " + ngay)+
		("Loai nguoi nhiem F(" + loai + "): ")+

		("Thuoc o dich: " + odich)+

		("Noi cach ly: " + noi +"\n") );
	}
	/* ham nay sai ko can tinh luon (da sua lai)
	public static int ngayconlai(int d, int m, int y) {
		//18/5/2021
		int ngaycv = 18 + 31 +28 + 31 + 30; //138 ngay
		
		boolean nhuan =false;
		int[] t = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(y % 400 == 0 || y%4 ==0 && y%100 != 0) {
			nhuan = true;
		}
		
		if(nhuan) t[2] = 29;
		
		int ngayNhap = d;
		for(int i = 1; i < m; i++) {
			ngayNhap += t[i];
		}
		
		//xu ly logic
		
		//cung nam thi tru, khac nam thi cong don
		if(y = 2021)	return ngaycv - ngayNhap;
		else if(y < 2021){
		 	int ngayConLai = (nhuan ? 366 : 365) - ngayNhap;
		 	
		 	int namOGiua = 0;
		 	for(int i = y + 1; i < 2021; i++{
		 		if(i % 400 == 0 || i%4 ==0 && i%100 != 0) {
					namOGiua += 366;
				} else namOGiua += 365;
		 	}
		 	return ngayConLai + namOGiua + ngaycv;
		}
		
		return -1;
	}
	*/
	
	public static void main(String[] args) {
		System.out.println("Nhap # benh nhan");
		int n = sc.nextInt();
		sc.nextLine();
		BNhan[] ds = new BNhan[n];
		int c;
		
		//nhap va in
		for(int i = 0; i <n ; i++) {
			System.out.println("Day la (0)Benh Nhan hay (1)Benh Nhan Covid ?");
			do {
				c = sc.nextInt();
			}while(c < 0 || c> 1);
			if(c == 0)	ds[i] = new BNhan();
			else if(c==1) ds[i] = new BNCovid();
			
			ds[i].nhap();
		}
		
		for(int i = 0;i<n;i++) {
			ds[i].in();
		}
		//in f1 hosiden
		System.out.println("BENH NHAN F1 O DICH HOSIDEN:");
		for(int i = 0; i <n;i++) {
			if(ds[i] instanceof BNCovid) {
				BNCovid a = (BNCovid) ds[i];
				if(a.loai == '1' && a.odich.equalsIgnoreCase("Cong ty Hosiden")) {
					a.in();
				}
			}
		}
		//liet ke benh nhan het tg cach ly
		//14 ngay dc tha, tu ngay 18/5/2021 ai dc tha
		//neu so nam < 2021 auto tha
		//so sanh thang 5 - thangcl = 2 auto tha
		//neu thang = nhau hoac chenh lech thi tinh ngay
		
		System.out.println("Danh sach ben nhan het cach ly: ");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayChot = LocalDate.parse("18/05/2021", dtf); //ngay moc
		
		for(int i = 0; i<n; i ++) {
			if(ds[i] instanceof BNCovid) {
				BNCovid a = (BNCovid) ds[i];
				
				try {
                    // chong loi nhap sai
                    String ngayNhap = a.ngay.replace("-", "/"); 
                    LocalDate ngayCachLy = LocalDate.parse(ngayNhap, dtf);
                    
                    // trick lo
                    long soNgayCachLy = ChronoUnit.DAYS.between(ngayCachLy, ngayChot);
                    
                    if(soNgayCachLy >= 14) {
                        System.out.println("-> Da cach ly " + soNgayCachLy + " ngay. Duoc the tha!");
                        a.in();
                    }
                } catch (Exception e) {
                    System.out.println("! Loi dinh dang ngay cua benh nhan: " + a.ngay + " (Khong the tinh toan)");
                }
			}
		}
	}

}
