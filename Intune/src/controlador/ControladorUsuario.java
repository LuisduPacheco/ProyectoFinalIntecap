package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.TipoUsuairoDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmUsuarios;

/**
 *
 * @author peace
 */
public class ControladorUsuario implements ActionListener, MouseListener, WindowListener, ItemListener {

    FrmUsuarios vUsua = new FrmUsuarios();
    UsuarioVO uVo = new UsuarioVO();
    TipoUsuarioVO tUvO = new TipoUsuarioVO();
    UsuarioDAO uDao = new UsuarioDAO();
    TipoUsuairoDAO tUdAo = new TipoUsuairoDAO();

    /**
     *
     * @param vUsua
     * @param uVo
     * @param uDao
     * @param tUvO
     * @param tUdAo
     */
    public ControladorUsuario(FrmUsuarios vUsua, UsuarioVO uVo, UsuarioDAO uDao, TipoUsuarioVO tUvO, TipoUsuairoDAO tUdAo) {
        this.vUsua = vUsua;
        this.uVo = uVo;
        this.tUvO = tUvO;
        this.uDao = uDao;
        this.tUdAo = tUdAo;
        this.vUsua.btnIngresarU.addActionListener(this);
        this.vUsua.btnActualizarU.addActionListener(this);
        this.vUsua.btnSalirU.addActionListener(this);
        this.vUsua.tblUsuarios.addMouseListener(this);
        this.vUsua.btnLimpiarU.addActionListener(this);
        this.vUsua.cbxTipoUsuario.addItemListener(this);
        this.vUsua.addWindowListener(this);
        llenarTipoUsuario();
    }

    //este metodo muestra los datos de la tabla

    /**
     *
     * @param tblUsuarios
     */
    public void mostTabUsuarios(JTable tblUsuarios) {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id usuario");
        m.addColumn("Nombre Usuario");
        m.addColumn("Apellido Usuario");
        m.addColumn("Códico Usuario");
        m.addColumn("Clave Usuario");
        m.addColumn("Id Tipo Usuario");
        m.addColumn("Estado Usuario");

        for (UsuarioVO uVo : uDao.consultarUsuario()) {
            m.addRow(new Object[]{uVo.getIdUsuario(), uVo.getNombreUsuario(),
                uVo.getApellidoUsuario(), uVo.getCodigoUsuario(), uVo.getClaveUsuario(),
                uVo.getIdTipoUsuario(), uVo.getEstadoUsuario()
            });
        }
        vUsua.tblUsuarios.setModel(m);
        //asignar medidas columnas si me da tiempo
    }

    private void ingresarUsuario() {
        int estado = Integer.parseInt(this.vUsua.txtEstadoU.getText());
        if ((estado == 0) || (estado == 1)) {
            uVo.setNombreUsuario(vUsua.txtNombreU.getText());
            uVo.setApellidoUsuario(vUsua.txtApellidoU.getText());
            uVo.setCodigoUsuario(vUsua.txtUsuarioU.getText());
            uVo.setClaveUsuario(vUsua.txtPasswordU.getText());
            uVo.setIdTipoUsuario(Integer.parseInt(this.vUsua.txtTipoU.getText()));
            uVo.setEstadoUsuario(Integer.parseInt(this.vUsua.txtEstadoU.getText()));           

            if (uDao.insertarUsuario(uVo) == true) {
                vUsua.jopMensajeU.showMessageDialog(vUsua, "Usuario ingresado correctamente");
                this.vUsua.txtNombreU.setText("");
                this.vUsua.txtApellidoU.setText("");
                this.vUsua.txtUsuarioU.setText("");
                this.vUsua.txtPasswordU.setText("");
                this.vUsua.txtTipoU.setText("");
                this.vUsua.txtEstadoU.setText("");                
                mostTabUsuarios(vUsua.tblUsuarios);
            } else {
                vUsua.jopMensajeU.showMessageDialog(vUsua, "No se realizó porque el usuario ya existe");
                this.vUsua.txtNombreU.setText("");
                this.vUsua.txtApellidoU.setText("");
                this.vUsua.txtUsuarioU.setText("");
                this.vUsua.txtPasswordU.setText("");
                this.vUsua.txtTipoU.setText("");
                this.vUsua.txtEstadoU.setText("");
            }
        }else{
         vUsua.jopMensajeU.showMessageDialog(vUsua, "0 para usuario inactivo y 1 para usuario activo");
        }
    }

    private void limpiarPantalla() {
        this.vUsua.txtIdUsuario.setText("");
        this.vUsua.txtNombreU.setText("");
        this.vUsua.txtApellidoU.setText("");
        this.vUsua.txtUsuarioU.setText("");
        this.vUsua.txtPasswordU.setText("");
        this.vUsua.txtTipoU.setText("");
        this.vUsua.txtEstadoU.setText("");
    }

    private boolean validarUsuarioRepetido() {
        for (UsuarioVO uVo : uDao.consultarUsuario()) {
            if (uVo.getCodigoUsuario().equals(vUsua.txtUsuarioU.getText())) {
                System.out.println("Se encontró usuario " + uVo.getCodigoUsuario());
                return true;
            }
        }

        return false;
    }

