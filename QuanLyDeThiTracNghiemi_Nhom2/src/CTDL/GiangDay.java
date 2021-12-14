/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;

import java.util.ArrayList;

public class GiangDay {
    public GiangVien giangvien;
    public ArrayList<MonHoc> dsMon;

    public GiangDay(GiangVien giangvien, ArrayList<MonHoc> dsMon) {
        this.giangvien = giangvien;
        this.dsMon = dsMon;
    }
    
    public void addMon(MonHoc e){
        this.dsMon.add(e);
        return;
    }
    
}
