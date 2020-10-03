/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.m_feedback;
import model.m_user;
import view.feedbackAdmin;
import view.homeAdmin;

/**
 *
 * @author Vin
 */
public class c_feedbackAdmin {

    m_feedback model;
    feedbackAdmin view;

    public c_feedbackAdmin(feedbackAdmin view, m_feedback model) throws SQLException {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        view.addSetujuListener(new setujuListener());
        view.addBackListener(new backListener());
        view.addTolakListener(new tolakListener());
        view.setTable(model.getTablePenyakit());
    }

    private class setujuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getTb_penyakit().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(view, "Pilih Data Terlebih Dahulu");
            } else {
                try {
                    model.update("status_penyakit='Disetujui' where id_penyakit=" + (String) view.getTb_penyakit().getValueAt(view.getTb_penyakit().getSelectedRow(), 0));
                    view.buttonsetuju(true);
                    view.button(true);
                    view.setTable(model.getTablePenyakit());
                } catch (SQLException ex) {
                    Logger.getLogger(c_feedbackAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeAdmin a = new homeAdmin();
            a.setVisible(true);

            try {
                c_menuAdmin theController = new c_menuAdmin(a, new m_user());
            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            view.dispose();

        }

    }

    private class tolakListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getTb_penyakit().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(view, "Pilih Data Terlebih Dahulu");
            } else {
                try {
                    model.update("status_penyakit='Ditolak' where id_penyakit=" + (String) view.getTb_penyakit().getValueAt(view.getTb_penyakit().getSelectedRow(), 0));
                    view.buttontolak(true);
                    view.button(true);
                    view.setTable(model.getTablePenyakit());
                } catch (SQLException ex) {
                    Logger.getLogger(c_feedbackAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
