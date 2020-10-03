/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.*;

/**
 *
 * @author World
 */
public class TambahOutletController {

    model.TambahOutletModel theModel;
    view.TambahOutletView theView;
    ArrayList<Outlet> adminOutlet;

    public TambahOutletController(TambahOutletModel theModel, TambahOutletView theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;

        theView.btnEdit(false);
        theView.btnEditListener(new edit());
//        this.theView.addAdminList(adminOutlet);

        theView.btnPilihListener(new TambahOutletController.pilih());
        theView.btnKembali(new TambahOutletController.kembali());
        theView.btnTambahOutlet(new TambahOutletController.tambah());
        theView.setTabel(theModel.getTableModel());
        theView.btnTambah(true);

    }

    private class tambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println(theView.getNamaOutlet());
                System.out.println(theView.getAlamatOutlet());
                System.out.println(theView.getAdminOutlet());

                //       System.out.println(theView.getIdAkun());
                theModel.save("default , '" + theView.getNamaOutlet() + "','" + theView.getAlamatOutlet() + "','"+theView.getAdminOutlet()+"'" + "");
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
                String id = theView.getIdOutlet();
                String idAkun = theView.getIdAkun();
                String namaOutlet = theView.getNamaOutlet();
                String alamatOutlet = theView.getAlamatOutlet();
                System.out.println(id+"\n"+idAkun+"\n"+namaOutlet+"\n"+alamatOutlet);
//                String adminOutlet = theView.getAdminOutlet();
//                String admin = theView.getListAdmin();
                theModel.update("id_outlet = '" + id + "',id_akun = '" + idAkun + "',nama_outlet = '" + namaOutlet + "',alamat_outlet = '"+alamatOutlet+"' where id_outlet = " + id);
//                System.out.println(theModel.up);
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
        theView.setNamaOutlet("");
        theView.setAlamatOutlet("");
    }

    private class pilih implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = theView.getSelectedRow();
            if (baris != -1) {

                String id = theView.getValueAt(baris, 0);
                String namaOutlet = theView.getValueAt(baris, 2);
                String alamatOutlet = theView.getValueAt(baris, 3);
                String admin = theView.getValueAt(baris, 1);

                theView.setNamaOutlet(namaOutlet);
                theView.setAlamatOutlet(alamatOutlet);
                theView.setAdminOutlet(admin);
                theView.setIdOutlet(id);

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
