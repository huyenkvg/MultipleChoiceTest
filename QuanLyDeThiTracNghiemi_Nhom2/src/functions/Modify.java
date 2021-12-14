/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import CTDL.CauHoi;
import static CTDL.CauHoi.MULTI;
import static CTDL.CauHoi.YESNO;
import CTDL.CauHoiNhieuLC;
import CTDL.CauHoiYesNo;
import CTDL.LuaChon;
import CTDL.MonHoc;
import CTDL.XepLichThi;
import static functions.DBConection.layKetNoi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUYENKUTE
 */
public class Modify {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<CauHoi> BoDeNguon = LayTatCaCauHoi(); //tat ca cac mon

    public static ArrayList<MonHoc> layDanhSachMonHoc(String maGV) {
        ArrayList<MonHoc> dsMon = new ArrayList<MonHoc>();
        Connection kn = layKetNoi();
        Statement st = null;
        try {
            st = (Statement) kn.createStatement();
            String sql = "SELECT c.MAMH, TENMH\n"
                    + "FROM MONHOC as c, GIANGDAY as d\n"
                    + "WHERE c.MAMH = d.MAMH AND MAGV = '" + maGV + "'"; //Đợi giao diện từ huyền yêu dấu <3
            ResultSet rs = st.executeQuery(sql);
            MonHoc mh;
            while (rs.next()) {
                mh = new MonHoc(rs.getString("MAMH"), rs.getString("TENMH"));
                dsMon.add(mh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsMon;
    }

    public static ArrayList<XepLichThi> layDanhSachLichThi(String maGV) {
        ArrayList<XepLichThi> dsLichThi = new ArrayList<XepLichThi>();
        Connection kn = layKetNoi();
        Statement st = null;
        try {
            st = (Statement) kn.createStatement();
            String sql = "SELECT *\n"
                    + "FROM  XEPLICHTHI as e\n"
                    + "WHERE MAGV = '" + maGV + "'"; //Đợi giao diện từ huyền yêu dấu 
            ResultSet rs = st.executeQuery(sql);
            XepLichThi lT;
            while (rs.next()) {
                lT = new XepLichThi(rs.getString("MAXEPLICHTHI"), rs.getString("MAMH"), rs.getString("MALOP"), rs.getString("MAGV"), rs.getString("NGAYTHI"), rs.getInt("THOIGIANTHI"), rs.getInt("SOCAU"), rs.getString("TRINHDO"));
                dsLichThi.add(lT);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLichThi;
    }

    public static boolean ThemLuaChonVaoCSDL(CauHoiNhieuLC cauHoi) {

        Connection ketNoi = DBConection.layKetNoi();
        int loai = 0;
        try {
//            System.out.println("INSERT INTO CAUHOI (MANV, MAKH) VALUES('" + phieu.getMaNV() + "','" + phieu.getMaKH() + "');");
            Statement stmt = ketNoi.createStatement();

            // show map
            Iterator<Character> itr = cauHoi.danhsachLuaChon.keySet().iterator();
            while (itr.hasNext()) {
                //            System.out.println(cauHoi.danhsachLuaChon.get(itr.next()));
                LuaChon tmp = cauHoi.danhsachLuaChon.get(itr.next());
                stmt.executeUpdate("INSERT [dbo].[LUACHON] ([TENLC], [MACH], [NOIDUNG]) VALUES (N'" + tmp.getTenLC() + "', " + cauHoi.getMaCH() + ", N'" + tmp.getNoiDungLC() + "')\n");
            }
            System.out.println("Thêm danh sách lựa chọn thành công!!");
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean ThemCauHoiVaoCSDL(CauHoi ch) {
        CauHoiYesNo yesno = null;
        CauHoiNhieuLC multi = null;
        Connection ketNoi = DBConection.layKetNoi();
        int loai = 0;
        if (ch instanceof CauHoiYesNo) {
            yesno = ((CauHoiYesNo) ch);
            loai = 1;
        } else {
            multi = ((CauHoiNhieuLC) ch);
        }
        try {
//            System.out.println("INSERT INTO CAUHOI (MANV, MAKH) VALUES('" + phieu.getMaNV() + "','" + phieu.getMaKH() + "');");
            Statement stmt = ketNoi.createStatement();
            int row = -1;
            if (loai == 1) {
                stmt.executeUpdate("insert into CAUHOI ( NOIDUNG, DAPAN, MAMH, LOAI, CHUONG ,TRINHDO) VALUES ( N'" + yesno.getNoiDung() + "', '" + (yesno.getDapAn() == true ? "T" : "F") + "', '" + yesno.getMaMH() + "', 'YES_NO_OPTIONS','" + yesno.getChuong() + "',N'" + yesno.getTrinhDo() + "');", Statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    row = generatedKeys.getInt(1);
                }
                yesno.setMaCH(row);
                System.out.println("MA CH VUA UPDATE: " + row + "  :  " + yesno.getMaCH());
                BoDeNguon.add(yesno);
                return true;

            } else {
                stmt.executeUpdate("insert into CAUHOI ( NOIDUNG, DAPAN, MAMH, LOAI, CHUONG ,TRINHDO) VALUES ( N'" + multi.getNoiDung() + "', '" + (multi.getDapAn().getTenLC()) + "', '" + multi.getMaMH() + "', 'MULTI_OPTIONS','" + multi.getChuong() + "',N'" + multi.getTrinhDo() + "');", Statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    row = generatedKeys.getInt(1);
                }
                multi.setMaCH(row);
                System.out.println("MA CH VUA UPDATE: " + row + "  :  " + multi.getMaCH());
                if (ThemLuaChonVaoCSDL(multi)) {
                    BoDeNguon.add(multi);
                    return true;
                }

            }

        } catch (SQLException ex) {
            System.out.println("Khong Update duoc: ADD CauHOi Vao SQL");
            ex.printStackTrace();
        }
        return false;
    }

    public static CauHoi TimKiemCauHoi(int ID_CauHoi) {

        ArrayList<CauHoi> ds = new ArrayList<>();
        CauHoi cau = null;
        for (CauHoi x : BoDeNguon) {
            if (x.getMaCH() == ID_CauHoi) {
                return x;
            }
        }
        return null;
    }

    public static ArrayList<CauHoi> LayDsCauHoiCuaMon(String maMon) {

        ArrayList<CauHoi> ds = new ArrayList<>();
        for (CauHoi x : BoDeNguon) {
            if (x.getMaMH().equals(maMon)) {
                ds.add(x);
            }
        }
        return ds;

    }

    public static ArrayList<CauHoi> LayTatCaCauHoi() {
        Connection conn = DBConection.layKetNoi();
        CauHoiNhieuLC tmp;
        ResultSet rs;
        Statement st;
        ArrayList<CauHoi> ds = new ArrayList<>();
        CauHoi cau = null;
        try {
            st = conn.createStatement();
            System.out.println("select * from CAUHOI");
            rs = st.executeQuery("select * from CAUHOI");
            while (rs.next()) {
                if (rs.getString("LOAI").equals(MULTI)) {
                    cau = new CauHoiNhieuLC(rs.getInt("MACH"), rs.getString("NOIDUNG"), rs.getString("TRINHDO"), rs.getString("Mamh"), rs.getInt("Chuong"), MULTI, new LuaChon(rs.getString("DAPAN").charAt(0), rs.getString("DAPAN"))) {
                    };

                } else if (rs.getString("LOAI").equals(YESNO)) {
                    cau = new CauHoiYesNo(rs.getInt("MACH"), rs.getString("NOIDUNG"), rs.getString("TRINHDO"), rs.getString("Mamh"), rs.getInt("Chuong"), YESNO, rs.getString("DAPAN").equals("T") ? true : false) {
                    };
                }
                //================================================================
                
                if (cau instanceof CauHoiNhieuLC) {
                    tmp = (CauHoiNhieuLC) cau;
                    tmp.danhsachLuaChon = LayDsLuaChon_CauHoiNhieuLC(cau.getMaCH());
                    cau = tmp;
                }
                ds.add(cau);
            }
            System.out.println("Lay danh sah cau hoi  : load xong");
        } catch (SQLException ex) {
            System.out.println("loi load danh sach tra cuu");
            ex.printStackTrace();
        }
        return ds;

    }

    public static HashMap<Character, LuaChon> LayDsLuaChon_CauHoiNhieuLC(int IDCauHoi) {
        Connection conn = DBConection.layKetNoi();
        ResultSet rs;
        Statement st;
        HashMap<Character, LuaChon> ds = new HashMap<>();
        LuaChon lc = null;
        try {
            st = conn.createStatement();
            System.out.println("select * from LUACHON where MACH = '" + IDCauHoi + "'");
            rs = st.executeQuery("select * from LUACHON where MACH = '" + IDCauHoi + "'");
            while (rs.next()) {
                System.out.println("Ten LC: " + rs.getString("TENLC"));
                ds.put(rs.getString("TENLC").charAt(0), new LuaChon(rs.getString("TENLC").charAt(0),rs.getString("NOIDUNG")));
            }
            System.out.println("Lay danh sach LUACHON : load xong");
        } catch (SQLException ex) {
            System.out.println("loi load danh sach tra cuu");
            ex.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<CauHoi> ds = LayDsCauHoiCuaMon("LSD");
        for (CauHoi x : ds) {
            System.out.println("---> " + x.getMaMH() + " | " + x.getNoiDung() + " | " + x.getTrinhDo() + " | " + x.getLoai() + " | " + x.getMaMH() + " | " + x.getChuong());

        }
        HashMap<Character, LuaChon> dsLC = LayDsLuaChon_CauHoiNhieuLC(1);
        System.out.println("--> luachon " + dsLC.get('A').getNoiDungLC());
        System.out.println("--> luachon " + dsLC.get('B').getNoiDungLC());
        System.out.println("--> luachon " + dsLC.get('C').getNoiDungLC());
        System.out.println("--> luachon " + dsLC.get('D').getNoiDungLC());
    }

}
