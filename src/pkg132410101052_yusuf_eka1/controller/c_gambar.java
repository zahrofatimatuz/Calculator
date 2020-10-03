/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.homeBaru;

/**
 *
 * @author Muhammad Fahmy
 */
public class c_gambar {
    
    homeBaru home;

    public c_gambar(homeBaru home) {
        this.home = home;
        home.setVisible(true);
        home.getBtnGambar().addActionListener(new btnGambar());
       
    }

    private static class btnGambar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            home.getGambar().setIcon();
        }
    }
    
    
    
}
