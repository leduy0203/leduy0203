package quan_li_net;

import java.io.Serializable;

public class PhucVu extends NhanVien implements Serializable {

	public double luong() {
		return heSoLuong * 2000000;
	}
	@Override
	public String TinhLuong() {
		return " Mã nhân viên :" + maNhanVien + " , Họ tên :" + hoTen + " , Lương :"+luong();
	}

	
	
	
}
