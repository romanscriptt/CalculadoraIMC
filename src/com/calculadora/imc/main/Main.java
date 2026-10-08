package com.calculadoraimc.imc.main;

import com.calculadoraimc.imc.controller.IMCController;
import com.calculadoraimc.imc.view.VentanaIMC;

/**
 *
 * @author alvarolopez
 */

public class App {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            VentanaIMC vista = new VentanaIMC();
            new IMCController(vista);
            vista.setVisible(true);
        });
    }
}
