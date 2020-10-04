/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_kualitas;
import model.m_user;
import view.PakarKualitas;
import view.homeAdmin;

/**
 *
 * @author Vin
 */
public class c_kualitas {

    private m_kualitas theModel;
    private PakarKualitas theView;

    public c_kualitas(PakarKualitas theView, m_kualitas theModel) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.check(new c_kualitas.check());
        theView.setComboPetani(theModel.getPetani());
        theView.setComboVarietas(theModel.getVarietas());
        theView.setComboMatang(theModel.getMatang());
        theView.setComboBobot(theModel.getBobot());
        theView.setComboCacat(theModel.getCacat());
        this.theView.addCekListener(new HasilPerformed());
        theView.backListener(new backListener());
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
            theView.dispose();
        }

    }

    private class check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                theModel.idpetani((String)theView.getPetani().getSelectedItem());
                theModel.idpetani(m_kualitas.luas);
                theView.setLuas(m_kualitas.luas);
            } catch (SQLException ex) {
                Logger.getLogger(c_kualitas.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }
    }

    private class HasilPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theView.getVarietas().getSelectedIndex() == 0 || theView.getMatang().getSelectedIndex() == 0 || theView.getBobot().getSelectedIndex() == 0 || theView.getCacat().getSelectedIndex() == 0) {
                    theView.Message("Pastikan semua data terisi !");
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//1
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(1);//2
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(1);//3
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//4
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//5
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(1);//6
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(1);//7
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//8
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//9
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//10
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//11
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//12
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//13
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//14
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//15
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//16
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//17
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//18
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(1);//19
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//20
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//21
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//22
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//23
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//24
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//25
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//26
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//27
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//28
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//29
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//30
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//31
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//32
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//33
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//34
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//35
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//36
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//37
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//38
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//39
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//40
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//41
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//42
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//43
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//44
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//45
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//46
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//47
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//48
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//49
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//50
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//51
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//52
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//53
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//54
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//55
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//56
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//57
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//58
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//59
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//60
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//61
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//62
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//63
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 1 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//64
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//1
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(1);//2
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(1);//3
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//4
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//5
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//6
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//7
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//8
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//9
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//10
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//11
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//12
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//13
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//14
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//15
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//16
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//17
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//18
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(1);//19
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//20
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//21
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//22
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//23
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//24
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//25
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//26
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//27
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//28
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//29
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//30
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//31
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//32
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//33
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//34
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//35
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//36
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//37
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//38
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//39
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//40
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//41
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//42
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//43
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//44
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//45
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//46
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//47
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//48
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//49
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//50
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//51
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//52
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//53
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//54
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//55
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//56
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//57
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//58
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//59
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//60
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//61
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//62
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//63
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 2 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//64
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//1
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//2
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//3
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(2);//4
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//5
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//6
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(2);//7
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//8
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//9
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//10
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//11
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//12
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//13
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//14
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//15
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//16
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(1);//17
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//18
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//19
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//20
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//21
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//22
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//23
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//24
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//25
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//26
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//27
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//28
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//29
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//30
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//31
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//32
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//33
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//34
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//35
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//36
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//37
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//38
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//39
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//40
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//41
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//42
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//43
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//44
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//45
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//46
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//47
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//48
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//49
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//50
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//51
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//52
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//53
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//54
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//55
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//56
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//57
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//58
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//59
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//60
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(4);//61
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//62
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//63
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 3 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//64
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//1
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//2
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//3
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//4
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//5
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//6
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//7
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//8
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//9
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//10
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//11
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                     && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//12
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//13
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//14
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//15
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 1
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//16
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//17
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//18
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//19
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//20
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//21
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(2);//22
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//23
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//24
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//25
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//26
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//27
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//28
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//29
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//30
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//31
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 2
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//32
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(2);//33
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//34
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//35
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//36
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//37
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//38
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//39
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//40
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//41
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//42
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//43
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//44
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//45
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//46
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//47
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 3
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//48
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//49
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//50
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(3);//51
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 1 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(3);//52
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(3);//53
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(3);//54
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//55
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 2 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//56
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(4);//57
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//58
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//59
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 3 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//60
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 1) {
                    theModel.Pakar(4);//61
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 2) {
                    theModel.Pakar(4);//62
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 3) {
                    theModel.Pakar(4);//63
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                } else if (theView.getVarietas().getSelectedIndex() == 4 && theView.getMatang().getSelectedIndex() == 4
                        && theView.getBobot().getSelectedIndex() == 4 && theView.getCacat().getSelectedIndex() == 4) {
                    theModel.Pakar(4);//64
                    theView.setMutu(theModel.getStatus().toString());
                    theView.setTindakan(theModel.getTindakan().toString());
                }
            } catch (Exception ex) {
                Logger.getLogger(c_kualitas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
