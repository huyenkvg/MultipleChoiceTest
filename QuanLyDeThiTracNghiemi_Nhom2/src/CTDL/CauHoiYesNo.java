/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;

import quanlydethi.ThayDapAn;

public abstract class CauHoiYesNo extends CauHoi implements ThayDapAn {

    // HAMF KHOI TAO
    public boolean dapAn;

    public CauHoiYesNo() {
        super();
        dapAn = true;

    }

    public CauHoiYesNo(int maCH, String noiDung, String trinhDo, String maMH, int chuong, String loai, boolean dapan) {

        super(maCH, noiDung, trinhDo, maMH, chuong, loai);
        dapAn = dapan;
    }

    public CauHoiYesNo(int maCH, String noiDung, String trinhDo, String maMH, int chuong, String loai) {
        super(maCH, noiDung, trinhDo, maMH, chuong, loai);
    }

    //=============================================
    public boolean checkCauTraLoi(Character maLC) {
        if (this.dapAn && maLC == 'T' || (!this.dapAn) && maLC == 'F') {
            return true;
        }
        return false;
    }

    @Override
    public void thayDapAn(LuaChon dapAn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getDapAn() {
        return dapAn;
    }

    public void thayDapAn(boolean dapAn) {
        this.dapAn = dapAn;
    }
    public String hienthidapan(){
        return "T. Đúng\nF. Sai";
    }

}
