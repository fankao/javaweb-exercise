package www.bt07.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	private String maSV;
	private String hoVaTen;
	private boolean gioTinh;
	private String diaChi;
	private String soDienThoai;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String maSV, String hoVaTen, boolean gioTinh, String diaChi, String soDienThoai) {
		super();
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		this.gioTinh = gioTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public boolean isGioTinh() {
		return gioTinh;
	}

	public void setGioTinh(boolean gioTinh) {
		this.gioTinh = gioTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
