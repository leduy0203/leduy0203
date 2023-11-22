package quan_li_net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachNhanVien {
	NhanVien[] arr;
	int n;
	int count = 0;

	public DanhSachNhanVien() {
		n = 0;
		arr = null;
	}

	public void luachon() {
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("Nhập số lượng nhân viên cần nhập ban đầu: ");
		n = Integer.parseInt(sc.nextLine());
		arr = new NhanVien[n];
		boolean flag = true;
		outer: while (flag) {
			System.out.println("----------------Nhập lựa chọn-------------");
			System.out.println("1.Nhập nhân viên phục vụ.");
			System.out.println("2.Nhập nhân viên Quản lí. ");
			System.out.println("3.Tìm kiếm nhân viên (Mã nhân viên). ");
			System.out.println("4.Thêm một nhân viên. ");
			System.out.println("5.Xoá một nhân viên. ");
			System.out.println("6.Xuất danh sách nhân viên.");
			System.out.println("7.Xuất danh sách lương của từng nhân viên.");
			System.out.println("8.Ghi file danh sách nhân viên. ");
			System.out.println("9.Đọc file danh sách nhân viên. ");
			System.out.println("10.Thoát khỏi chương trình.");
			x = Integer.parseInt(sc.nextLine());
			switch (x) {
			case 1:
				System.out.println("Nhập nhân viên (Phục vụ) " + "(" + (count + 1) + "/" + n + ")");
				arr[count] = new PhucVu();
				arr[count].nhap();
				count++;
				break;
			case 2:
				System.out.println("Nhập nhân viên (Quản lí) " + "(" + (count + 1) + "/" + n + ")");
				arr[count] = new QuanLi();
				arr[count].nhap();
				count++;
				break;
			case 3:
				System.out.println("Nhập mã nhân viên cần tìm kiếm:");
				String maTimKiem = sc.nextLine();
				timkiem(maTimKiem);
				break;
			case 4:
				String choice;
				do {
					System.out.println("Nhập lựa chọn của bạn");
					System.out.println("1. Thêm nhân viên (Phục vụ)");
					System.out.println("2. Thêm nhân viên (Quản lí)");
					int c = Integer.parseInt(sc.nextLine());

					switch (c) {
					case 1:
						ThemNvPhucvu();
						break;
					case 2:
						ThemNvQuanli();
						break;
					default:
						System.out.println("Lựa chọn không hợp lệ");
						break;
					}
					System.out.println("Bạn có muốn tiếp tục thêm hay không (y/n)?");
					choice = sc.nextLine();
					if (choice.equalsIgnoreCase("n")) {
						continue outer;
					}
				} while (true);
			case 5:
				System.out.println("Nhập mã nhân viên cần xoá:");
				String maNhanVien = sc.nextLine();
				XoaNhanVien(maNhanVien);
				break;
			case 6:
				System.out.println("Danh sách tất cả nhân viên");
				XuatDanhSachNV();
				break;
			case 7:
				Tinhluong();
				break;
			case 8:
				ghifile();
				break;
			case 9:
				docfile();
				break;
			case 10:
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
				break;
			}
		}
	}

	public void timkiem(String maTimKiem) {
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].maNhanVien.equalsIgnoreCase(maTimKiem)) {
					arr[i].xuat();
					flag = 1;
				}
			}
		}
		if (flag == 0) {
			System.out.println("Không tìm thấy mã nhân viên trong danh sách !");
		}
	}

	public void ThemNvPhucvu() {
		System.out.println("Nhâp thông tin nhân viên cần thêm :");
		NhanVien nv = new PhucVu();
		nv.nhap();
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[n] = nv;
		n++;
	}

	public void ThemNvQuanli() {
		System.out.println("Nhâp thông tin nhân viên cần thêm :");
		NhanVien nv = new QuanLi();
		nv.nhap();
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[n] = nv;
		n++;
	}

	public void XoaNhanVien(String maNhanVien) {
		int flag = 0;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].maNhanVien.equalsIgnoreCase(maNhanVien)) {
					index = i;
					flag = 1;
					break;
				}
			}
		}
		if (flag == 1) {
			for (int i = index; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			n--;
			arr = Arrays.copyOf(arr, arr.length - 1);
			System.out.println("Xoá thành công");
		} else {
			System.out.println("Không tìm thấy mã nhân viên cần xoá !!!");
		}
	}

	public void XuatDanhSachNV() {
		System.out.println("--------------Danh sách nhân viên (Phục vụ)----------------- ");
		for (NhanVien nhanVien : arr) {
			if (nhanVien instanceof QuanLi) {
				nhanVien.xuat();
			}
		}
		System.out.println("--------------Danh sách nhân viên (Quản lí)------------------ ");
		for (NhanVien nhanVien : arr) {
			if (nhanVien instanceof PhucVu) {
				nhanVien.xuat();
			}
		}
	}

	public void Tinhluong() {
		System.out.println("---------Danh sách lương của từng nhân viên------");
		for (NhanVien nhanVien : arr) {
			if (nhanVien != null) {
				System.out.println(nhanVien.TinhLuong());
			}
		}
	}

	public void ghifile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("Nhanvien.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(arr);
			System.out.println("Ghi file thành công.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void docfile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("Nhanvien.dat");
			ois = new ObjectInputStream(fis);
			arr = (NhanVien[]) ois.readObject();

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null) {
					arr[i].xuat();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