    private void actualizaListaUsuario() {
        int estado = Integer.parseInt(this.vUsua.txtEstadoU.getText());
        if ((estado == 0) || (estado == 1)){
         uVo.setIdUsuario(Integer.parseInt(vUsua.txtIdUsuario.getText()));
        uVo.setNombreUsuario(vUsua.txtNombreU.getText());
        uVo.setApellidoUsuario(vUsua.txtApellidoU.getText());
        uVo.setCodigoUsuario(vUsua.txtUsuarioU.getText());
        uVo.setClaveUsuario(vUsua.txtPasswordU.getText());
        uVo.setIdTipoUsuario(Integer.parseInt(vUsua.txtTipoU.getText()));
        uVo.setEstadoUsuario(Integer.parseInt(vUsua.txtEstadoU.getText()));

        boolean mensActulizar = uDao.actualizarUsuario(uVo);
        if (mensActulizar = true) {
            vUsua.jopMensajeU.showMessageDialog(vUsua, "Usuario actulizado exitosamente");
            limpiarPantalla();
            mostTabUsuarios(vUsua.tblUsuarios);
        }
        
        }else{
            vUsua.jopMensajeU.showMessageDialog(vUsua, "0 para usuario inactivo y 1 para usuario activo");
        }
        
    }

    private void llenarTipoUsuario() {
        // TipoUsuairoDAO tUdAo = new TipoUsuairoDAO();
        //TipoUsuarioVO  tUvO =new TipoUsuarioVO();

        ArrayList<TipoUsuarioVO> listaTipoUsuarios = tUdAo.consultarTipoUsuario();
        vUsua.cbxTipoUsuario.removeAllItems();
        for (int i = 0; i < listaTipoUsuarios.size(); i++) {
            //vUsua.cbxTipoUsuario.addItem(listaTipoUsuarios.get(i).getDescripcionTipo());
            vUsua.cbxTipoUsuario.addItem(new TipoUsuarioVO(listaTipoUsuarios.get(i).getIdTipoUsuario(), listaTipoUsuarios.get(i).getDescripcionTipo()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vUsua.btnIngresarU) {
            if (!validarUsuarioRepetido()) {
                if (!this.vUsua.txtNombreU.getText().equals("")
                        && !this.vUsua.txtApellidoU.getText().equals("")
                        && !this.vUsua.txtUsuarioU.getText().equals("")
                        && !this.vUsua.txtPasswordU.getText().equals("")
                        && !this.vUsua.txtTipoU.getText().equals("")
                        && !this.vUsua.txtEstadoU.getText().equals("")) {
                    this.ingresarUsuario();
                } else {
                    this.vUsua.jopMensajeU.showMessageDialog(vUsua, "Debe llenar todos los campos");
                }
            } else {
                this.vUsua.jopMensajeU.showMessageDialog(vUsua, "El usuario ya existe, ingrese otro");
            }

        }

        if (e.getSource() == vUsua.btnActualizarU) {
            if (!this.vUsua.txtNombreU.getText().equals("")
                    && !this.vUsua.txtApellidoU.getText().equals("")
                    && !this.vUsua.txtUsuarioU.getText().equals("")
                    && !this.vUsua.txtPasswordU.getText().equals("")
                    && !this.vUsua.txtTipoU.getText().equals("")
                    && !this.vUsua.txtEstadoU.getText().equals("")) {
                this.actualizaListaUsuario();

            } else {
                this.vUsua.jopMensajeU.showMessageDialog(vUsua, "No hay datos para acuarlizar");
            }

            mostTabUsuarios(vUsua.tblUsuarios);
        }

        if (e.getSource() == vUsua.btnLimpiarU) {
            limpiarPantalla();
        }

        if (e.getSource() == vUsua.btnSalirU) {
            vUsua.dispose();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //este metodo llena los campos de la ventana para mostrarle al usuario donde esta realiza alguna accion
        if (e.getSource() == vUsua.tblUsuarios) {
            vUsua.txtIdUsuario.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 0).toString());
            vUsua.txtNombreU.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 1).toString());
            vUsua.txtApellidoU.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 2).toString());
            vUsua.txtUsuarioU.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 3).toString());
            vUsua.txtPasswordU.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 4).toString());
            vUsua.txtTipoU.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 5).toString());
            vUsua.txtEstadoU.setText(vUsua.tblUsuarios.getValueAt(vUsua.tblUsuarios.getSelectedRow(), 6).toString());

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
        mostTabUsuarios(vUsua.tblUsuarios);
        vUsua.txtTipoU.setEditable(false);
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
        vUsua.txtTipoU.setEditable(false);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int id = this.vUsua.cbxTipoUsuario.getItemAt(vUsua.cbxTipoUsuario.getSelectedIndex()).getIdTipoUsuario();
            this.vUsua.txtTipoU.setText(String.valueOf(id));
        }
    }

}
