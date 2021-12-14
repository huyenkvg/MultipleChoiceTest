/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTDL;

import static CTDL.CauHoi.YESNO;
import java.util.ArrayList;


public class DeThi {
    public String maDT;
    public String maMonHoc;
    public String maLop;
    public String maGV;
    public String ngayThi;
    public int thoiGianThi = 60;
    public int soCau = 60;
    public String trinhDo;
    public ArrayList<CauHoi> danhsachCauHoi;
    
    public DeThi() {
        danhsachCauHoi = new ArrayList<>();
    }
    

    
    public boolean themCauHoi(CauHoi cauhoi)
    {
        if (danhsachCauHoi.size() == soCau)
            return false;
        danhsachCauHoi.add(cauhoi);
        return true;
    }
//    public boolean suaCauHoi(CauHoi cauhoi, int index)
//    {
//        if (cauhoi.loai.equals(YESNO))
//            danhsachCauHoi.get(index) = new CauHoiYesNo(cauhoi.maCH, cauhoi.noiDung, cauhoi.trinhDo, cauhoi.maMH, cauhoi.chuong, YESNO) {};
//        else {
//             danhsachCauHoi.get(index) = new CauHoiNhieuLC(cauhoi.maCH, cauhoi.noiDung, cauhoi.trinhDo, cauhoi.maMH, cauhoi.chuong, YESNO, cauhoi.ds) {};
//  
//        }
//        
//        return true;
//    }
    
    
    
}
