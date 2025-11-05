package restaurante;

import Formulario.Login;

public class MainPrincipal {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
