
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    
    //Variables para la conexión
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "intecap-2022.mysql.database.azure.com";
    private String user = "grupo3@intecap-2022.mysql.database.azure.com";
    private String pass = "grupo32022.";
    private String database = "dbintune";
    private String cadena;
    
    Connection connection;
    Statement statement;

    //MÉTODO PARA CONECTAR
    public void conectar(){
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.database;
        try {
            Class.forName(this.driver).newInstance(); 
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
            System.err.println("Error[MCon]: " + e.getMessage());
        }
    }
    
    //METODO PARA DESCONECTAR
    public void desconectar() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDes]: " + e.getMessage());
        }
    }
    //Metodo para realizar consultas SELECT
    public ResultSet consultaDatos(String consulta) {
        try {
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error [MCDatos]: " + e.getMessage());

        }
        return null;
    }
    //FIN DEL API DE CONEXIÓN
    
}
