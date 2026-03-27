
package GiaoDichTaiKhoan;

import java.util.Scanner;

public class GiaoDich {
	private int magd;
	private String ngay;
	private String loaigd;
	private double sotien;
	
	private TaiKhoan a;
	
	static Scanner sc = new Scanner(System.in);
	
	public GiaoDich() {
		magd = 0;
		ngay = new String("");
		loaigd = new String("");
		sotien = 0.0;
		a = new TaiKhoan();
	}
	
	public GiaoDich(GiaoDich g) {
		magd = g.magd;
		ngay = new String(g.ngay);
		loaigd = new String(g.loaigd);
		sotien = g.sotien;
		a = new TaiKhoan(g.a);
	}
	
	public void nhap() {
		System.out.println("NHAP THONG TIN GIAO DICH: \n");
		System.out.println("Nhap ma giao dich: ");
		magd = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ngay giao dich:");
		ngay = sc.nextLine();
		System.out.println("Nhap loai giao dich  (GuiTien/RutTien): ");
		loaigd = sc.nextLine();
		System.out.println("Nhap so tien giao dich: ");
		sotien = sc.nextDouble();
		sc.nextLine();
	}
	
	public double tinhPhi() {
	    return sotien - (sotien * 0.02); 
	}
	
	public void in() {
		System.out.println("THONG TIN GIAO DICH: \n");
		System.out.println("Ma giao dich: " + magd);
		System.out.println("Ngay giao dich: " + ngay);
		System.out.println("Loai giao dich: " + loaigd);
		System.out.printf("So tien giao dich: %.01f \n", sotien);
	}
	
	public String toString() {
		return ("Ma giao dich: " + magd + ", Ngay giao dich: " + ngay + ", Loai giao dich: " + loaigd + ", So tien giao dich: " + sotien);
	}
	
	public static void main(String[] args) {
		int n;
		System.out.println("Nhap # giao dich: ");
		n = sc.nextInt();
		
		GiaoDich[] ds1 = new GiaoDich[n];
		
		for(int i = 0; i < n; i++) {
			ds1[i] = new GiaoDich();
			System.out.println("Giao dich " + (i+1) + ": \n");
			ds1[i].nhap();
		}
		
		for(int j = 0; j < n; j++) {
			ds1[j].in();
		}
		
		//hien thi gd lon hon 50000000 hoac ruttien
		System.out.println("\n CAC GIAO DICH LON HON 50000000 hoac RutTien");
		for(int q = 0; q < n; q++) {
			if(ds1[q].sotien > 50000000 || ds1[q].loaigd.equals("RutTien")) {
				ds1[q].in();
			}
		}
		
		System.out.println("\n Tong chi phi theo thang va nam");
		
		boolean[] daTinh = new boolean[n];
		
		for(int k = 0; k < n; k++) {
		    if(!daTinh[k]) { //neu chua tinh
		        String[] ThangNam = ds1[k].ngay.split("[-/]");
		        String thangVanNam = (ThangNam.length >= 3) ? (ThangNam[1] + "-" + ThangNam[2]) : ds1[k].ngay;
		        
		        // cong tong lai
		        double tongPhi = ds1[k].tinhPhi(); 
		        daTinh[k] = true;
		        
		        for(int a = k + 1; a < n; a++) {
		            if(!daTinh[a]) {
		                String[] ThangNamA = ds1[a].ngay.split("[-/]"); //ds1 a
		                String thangVanNamA = (ThangNamA.length >= 3) ? (ThangNamA[1] + "-" + ThangNamA[2]) : ds1[a].ngay; //th ng dung nhap sai, co gang split se bi dung chuong trinh ngay lap tuc nen cho dai
		                
		                if(thangVanNamA.equals(thangVanNam)) { // neu giong thang nam
		                    tongPhi += ds1[a].tinhPhi();
		                    daTinh[a] = true;
		                }
		            }
		        }
		        System.out.printf("-> %s: Tong phi la: %.0f VND \n", thangVanNam, tongPhi);	
		    }
		}
		
		//tim so tien giao dich lon nhat
		double max = 0.0;
		int lonnhat = 0;
		int b;
		for(b = 0; b <n; b++) {
			if(ds1[b].sotien > max) {
				lonnhat = b;
				max = ds1[b].sotien;
			}
		}
		
		System.out.println("\n GIAO DICH LON NHAT: \n" );
		ds1[lonnhat].in();
		
		
		//sort
		for(int c = 0; c < n; c++) {
			for(int d = 0; d < n -c -1; d++) {
				if (ds1[d].sotien < ds1[d+1].sotien) {
					GiaoDich temp = ds1[d];
					ds1[d] = ds1[d+1];
					ds1[d+1] = temp;
				}
			}
		}
		System.out.println("\n DANH SACH SAU KHI DA SAP XEP");
		for(int abc = 0; abc < n; abc++) {
			ds1[abc].in();
		}
		
		System.out.println("\n TONG TIEN THEO TUNG LOAI GIAO DICH:");
		double tongRut = 0;
		double tongGui = 0;

		for(int e = 0; e < n; e++) {
		    if(ds1[e].loaigd.equalsIgnoreCase("RutTien")) {
		        tongRut += ds1[e].sotien;
		    } else if (ds1[e].loaigd.equalsIgnoreCase("GuiTien")) {
		        tongGui += ds1[e].sotien;
		    }
		}
		System.out.printf("Tong tien RutTien la: %.0f \n", tongRut);
		System.out.printf("Tong tien GuiTien la: %.0f \n", tongGui);
		
	
	}

}
