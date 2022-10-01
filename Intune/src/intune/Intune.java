package intune;

import conexion.Conector;
import controlador.ControlMenu;
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
        
        
        
        //CONTROLADORES
        ControlMenu cMnup = new ControlMenu(vUsua, vProd, vMarc, vMnup);
        //PROPIEDADES DE LAS VENTANAS
        vMnup.setLocationRelativeTo(null);
        vMnup.setVisible(true);
        
        
        
        
    }
}
