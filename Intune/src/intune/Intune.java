package intune;

import conexion.Conector;
import controlador.ControlLogin;
import controlador.ControlMenu;
import controlador.ControladorUsuario;
import modelo.TipoUsuarioVO;
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
        //TipoUsuarioDAO tUdAo = new TipoUsuarioDAO();
        //MarcaDAO GERARDO
        //ProductoDAO BALVY
        
        
        //OBJETOS VO
        UsuarioVO uVo = new UsuarioVO();
        TipoUsuarioVO tUvO = new TipoUsuarioVO();
        //MarcaVO GERARDO
        //ProductoVO BALVY
        
        //CONTROLADORES
        ControlLogin cLog = new ControlLogin(vLog, vMnup, uDao, uVo);
        ControlMenu cMnup = new ControlMenu(vUsua, vProd, vMarc, vMnup);
        ControladorUsuario cUsua = new ControladorUsuario(vUsua, uVo, uDao);
        //Controlador Marcas    GERARDO 
        //Controlador Productos BALVY
        
        
        //PROPIEDADES DE LAS VENTANAS
        vLog.setLocationRelativeTo(null);
        vLog.setVisible(true);
        vLog.setResizable(false);
        
        
        
    }
}
