/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import model.AdminModel;
//import model.DBConnection;
//import model.ManagerModel;
//import view.LoginView;
//import view.TambahAdminView;

import java.sql.SQLException;
import controller.LoginController;
import view.LoginView;
import model.LoginModel;

/**
 *
 * @author World
 */
public class main {

    public static void main(String[] args) throws SQLException {
        //new UserController(new LoginView(), new AdminModel(), new ManagerModel(), new TambahAdminView());
//    DBConnection db = new DBConnection();
//    db.connect();


                view.LoginView view = new LoginView();
        model.LoginModel model = new LoginModel();
        controller.LoginController control = new LoginController(model, view);
        }
    }

