 
package Conexion; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.nio.file.Path;
import java.nio.file.Paths;
public class CreateConection {
    static Properties config = new Properties();
    String hostname = null;
    String port = null;
    String database = null;
    String username = null;
    String password = null;
    public CreateConection (){
        String path = "C:\\Users\\danny\\OneDrive\\Documentos\\NetBeansProjects\\Restaurante\\src\\Conexion\\DBConfig.properties";
        InputStream in = null;
        try {
            in = Files.newInputStream(Paths.get(path));
            config.load(in);
            in.close();
            }   catch (IOException ex) {
                        ex.printStackTrace();
            }   finally{
                    try{
                            in.close();
                        }catch (IOException ex ) {
                                ex.printStackTrace();
                                 }
                }
                
        loadProperties();
        
    }
    public void loadProperties(){
                hostname = config.getProperty("hostname");
                port  = config.getProperty("port");
                database = config.getProperty("database");
                username =   config.getProperty("username");
                password =   config.getProperty("password");
        }
    
    public Connection getConection() throws SQLException{
    Connection conn = null;
    
    String jdbcUrl = "jdbc:postgresql://"+this.hostname+":"+
            this.port + "/" + this.database;
    
    conn = DriverManager.getConnection(jdbcUrl,username,password);
    System.out.println("Conexion establecida");
    
    return conn;
    }
 
    
    
}

