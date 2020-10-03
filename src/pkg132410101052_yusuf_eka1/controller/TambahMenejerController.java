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
import model.ManajerModel;
import model.TambahManajerModel;
import view.HomeManagerView;
import view.TambahAkunView;

/**
 *
 * @author World
 */
public class TambahMenejerController {

    model.TambahManajerModel theModel;
    view.TambahAkunView theView;

    public TambahMenejerController(TambahManajerModel theModel, TambahAkunView theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;

        theView.btnEdit(false);
        theView.btnEditListener(new edit());

        theView.btnPilihListener(new pilih());
        theView.btnKembaliListener(new kembali());
        theView.btnTambahListener(new tambah());
        theView.setTabel(theModel.getTableModel());
        theView.btnTambah(true);

    }

    private class tambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println(theView.getUsername());
                System.out.println(theView.getPassword());
                System.out.println(theView.getAlamat());
                System.out.println(theView.getLevel());
                System.out.println(theView.getIdAkun());

                theModel.save("default , '" + theView.getUsername() + "','" + theView.getPassword() + "','" + theView.getAlamat() +"','" + theView.getLevel()+ "'" + "");
                theView.setTabel(theModel.getTableModel());
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(TambahMenejerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class edit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theView.getSelectedRow();
                String id = theView.getIdAkun();
                String username = theView.getUsername();
                String password = theView.getPassword();
                String alamat = theView.getAlamat();
                theModel.update("username = '" + username + "',password = '" + password + "',alamat = '" + alamat + "',level=1 where id_akun = " + id);
                theView.setTabel(theModel.getTableModel());
                clear();
                theView.btnEdit(false);
                theView.btnTambah(true);
            } catch (SQLException ex) {
                Logger.getLogger(TambahMenejerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clear() {
        theView.setUsername("");
        theView.setPassword("");
        theView.setAlamat("");
        theView.setIdAkun("");
        theView.setLevel("");
    }

    private class pilih implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = theView.getSelectedRow();
            if (baris != -1) {

                String id = theView.getValueAt(baris, 0);
                String username = theView.getValueAt(baris, 1);
                String password = theView.getValueAt(baris, 2);
                String level = theView.getValueAt(baris, 3);
                String alamat = theView.getValueAt(baris, 4);

                theView.setUsername(username);
                theView.setPassword(password);
                theView.setIdAkun(id);
                theView.setAlamat(alamat);
                theView.setLevel(level);

                theView.btnEdit(true);
                theView.btnTambah(false);
            }
        }

    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HomeManagerView m = new HomeManagerView();
            theView.dispose();
            m.setVisible(true);
            ManajerModel theModel = new ManajerModel();
            ManagerController theController = new ManagerController(theModel, m);
        }

    }

}
