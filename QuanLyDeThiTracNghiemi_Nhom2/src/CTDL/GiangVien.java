/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;

/**
 *
 * @author HUYENKUTE
 */
public class GiangVien {
    private String maGV;
    private String hotten;
    private String hocVi;
    private String hocHam;
    private String chuyenMon;
    private String maKhoa;
    // Nap Chồng
    public GiangVien() {
    }

    public GiangVien(String maGV, String hotten, String hocVi, String hocHam, String chuyenMon, String maKhoa) {
        this.maGV = maGV;
        this.hotten = hotten;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.chuyenMon = chuyenMon;
        this.maKhoa = maKhoa;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHotten() {
        return hotten;
    }

    public void setHotten(String hotten) {
        this.hotten = hotten;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }


    
    
    
}
