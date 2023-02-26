/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import login.FormLogin;

/**
 *
 * @author RIZKY
 */
public class RentalApp {
    
    public static void main(String[] args) {
        try {
            FormLogin form = new FormLogin();
            form.setVisible(true);
        } catch (Exception e) {
        }
    }
}
