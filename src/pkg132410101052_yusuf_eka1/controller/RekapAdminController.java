/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.*;

/**
 *
 * @author World
 */
public class RekapAdminController {

    model.RekapAdminModel theModel;
    view.RekapPenjualanAdminView theView;

    RekapAdminController(RekapAdminModel theModel, RekapPenjualanAdminView theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.btnHomeAdmin(new homeAdmin());
        theView.setTabel(theModel.getTableModel());

    }

    private class homeAdmin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HomeAdminView ha = new HomeAdminView();
            theView.dispose();
            ha.setVisible(true);
            AdminModel theModel = new AdminModel();
            AdminController theController = new AdminController(theModel, ha);

        }

    }

//    private class rekapPenjualan implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                RekapPenjualanAdminView a = new RekapPenjualanAdminView();
//                theView.dispose();
//                a.setVisible(true);
//                RekapPenjualanAdminView theModel = new RekapPenjualanAdminView();
//                RekapAdminController theController = new RekapAdminController(theModel, a);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
}
