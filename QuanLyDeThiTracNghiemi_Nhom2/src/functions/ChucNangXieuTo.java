/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;
import CTDL.CauHoiNhieuLC;
import CTDL.CauHoiYesNo;
import java.util.ArrayList;
import java.util.Scanner;

public class ChucNangXieuTo {
    //public ArrayList<CauHoi> danhsachCauHoi;
    ArrayList<CauHoiYesNo> list2 = new ArrayList<CauHoiYesNo>();
    ArrayList<CauHoiNhieuLC> list1 = new ArrayList<CauHoiNhieuLC>();
//    public void ThemCH() {
//        Scanner sc= new Scanner(System.in);
//        int choice = 0;
//        System.out.println("Chọn loại câu hỏi");
//        System.out.println("1. Câu hỏi nhiều lựa chọn");
//        System.out.println("2. Câu hỏi Yes/No");
//        choice = sc.nextInt();
//        do {
//            switch(choice) {
//            case 1:
//                CauHoiNhieuLC l1 = new CauHoiNhieuLC() {
//                @Override
//                public void setDapAn(boolean b) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            };
//                l1.nhapCH();
//                list1.add(l1);
//                break;
//            case 2:
//                CauHoiYesNo l2 = new CauHoiYesNo();
//                l2.nhapCH();
//                list2.add(l2);
//                break;
//            default:   
//                System.out.println("Moi ban chon lai!");
//                break;
//            }
//        } while(choice!=0);
//    }
    public void XoaCH() {
        Scanner sc = new Scanner(System.in);
        int d = 0, d2 = 0, choice2 = 0;
        System.out.println("Chọn loại câu hỏi");
        System.out.println("1. Câu hỏi nhiều lựa chọn");
        System.out.println("2. Câu hỏi Yes/No");
        choice2 = sc.nextInt();
        do {
            switch (choice2) {
            case 1:
                System.out.println("Nhap ma cau hoi can xoa");
                String tmp = sc.nextLine();
                for (int i = 0; i < list1.size(); i++) {
                    if (tmp.equals(list1.get(i).getMaCH())) {
                    d++;
                    list1.remove(i);
                    }
                }
                if (d == 0) {
                    System.out.println("Khong tim thay ma!");
                }
                break;
            case 2:
                System.out.println("Nhap ma cau hoi can xoa");
                String tmp2 = sc.nextLine();
                for (int j = 0; j < list2.size(); j++) {
                    if (tmp2.equals(list2.get(j).getMaCH())) {
                    d2++;
                    list2.remove(j);
                    }
                }
                if (d2 == 0) {
                    System.out.println("Khong tim thay ma!");
                }
                break;
            default: 
                System.out.println("Moi ban chon lai");
                break;
            }
        }while(choice2 !=0);
    }

}  