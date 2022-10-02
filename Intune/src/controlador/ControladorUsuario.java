
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmUsuarios;


public class ControladorUsuario implements ActionListener{
    FrmUsuarios vUs = new FrmUsuarios();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO(); 

    public ControladorUsuario(FrmUsuarios vUs, UsuarioVO uvo, UsuarioDAO udao) {
        this.vUs = vUs;
        this.uvo = uvo;
        this.udao = udao;
        
        vUs.btnIngresarU.addActionListener(this);
        vUs.btnActualizarU.addActionListener(this);
        vUs.btnEliminarU.addActionListener(this);       
        vUs.btnSalirU.addActionListener(this);
        
    }
    
    private void ingresarUsuario(){
        uvo.setNombreUsuario(vUs.txtNombreU.getText());
        uvo.setApellidoUsuario(vUs.txtApellidoU.getText());
        uvo.setCodigoUsuario(vUs.txtUsuarioU.getText());
        uvo.setClaveUsuario(vUs.txtPasswordU.getText());
        uvo.setIdTipoUsuario(Integer.parseInt(this.vUs.txtTipoU.getText()));
        uvo.setEstadoUsuario(Integer.parseInt(this.vUs.txtEstadoU.getText()));       
        udao.insertarUsuario(uvo);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vUs.btnIngresarU){
            this.ingresarUsuario();
        }
        if(e.getSource() == vUs.btnSalirU)
            vUs.dispose();
    }
   
    
    
}
