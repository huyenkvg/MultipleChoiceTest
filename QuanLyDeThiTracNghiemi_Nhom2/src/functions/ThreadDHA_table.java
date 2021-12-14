/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author CVanHau
 */
public class ThreadDHA_table implements Runnable{
    JLabel dongho;
    int phut;
    public boolean stop = false;
    public ThreadDHA_table(JLabel dh, int ph, boolean st){
        dongho = dh;
        phut = ph;
        stop = st;
    }
    public void draw(int phut, int giay){
        if(phut<10 && giay<10)
            dongho.setText("0"+phut+":"+"0"+giay);
        else if(phut<10) 
            dongho.setText("0"+phut+":"+giay);
        else if(giay <10) 
            dongho.setText(phut+":"+"0"+giay);
        else dongho.setText(phut+":"+giay);
    }
    public void reset(){
        dongho.setText("00:00");
    }
    public void run(){
        draw(phut, 0);
        int i = phut-1;
        while(i>=0&&stop == false){
            for(int j = 59; j>=0; j--){
                try{
                    Thread.sleep(1000);
                        }
                catch(InterruptedException ex){
                    System.err.println("Loi sleep");
                    return;
                }
                draw(i, j);       
            }
            i--;
        }
        if(i<0) JOptionPane.showMessageDialog(null, "Het gio lam bai");
        if(stop == true) JOptionPane.showMessageDialog(null, "Da nop bai");
        stop = true;
    }
}
