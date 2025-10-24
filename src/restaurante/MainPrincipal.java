package restaurante;

import Conexion.CreateConection;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MainPrincipal extends javax.swing.JFrame {

    private String usuario;
    private String rol;
    private Connection con;

    // 🔹 Constructor vacío (NetBeans lo necesita)
    public MainPrincipal() {
        initComponents();
        setTitle("Sistema Restaurante");
        conectar();
    }

    // 🔹 Constructor con parámetros (usado por el login)
    public MainPrincipal(String usuario, String rol) {
        initComponents();
        this.usuario = usuario;
        this.rol = rol;
        setTitle("Sistema Restaurante - Usuario: " + usuario + " (" + rol + ")");
        conectar();
        configurarPermisos();
    }

    // 🔹 Método para conectar a PostgreSQL
    private void conectar() {
        try {
            CreateConection conexionPostgres = new CreateConection();
            con = conexionPostgres.getConection();
            System.out.println("Conectado correctamente a la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 🔹 Configura los permisos según el rol
    private void configurarPermisos() {
        switch (rol.toLowerCase()) {
            case "administrador":
                // Acceso total
                break;
            case "cajero":
                menuEmpleados.setEnabled(false);
                menuUsuarios.setEnabled(false);
                break;
            case "mesero":
                menuEmpleados.setEnabled(false);
                menuUsuarios.setEnabled(false);
                menuReportes.setEnabled(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Rol no reconocido: " + rol);
        }
    }

    // 🔹 Interfaz gráfica (simplificada)
    @SuppressWarnings("unchecked")
    private void initComponents() {

        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();

        menuEmpleados = new javax.swing.JMenu("Empleados");
        menuUsuarios = new javax.swing.JMenu("Usuarios");
        menuProductos = new javax.swing.JMenu("Productos");
        menuProveedores = new javax.swing.JMenu("Proveedores");
        menuClientes = new javax.swing.JMenu("Clientes");
        menuFacturacion = new javax.swing.JMenu("Facturación");
        menuReportes = new javax.swing.JMenu("Reportes");

        menuBar.add(menuEmpleados);
        menuBar.add(menuUsuarios);
        menuBar.add(menuProductos);
        menuBar.add(menuProveedores);
        menuBar.add(menuClientes);
        menuBar.add(menuFacturacion);
        menuBar.add(menuReportes);

        setJMenuBar(menuBar);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    // 🔹 Variables de los menús
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuProveedores;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuFacturacion;
    private javax.swing.JMenu menuReportes;

    // 🔹 Método principal solo para pruebas (opcional)
    public static void main(String[] args) {
        new MainPrincipal("admin", "administrador").setVisible(true);
    }
}
