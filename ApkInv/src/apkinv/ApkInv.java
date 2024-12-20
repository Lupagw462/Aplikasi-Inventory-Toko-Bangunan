/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apkinv;
import Login.login;
/**
 *
 * @author Yuki
 */
public class ApkInv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login.login().setVisible(true); // Menampilkan form login
            }
        });
    }
    
}
