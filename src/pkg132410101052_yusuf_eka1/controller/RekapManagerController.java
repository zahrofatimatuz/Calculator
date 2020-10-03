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
public class RekapManagerController {

    model.RekapManagerModel theModel;
    view.RekapPenjualanManagerView theView;

    RekapManagerController(RekapManagerModel theModel, RekapPenjualanManagerView theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.btnHomeManager(new homeManager());
        theView.setTabel(theModel.getTableModel());

    }

    private class homeManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HomeManagerView hm = new HomeManagerView();
            theView.dispose();
            hm.setVisible(true);
            ManajerModel theModel = new ManajerModel();
            ManagerController theController = new ManagerController(theModel, hm);

        }

    }

}
