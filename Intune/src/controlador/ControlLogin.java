package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmLogin;
import vista.FrmMenuP;

public class ControlLogin implements ActionListener {

    FrmLogin vLog = new FrmLogin();
    FrmMenuP vMnup = new FrmMenuP();
    UsuarioDAO uDao = new UsuarioDAO();
    UsuarioVO uVo = new UsuarioVO();

    public ControlLogin(FrmLogin vLog, FrmMenuP vMnup, UsuarioDAO uDao, UsuarioVO uVo) {
        this.vLog = vLog;
        this.vMnup = vMnup;
        this.uDao = uDao;
        this.uVo = uVo;

        this.vLog.btnIngresar.addActionListener(this);
        this.vLog.btnSalir.addActionListener(this);
    }

    //METODO PARA VALIDAR LAS CREDENCIALES
    public boolean validarLogin() {
        //VARIABLE PARA EL RETORNO E INDICAR QUE SÍ ENCONTRÓ DATOS EN LA BD
        boolean validar = false;
        
        if (!vLog.txtUsuario.getText().equals("") && !String.valueOf(vLog.txtPassword.getPassword()).equals("")) {
            //FOR EACH para buscar usuarios registrados en BD
            for (UsuarioVO uvo : uDao.consultarUsuario()) {
                if (vLog.txtUsuario.getText().equals(uvo.getCodigoUsuario())
                        && String.valueOf(vLog.txtPassword.getPassword()).equals(uvo.getClaveUsuario())) {
                        System.out.println("Se encontraron datos");
                        validar = true;
                }else{
                    System.out.println("No se encontraron datos");                    
                }                 
            }
            System.out.println("Todo bien, Campos llenos");
        } else {
            System.out.println("Llenar todos los campos");
        }
        return validar;
    }
    //MÉTODO PARA ABRIR EL MENU
    public void abrirMenuPrincipal(){
        if(this.validarLogin() == true){
            this.vMnup.setVisible(true);
            this.vMnup.setResizable(false);
            this.vMnup.setLocationRelativeTo(vLog);
        }else{
            vLog.jopMensajeLog.showMessageDialog(vMnup, "No se encontraron datos");
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vLog.btnIngresar) {
            this.validarLogin();
            this.abrirMenuPrincipal();
        }
        if (e.getSource() == vLog.btnSalir) {

        }
    }

}