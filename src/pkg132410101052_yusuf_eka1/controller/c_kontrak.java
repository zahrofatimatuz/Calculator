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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.m_kontrak;
import model.m_user;
import view.datakontrak;
import view.homeAdmin;

/**
 *
 * @author Vin
 */
public class c_kontrak {

    public datakontrak view;
    public homeAdmin theView;
    public m_kontrak model;
    public static double bibit;
    public static double pupuk;

    public c_kontrak(datakontrak view, m_kontrak model) throws SQLException {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        view.addSaveListener(new saveListener());
        view.addDeleteListener(new hapusListener());
        view.addBackListener(new backListener());
        view.getLuas(new hitungLuas());
        view.setTable(model.getTableModel());
        view.setPetani(model.Petani());
    }

    private class hitungLuas implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            //rumus jumlah bibit internasional
            //luas*(10000/2*10000/20)*(100*100)*(jml bibit/lubang)*(berat benih/1000 benih)
//           bibit = ((getluas() * ((10000 / 20) * (10000 / 20))) * (100 / 90) * 3 * (130 / 1000))
//           hit pupuk = luas x (30kg/36)x100
//           pupuk = ((getluas()*(30/36))*100)
            String regex = "[0-9]*\\.?[0-9]*";//untuk menggunakan parameternya
            if (view.getLuas().getText().matches(regex)) {
                bibit = ((Double.valueOf(view.getLuas().getText()) * (Math.pow(500, 2) * 0.9 * 0.39)));
                view.getBibit().setText(Double.toString(bibit / 1000));
                pupuk = ((Double.valueOf(view.getLuas().getText()) * (0.83) * 100));
                view.getPupuk().setText(Double.toString(pupuk));
            } else {
                view.getLuas().setText("");
                JOptionPane.showMessageDialog(view, "Silahkan Masukkan Angka dengan BENAR!1!!1");
            }

        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.idpetani((String) view.getPetani().getSelectedItem());
                model.save(m_kontrak.id + "," + view.getLuas().getText() + "," + view.getBibit().getText() + "," + view.getPupuk().getText());
//                System.out.println(m_kontrak.id + "," + view.getLuas().getText() + "," + view.getBibit().getText() + "," + view.getPupuk().getText());
                view.setTable(model.getTableModel());
//                view.setPetani("");
//                view.setLuas("");
                view.setBibit("");
                view.setPupuk("");
                view.text(true);
                view.buttonsave(true);
                view.button(true);
            } catch (SQLException ex) {
                Logger.getLogger(c_kontrak.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = view.getSelectedRow();
                String idKontrak = view.getValueAt(baris, 0);
                System.out.println(idKontrak);
                model.delete(idKontrak);
                view.setTable(model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_kontrak.class.getName()).log(Level.SEVERE, null, ex);
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

    public void clear() {
        view.setId("");
//        view.setPetani("");
//        view.setLuas("");
        view.setBibit("");
        view.setPupuk("");
    }
}
