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
import javax.swing.JOptionPane;
import model.AdminModel;
import model.LoginModel;
import model.ManajerModel;
import view.HomeAdminView;
import view.LoginView;
import view.HomeManagerView;

/**
 *
 * @author World
 */
public class LoginController {

    private model.LoginModel theModel;
    private view.LoginView theView;
    private static String username;

    public LoginController(LoginModel theModel, LoginView theView) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;

        theView.setVisible(true);
        theView.loginListener(new loginListener());
    }

    public static void setUserLogin(String username) {
        LoginController.username = username;
    }

    public static String getUserLogin() {
        return username;
    }

    private class loginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int result = theModel.login(theView.getTxtUsername(), theView.getPassword());

                if (result == 1) {
                    int level = theModel.lvlLogin(theView.getTxtUsername(), theView.getPassword());

                    if (level == 2) {
                        //JOptionPane.showMessageDialog(viewLogin, "Halo " + username + " !");
                        HomeManagerView m = new HomeManagerView();
                        theView.dispose();
                        m.setVisible(true);
                        ManajerModel modelManajer = new ManajerModel();
                        ManagerController controlManajer = new ManagerController(modelManajer, m);

                    } else if (level == 1) {
                        //JOptionPane.showMessageDialog(viewLogin, "Halo " + username + " !");
                        HomeAdminView admin = new HomeAdminView();
                        theView.dispose();
                        admin.setVisible(true);
                        AdminModel modeladmin = new AdminModel();
                        AdminController controller = new AdminController(modeladmin, admin);
                    }

                } else if ((theView.getTxtUsername().equalsIgnoreCase("") || theView.getPassword().equalsIgnoreCase(""))) {
                    JOptionPane.showMessageDialog(theView, "Username dan Password tidak Boleh Kosong");
                } else {
                    JOptionPane.showMessageDialog(theView, "USERNAME ATAU PASSWORD ANDA SALAH !");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(theView, "Koneksi time out!");
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
