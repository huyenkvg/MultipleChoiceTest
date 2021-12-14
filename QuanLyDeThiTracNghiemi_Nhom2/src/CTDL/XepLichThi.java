
package CTDL;

public class XepLichThi {
    private String maXepLichThi;
    private String maMH;
    private String maLop;
    private String maGV;
    private String ngayThi; //Khai báo cho vui 
    private int thoiGianThi;
    private int soCau;
    private String trinhDo;
    public XepLichThi() {
    }
    public XepLichThi(String maXepLichThi, String maMH, String maLop, String maGV, String ngayThi, int thoiGianThi, int soCau, String trinhDo) {
        this.maXepLichThi = maXepLichThi;
        this.maMH = maMH;
        this.maLop = maLop;
        this.maGV = maGV;
        this.ngayThi = ngayThi;
        this.thoiGianThi = thoiGianThi;
        this.soCau = soCau;
        this.trinhDo = trinhDo;
    }

    public void setMaXepLichThi(String maXepLichThi) {
        this.maXepLichThi = maXepLichThi;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public void setThoiGianThi(int thoiGianThi) {
        this.thoiGianThi = thoiGianThi;
    }

    public void setSoCau(int soCau) {
        this.soCau = soCau;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getMaXepLichThi() {
        return maXepLichThi;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public int getThoiGianThi() {
        return thoiGianThi;
    }

    public int getSoCau() {
        return soCau;
    }

    public String getTrinhDo() {
        return trinhDo;
    }
    
    
    
    
    
}
