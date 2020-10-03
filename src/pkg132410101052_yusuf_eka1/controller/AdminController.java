/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdminModel;
import model.LoginModel;
import model.PemesananModel;
import view.HomeAdminView;
import view.LoginView;
import view.PemesananView;
import view.RekapPenjualanAdminView;
import model.RekapAdminModel;

/**
 *
 * @author World
 */
public class AdminController {

    model.AdminModel theModel;
    view.HomeAdminView theView;

    public AdminController(AdminModel theModel, HomeAdminView theView) {
        this.theModel = theModel;
        this.theView = theView;

        theView.pesanListener(new pesan());
        theView.rekapPesananListener(new rekapPenjualanAdmin());
        theView.logoutListener(new logout());

    }

    private class logout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                LoginView lg = new LoginView();
                theView.dispose();
                lg.setVisible(true);
                LoginModel theModel = new LoginModel();
                LoginController theController = new LoginController(theModel, lg);
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class pesan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                PemesananView a = new PemesananView();
                theView.dispose();
                a.setVisible(true);
                PemesananModel theModel = new PemesananModel();
                PemesananController theController = new PemesananController(theModel, a);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class rekapPenjualanAdmin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                RekapPenjualanAdminView rp = new RekapPenjualanAdminView();
                theView.dispose();
                rp.setVisible(true);
                RekapAdminModel theModel = new RekapAdminModel();
                RekapAdminController theController = new RekapAdminController(theModel, rp);
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
