package intune;

import conexion.Conector;
import controlador.ControlLogin;
import controlador.ControlMenu;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmLogin;
import vista.FrmMarcas;
import vista.FrmMenuP;
import vista.FrmProductos;
import vista.FrmUsuarios;

public class Intune {

    public static void main(String[] args) {

        Conector conector = new Conector();
        conector.conectar();
        //VENTANAS
        FrmLogin vLog = new FrmLogin();
        FrmMenuP vMnup = new FrmMenuP();
        FrmUsuarios vUsua = new FrmUsuarios();
        FrmProductos vProd = new FrmProductos();
        FrmMarcas vMarc = new FrmMarcas();
        
        //OBJETOS MODELO
        //OBJETOS DAO
        UsuarioDAO uDao = new UsuarioDAO();
        //TipoUsuarioDAO ZOILA
        //MarcaDAO GERARDO
        //ProductoDAO BALVY
        
        
        //OBJETOS VO
        UsuarioVO uVo = new UsuarioVO();
        //TipoUsuarioVO ZOILA
        //MarcaVO GERARDO
        //ProductoVO BALVY
        
        //CONTROLADORES
        ControlLogin cLog = new ControlLogin(vLog, vMnup, uDao, uVo);
        ControlMenu cMnup = new ControlMenu(vUsua, vProd, vMarc, vMnup);
        //Controlador Usuarios ZOILA
        //Controlador Marcas    GERARDO 
        //Controlador Productos BALVY
        
        
        //PROPIEDADES DE LAS VENTANAS
        vLog.setLocationRelativeTo(null);
        vLog.setVisible(true);
        vLog.setResizable(false);
        
        
        
    }
}
