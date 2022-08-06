package model;

public class Employee {
    private int maNhanVien;
    private String hoTen;
    private String ngaySinh;
    private String  soCMND;
    private String luong;
    private int soDienThoai;
    private String email;
    private String address;
    private String maViTri;
    private String maTrinhDo;
    private String maBoPhan;

    public Employee() {
    }

    public Employee(int maNhanVien, String hoTen, String ngaySinh, String soCMND, String luong, int soDienThoai, String email, String address, String maViTri, String maTrinhDo, String maBoPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.address = address;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(String maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }
}
