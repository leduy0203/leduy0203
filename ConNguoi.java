package quan_li_net;

import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConNguoi implements Serializable {
	
	protected String hoTen;
	protected String diaChi;
	protected String soDienThoai;
	protected String ngaySinh;
	protected String taiKhoan;
	private transient Scanner sc = new Scanner(System.in);
	
	

	public ConNguoi(String hoTen, String diaChi, String soDienThoai, String ngaySinh) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
	}

	public ConNguoi() {
		hoTen = " ";
		diaChi = " ";
		soDienThoai = " ";
		ngaySinh = " ";
		taiKhoan = " ";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen() {
		while (true) {
			hoTen = sc.nextLine();
			if (hoTen.matches("[\\pL\\pMn*\\s*]+")) {
				hoTen = hoTen.trim();
				hoTen = hoTen.replaceAll("\\s+", " ");
				hoTen = hoTen.toLowerCase();
				String[] Chuoi = hoTen.split(" ");
				hoTen = "";
				for (int i = 0; i < Chuoi.length; i++) {
					hoTen += String.valueOf(Chuoi[i].charAt(0)).toUpperCase() + Chuoi[i].substring(1);
					if (i < Chuoi.length - 1) {
						hoTen += " ";
					}
				}
				break;
			} else {
				System.out.print("Tên không hợp lệ! Mời nhập lại: ");
			}
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi() {
		while (true) {
			diaChi = sc.nextLine();
			if (diaChi.matches("[\\pL\\pMn*\\d\\s*,./-]+")) {
				break;
			} else {
				System.out.print("Địa chỉ không hợp lệ! Mời nhập lại: ");
			}
		}
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai() {
		while (true) {
			soDienThoai = sc.nextLine();
			if (soDienThoai.matches("\\d{10}") && !soDienThoai.matches(".*[a-zA-Z].*")) {
				break;
			} else {
				System.out.print("Số điện thoại không hợp lệ! Mời nhập lại: ");
			}
		}
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    
	    while (true) {
	        String input = sc.nextLine();
	        try {
	            Date date = sdf.parse(input);
	            ngaySinh = sdf.format(date);
	            break;
	        } catch (ParseException e) {
	            System.out.print("Ngày sinh không hợp lệ! Mời nhập lại (dd/MM/yyyy): ");
	        }
	    }
    }

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public void nhap() {
		System.out.println("Nhập họ tên :");
		setHoTen();
		System.out.println("Nhập địa chỉ :");
		setDiaChi();
		System.out.println("Nhập số điện thoại :");
		setSoDienThoai();
		System.out.println("Nhập ngày sinh :");
		setNgaySinh();
	}
	
	public void xuat() {
		System.out.println("Họ và tên sinh viên :"+hoTen);
		System.out.println("Địa chỉ :"+diaChi);
		System.out.println("Số điện thoại :"+soDienThoai);
		System.out.println("Ngày sinh :"+ngaySinh);
	}
	
	
	@Override
	public String toString() {
		return "ConNguoi [ Họ tên :" + hoTen + ", Địa chỉ :" + diaChi + ",Số điện thoại :" + soDienThoai + ", Ngày sinh :"
				+ ngaySinh + "]";
	}

	public static void main(String[] args) {
		ConNguoi cn = new ConNguoi();
        System.out.println("Nhap vao ho va ten :");
        cn.setHoTen();
        System.out.println("Ho va ten la :"+cn.getHoTen());
//		System.out.println("Nhap so dien thoai :");
//		cn.setSoDienThoai();
//		System.out.println("So dien thoai la :" + cn.getSoDienThoai());
//		System.out.println("Nhap ngay sinh :");
//		cn.setNgaySinh();
//		System.out.println("Ngay sinh la :"+cn.getNgaySinh());
	}
}