/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;

import java.util.HashMap;
import quanlydethi.ThayDapAn;

public abstract class CauHoiNhieuLC extends CauHoi implements ThayDapAn {

    public HashMap<Character, LuaChon> danhsachLuaChon;
    public LuaChon dapAn;

    public CauHoiNhieuLC() {
        super();
        this.danhsachLuaChon = new HashMap<>();
        this.dapAn = new LuaChon();
    }

    public CauHoiNhieuLC(int maCH, String noiDung, String trinhDo, String maMH, int chuong, String loai, LuaChon dapAn) {
        super(maCH, noiDung, trinhDo, maMH, chuong, loai);
        this.danhsachLuaChon = new HashMap<>();
        this.dapAn = dapAn;
    }

    public CauHoiNhieuLC(int maCH, String noiDung, String trinhDo, String maMH, int chuong, String loai, HashMap<Character, LuaChon> danhsachLuaChon, LuaChon dapAn) {
        super(maCH, noiDung, trinhDo, maMH, chuong, loai);
        this.danhsachLuaChon = danhsachLuaChon;
        this.dapAn = dapAn;
    }

    public CauHoiNhieuLC(int maCH, String noiDung, String trinhDo, String maMH, int chuong, String loai) {
        super(maCH, noiDung, trinhDo, maMH, chuong, loai);
        this.danhsachLuaChon = new HashMap<>();
        this.dapAn = new LuaChon();
    }

    public LuaChon getDapAn() {

        return dapAn;
    }

    public boolean themLuaChon(LuaChon lc) {
        if (danhsachLuaChon.containsKey(lc.getTenLC())) {
            return false;
        }
        this.danhsachLuaChon.put(lc.getTenLC(), lc);
        return true;
    }

    public boolean xoaLuaChon(Character maLC) {

        if (!danhsachLuaChon.containsKey(maLC)) {
            return false;
        }
        this.danhsachLuaChon.remove(maLC);
        return true;
    }

    public boolean checkCauTraLoi(Character maLC) {
        if (this.dapAn.getTenLC().toString().equalsIgnoreCase(maLC.toString())==true) {
            return true;
        }
        return false;
    }

    public void thayDapAn(LuaChon dapAn) {
        this.dapAn = dapAn;
    }

    @Override
    public void thayDapAn(boolean dapAn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String hienthidapan(){
        String s = "";
        for(Character i : danhsachLuaChon.keySet()){
            s= s+danhsachLuaChon.get(i).getTenLC()+". " + danhsachLuaChon.get(i).getNoiDungLC()+"   ";
        }
        return s;
    }
}
