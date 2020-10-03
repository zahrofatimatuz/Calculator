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
import view.feedbackPenyakit;
import view.homePetani;

/**
 *
 * @author Vin
 */
public class c_feedback {

    feedbackPenyakit view;
    m_feedback model;

    public c_feedback(feedbackPenyakit view, m_feedback model) throws SQLException {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        view.addSubmitListener(new saveListener());
        view.addBackListener(new backListener());
        view.setTable(model.getTableModel());
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                if (view.getPenyakit().isEmpty() || view.getVaksin().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Isi dengan benar!!");
                } else {
                    model.save("'" + view.getPenyakit() + "','" + view.getVaksin() + "', 'Tidak Disetujui'");
                    view.setTable(model.getTableModel());
//                view.setPetani("");
//                view.setLuas("");
                    view.setPenyakit("");
                    view.setVaksin("");
                    view.text(true);
                    view.buttonsave(true);
                    view.button(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_feedback.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homePetani a = new homePetani();
            a.setVisible(true);

            try {
                c_menuPetani theController = new c_menuPetani(a, new m_user());
            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            view.dispose();

        }

    }

}
