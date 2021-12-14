/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;

import quanlydethi.ThayDapAn;

public abstract class CauHoi implements ThayDapAn{
  
    public static final String YESNO = "YES_NO_OPTIONS";
    public static final String MULTI = "MULTI_OPTIONS";
    
    protected int maCH;
    protected String noiDung;
    protected String trinhDo;
    protected String maMH;
    protected int chuong;
    protected String loai;
    

    public CauHoi() {
    }
    public CauHoi(CauHoi cauhoi) {
        this.maCH = cauhoi.maCH;
        this.noiDung = cauhoi.noiDung;
        this.trinhDo = cauhoi.trinhDo;
        this.maMH = cauhoi.maMH;
        this.chuong = cauhoi.chuong;
        this.loai = cauhoi.loai;
    }
    
    // nap chong khong truyen dap an
    public CauHoi(int maCH, String noiDung, String trinhDo, String maMH, int chuong, String loai) {
        this.maCH = maCH;
        this.noiDung = noiDung;
        this.trinhDo = trinhDo;
        this.maMH = maMH;
        this.chuong = chuong;
        this.loai = loai;
    }
    

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public int getChuong() {
        return chuong;
    }

    public void setChuong(int chuong) {
        this.chuong = chuong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    // kiểm tra lựa chọn của sinh viên có đúng hay không
     public abstract boolean checkCauTraLoi(Character maLC);
     
     public abstract String hienthidapan();


}
