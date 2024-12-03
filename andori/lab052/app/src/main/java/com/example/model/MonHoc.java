package com.example.model;

public class MonHoc {
    private int MaMH; // Mã môn học
    private String tenMH; // Tên môn học
    private int soTiet; // Số tiết

    // Constructor mặc định
    public MonHoc() {
    }

    // Constructor với tham số
    public MonHoc(int maMH, String tenMH, int soTiet) {
        this.MaMH = maMH;
        this.tenMH = tenMH;
        this.soTiet = soTiet;
    }

    // Getter và Setter
    public int getMaMH() {
        return MaMH;
    }

    public void setMaMH(int maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return MaMH + " - " + tenMH + "\n" + soTiet + " tiết";
    }
}
