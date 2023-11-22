package quan_li_net;

import java.io.Serializable;

public class QuanLi extends NhanVien implements Serializable {
	
	public QuanLi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuanLi(String maNhanVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			double heSoLuong) {
		super(maNhanVien, hoTen, diaChi, soDienThoai, ngaySinh, heSoLuong);
		// TODO Auto-generated constructor stub
	}
	
	public double luong() {
		return heSoLuong * 3000000;
	}
	@Override
	public String TinhLuong() {
		return " Mã nhân viên :" + maNhanVien + " , Họ tên :" + hoTen + " , Lương :"+luong();
	}
}
