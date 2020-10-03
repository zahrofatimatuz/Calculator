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
import model.*;
import view.*;

/**
 *
 * @author World
 */
public class OutletController {

    model.OutletModel theModel;
    view.TambahOutletView theView;
    OutletModel om;
    ArrayList<Outlet> listOutlet;

    OutletController(OutletModel theModel, TambahOutletView theView) throws SQLException, ParseException {
        this.theModel = theModel;
        this.theView = theView;
        om = new OutletModel();
        listOutlet = om.getAllAdmin();
        this.theView.btnKembali(new OutletController.kembali());
        
//        this.theView.addAdminList(listOutlet);

    }

    private class kembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HomeManagerView a = new HomeManagerView();
            theView.dispose();
            a.setVisible(true);
            ManajerModel theModel = new ManajerModel();
            ManagerController theController = new ManagerController(theModel, a);
        }

    }
}
