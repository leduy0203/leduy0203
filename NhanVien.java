package quan_li_net;

import java.io.Serializable;
import java.util.Scanner;

public abstract class NhanVien extends ConNguoi implements Serializable {
	protected String maNhanVien;
	protected double heSoLuong;
	private transient Scanner sc = new Scanner(System.in);
	protected static int count = 0;
	
	
	
	public NhanVien(String maNhanVien ,String hoTen, String diaChi, String soDienThoai, String ngaySinh, double heSoLuong) {
		super(hoTen, diaChi, soDienThoai, ngaySinh);
		// TODO Auto-generated constructor stub
		this.maNhanVien = maNhanVien;
		this.heSoLuong = heSoLuong;
	}

	public NhanVien() {
		super();
		maNhanVien = " ";
		heSoLuong = 0;
		count++;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien() {
		while (true) {
			maNhanVien = sc.nextLine();
			maNhanVien = maNhanVien.toUpperCase();
			if (maNhanVien.matches("NV" + "[0-9]{1,2}")) {
				break;
			} else {
				System.out.println("Định dạng mã Nhan viên: NV__. Ví dụ: NV01");
			}
			System.out.print("Mời nhập lại: ");
		}
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong() {
		while (true) {
			try {
				heSoLuong = Double.parseDouble(sc.nextLine());
				if (heSoLuong >= 0) {
					break;
				} else {
					System.out.print("Hệ số lương không hợp lệ ! Mời nhập lại: ");
				}
			} catch (NumberFormatException exception) {
				System.out.print(" Hệ số lương không đúng định dạng ! Mời nhập lại: ");
			}
		}
	}
	
	public abstract String TinhLuong();
	
	public void nhap() {
		System.out.println("-------------Nhập nhân viên-----------");
		System.out.println("Nhập mã nhân viên :");
		setMaNhanVien();
		super.nhap();
		System.out.println("Nhập hệ số lương :");
		setHeSoLuong();
	}
	
	public void xuat() {
		System.out.println("---------Xuất thông tin nhân viên-------");
		System.out.println("Mã nhân viên :"+maNhanVien);
		super.xuat();
		System.out.println("Hệ số lương :"+heSoLuong);
	}
	///////////////////////hàm xuất danh sách sinh viên //////////////////////////////////
//	public void xuatmangsinhvien()
//    {
//        System.out.println("Danh sach sinh vien vua nhap)");
//        System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
//        System.out.printf("%-12d%-12d%07d\n", 15, 12, 5);
//        System.out.println("+-----------------------------------------------------------------------------------------------+");
//    	//System.out.println("| Ma sv |          Ho va ten           | Ngay sinh  |   Dia chi      |      Dien Thoai   |");
//    	System.out.printf("%-12s%-20s%-12s%-25s%-12s%-12s\n","MaSV","Ho va Ten","Ngay sinh","Dia Chi", "Dien Thoai","Noi hoc");
//        //System.out.println("+--------------------------------%-12s%-20s%-12s%-25s%-12s%-12s\\n\",-------------------------+");
//        //for(int i=0; i<arrsv.length; i++)
//        for(Sinhvien objsv: arrsv)
//        {    
//            //arrsv[i].xuatsinhvien(); 
//            objsv.xuatsinhvien();
//        }
//    }
}
