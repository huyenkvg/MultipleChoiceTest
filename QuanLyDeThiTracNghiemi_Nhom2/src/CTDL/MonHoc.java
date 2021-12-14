/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;


public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soTietLyThuyet = 0;
    private int soTietThucHanh = 0;

    public MonHoc() {
        
         soTietLyThuyet = 0;
         soTietThucHanh = 0;
    }

    
    public MonHoc(String maMH, String tenMH) {
        this.maMH = maMH;
        this.tenMH = tenMH;
         soTietLyThuyet = 0;
         soTietThucHanh = 0;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getSoTietThucHanh() {
        return soTietThucHanh;
    }

    public void setSoTietThucHanh(int soTietThucHanh) {
        this.soTietThucHanh = soTietThucHanh;
    }
    
    
    
}
