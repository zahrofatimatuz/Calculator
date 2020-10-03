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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ItemTransaksi;
import model.Produk;
import model.ProdukModel;
import model.AdminModel;
import model.ManajerModel;
import model.PemesananModel;
import view.HomeAdminView;
import view.HomeManagerView;
import view.PemesananView;

/**
 *
 * @author World
 */
public class PemesananController {

    model.PemesananModel theModel;
    view.PemesananView theView;
    String username;
    ProdukModel pdao;
    ArrayList<Produk> listProduk;

    PemesananController(PemesananModel theModel, PemesananView theView) throws SQLException, ParseException {
        this.theModel = theModel;
        this.theView = theView;
        pdao = new ProdukModel();
        listProduk = pdao.getAllProduk();
        //username = c_login.getUserLogin();
        this.theView.btnKembaliListener(new PemesananController.kembali());
        this.theView.addProdukList(listProduk);
        this.theView.btnTambahListener(new TambahBarangListener());
        this.theView.btnHapusListener(new HapusBarangListener());
        this.theView.btnBayarSaveListener(new SaveListener());
    }

    public void clear() {
        theView.setNamaPemesan("");
        //theView.set("");
    }

    class TambahBarangListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Produk p = listProduk.get(theView.getProdukSelected());
            theView.addItem(p.getNamaProduk(), p.getIdProduk() + "", theView.getJumlah(), p.getHarga());
            theView.plusTotal(theView.getJumlah() * p.getHarga());
        }
    }

    class HapusBarangListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.minTotal(theView.getSelectedQty() * theView.getSelectedHarga());
            theView.hapusItem(theView.getRow());
        }
    }

    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = theView.getModel();
            ArrayList<ItemTransaksi> list = new ArrayList<>();

            for (int i = 0; i < model.getRowCount(); i++) {
                ItemTransaksi item = new ItemTransaksi();
                item.setHarga(Double.parseDouble(model.getValueAt(i, 2).toString()));
                item.setIdProduk(Long.parseLong(model.getValueAt(i, 0).toString()));
                item.setQty((int) Double.parseDouble(model.getValueAt(i, 3).toString()));
                list.add(item);
            }
            try {
                int bayar = Integer.parseInt(theView.getBayar());
                double total = Double.parseDouble(theView.getTotalBiaya());
                double kembalian = bayar - total;
                if (kembalian < 0) {
                    JOptionPane.showMessageDialog(theView, "uang yang Anda bayarkan kurang " + kembalian);
                } else {
                    theView.setKembalian(String.valueOf(kembalian));
                    theModel.saveTransaksi(theView.getNamaPemesan(), list);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HomeAdminView a = new HomeAdminView();
            theView.dispose();
            a.setVisible(true);
            AdminModel theModel = new AdminModel();
            AdminController theController = new AdminController(theModel, a);
        }

    }
}
