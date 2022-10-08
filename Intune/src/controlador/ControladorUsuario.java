
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmUsuarios;

public class ControladorUsuario implements ActionListener, MouseListener, WindowListener{
    FrmUsuarios vUs = new FrmUsuarios();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO(); 

    public ControladorUsuario(FrmUsuarios vUs, UsuarioVO uvo, UsuarioDAO udao) {
        this.vUs = vUs;
        this.uvo = uvo;
        this.udao = udao;        
        this.vUs.btnIngresarU.addActionListener(this);
        this.vUs.btnActualizarU.addActionListener(this); 
        this.vUs.btnSalirU.addActionListener(this);   
        this.vUs.tblUsuarios.addMouseListener(this);  
        this.vUs.addWindowListener(this);
        this.listaIdUs();
       
        
        
        }
    //esto es lo que se muestra en la tabla
    public void mostTabUsuarios(JTable tblUsuarios){
    DefaultTableModel m = new DefaultTableModel(); 
    
            
            
     m.setColumnCount(0);
     m.addColumn("Id usuario");
     m.addColumn("Nombre Usuario");
     m.addColumn("Apellido Usuario");
     m.addColumn("Códico Usuario");
     m.addColumn("Clave Usuario");
     m.addColumn("Id Tipo Usuario");
     m.addColumn("Estado Usuario");
    
     for(UsuarioVO uvo : udao.consultarUsuario()){
     m.addRow(new Object []{uvo.getIdUsuario(),uvo.getNombreUsuario(),
     uvo.getApellidoUsuario(), uvo.getCodigoUsuario(), uvo.getClaveUsuario(),
     uvo.getIdTipoUsuario(), uvo.getEstadoUsuario()
     });
     }
     
          
    vUs.tblUsuarios.setModel(m);   
    //asignar medidas columnas
   
    
    }
         
    private void ingresarUsuario(){
        uvo.setNombreUsuario(vUs.txtNombreU.getText());
        uvo.setApellidoUsuario(vUs.txtApellidoU.getText());
        uvo.setCodigoUsuario(vUs.txtUsuarioU.getText());
        uvo.setClaveUsuario(vUs.txtPasswordU.getText());
        uvo.setIdTipoUsuario(Integer.parseInt(this.vUs.txtTipoU.getText()));
        uvo.setEstadoUsuario(Integer.parseInt(this.vUs.txtEstadoU.getText()));       
     //limpiar ventana
        if(udao.insertarUsuario(uvo) == true){
        vUs.jopMensajeU.showMessageDialog(vUs, "Usuario ingresado correctamente");
        this.vUs.txtNombreU.setText("");
        this.vUs.txtApellidoU.setText("");
        this.vUs.txtUsuarioU.setText("");
        this.vUs.txtPasswordU.setText("");
        this.vUs.txtTipoU.setText("");
        this.vUs.txtEstadoU.setText(""); 
        }else{
        vUs.jopMensajeU.showMessageDialog(vUs, "No se ha registrado usuario");
        this.vUs.txtNombreU.setText("");
        this.vUs.txtApellidoU.setText("");
        this.vUs.txtUsuarioU.setText("");
        this.vUs.txtPasswordU.setText("");
        this.vUs.txtTipoU.setText("");
        this.vUs.txtEstadoU.setText("");
        }
    }
    
    public void limpiarPantalla(){
    vUs.txtIdUsuario.setText("");
    vUs.txtNombreU.setText("");
    vUs.txtApellidoU.setText("");
    vUs.txtUsuarioU.setText("");
    vUs.txtPasswordU.setText("");
    vUs.txtEstadoU.setText("");
    vUs.txtTipoU.setText("");
    vUs.txtNombreU.requestFocus();
    }
    
    public void actulizarUsuario(){
    uvo.setIdTipoUsuario(Integer.parseInt(vUs.txtIdUsuario.getText()));
    uvo.setNombreUsuario(vUs.txtNombreU.getText());
    uvo.setApellidoUsuario(vUs.txtApellidoU.getText());
    uvo.setCodigoUsuario(vUs.txtUsuarioU.getText());
    uvo.setClaveUsuario(vUs.txtPasswordU.getText());
    uvo.setEstadoUsuario(Integer.parseInt(vUs.txtEstadoU.getText()));
    uvo.setIdTipoUsuario(Integer.parseInt(vUs.txtTipoU.getText())); //consultar este
    
    boolean respuestaActualizar = udao.actualizarUsuario(uvo);
    if(respuestaActualizar = false){
    vUs.jopMensajeU.showMessageDialog(vUs, "No se ha actualizado usuario");
    limpiarPantalla();
    mostTabUsuarios(vUs.tblUsuarios);
    }
    
    }
    
    private void listaIdUs() {
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vUs.btnIngresarU){
            if(!this.vUs.txtNombreU.getText().equals("")&&
               !this.vUs.txtApellidoU.getText().equals("")&&
               !this.vUs.txtUsuarioU.getText().equals("")&&
               !this.vUs.txtPasswordU.getText().equals("")&&
               !this.vUs.txtTipoU.getText().equals("")&&
               !this.vUs.txtEstadoU.getText().equals("")) {
            this.ingresarUsuario();            
            }else{
            this.vUs.jopMensajeU.showMessageDialog(vUs, "Debe llenar todos los campos");
            }
            
        }
        
       if(e.getSource() ==vUs.btnActualizarU){       
            if(!this.vUs.txtNombreU.getText().equals("")&&
               !this.vUs.txtApellidoU.getText().equals("")&&
               !this.vUs.txtUsuarioU.getText().equals("")&&
               !this.vUs.txtPasswordU.getText().equals("")&&
               !this.vUs.txtTipoU.getText().equals("")&&
               !this.vUs.txtEstadoU.getText().equals("")) {  
                actulizarUsuario();
                limpiarPantalla();
                mostTabUsuarios(vUs.tblUsuarios);
            }else{
            this.vUs.jopMensajeU.showMessageDialog(vUs, "Para actualizar debe ingresar datos");
            }       
       }   
       
      // if(e.getSource() == vUs.btnLimpiar){ aqui el boton limpiar}
        
        if(e.getSource() == vUs.btnSalirU){
        vUs.dispose();
        }
        
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        //este metodo llena los campos de la ventana para mostrarle al usuario donde esta realiza alguna accion
       if(e.getSource() ==vUs.tblUsuarios){
       vUs.txtIdUsuario.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 0).toString());
       vUs.txtNombreU.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 1).toString());
       vUs.txtApellidoU.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 2).toString());
       vUs.txtUsuarioU.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 3).toString());
       vUs.txtPasswordU.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 4).toString());
       vUs.txtEstadoU.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 5).toString());
       vUs.txtTipoU.setText(vUs.tblUsuarios.getValueAt(vUs.tblUsuarios.getSelectedRow(), 6).toString());      
       
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }   

    @Override
    public void windowOpened(WindowEvent e) {
         mostTabUsuarios(vUs.tblUsuarios);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
    
}
