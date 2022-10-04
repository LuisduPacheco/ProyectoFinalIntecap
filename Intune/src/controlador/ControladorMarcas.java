package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;
import modelo.MarcaDAO;
import modelo.MarcaVO;
import vista.FrmMarcas;

public class ControladorMarcas implements ActionListener, WindowListener, MouseListener{
    MarcaDAO mDAO = new MarcaDAO();
    MarcaVO mVO = new MarcaVO();
    FrmMarcas frmM = new FrmMarcas();
    
    public ControladorMarcas(MarcaDAO marcaDAO,MarcaVO marcaVO, FrmMarcas frmMarcas){
        this.mDAO = marcaDAO;
        this.mVO = marcaVO;
        this.frmM = frmMarcas;
        
        this.frmM.btnIngresarM.addActionListener(this);
        this.frmM.btnEliminarM.addActionListener(this);
        this.frmM.btnIngresarM.addActionListener(this);
        this.frmM.btnSalirM.addActionListener(this);
        this.frmM.addWindowListener(this);
        this.frmM.tblMarcas.addMouseListener(this);
    }
    
    private boolean verificarVacios(){
        boolean vacios = true;
        if((this.frmM.txtNombreM.getText() != "")&&(this.frmM.txtNombreM.getText() != "")){
            vacios = false;
        }
        return vacios;
    }
    
    private void mostrarTablaMarcas(){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnCount(0);
        dtm.addColumn("ID Marca");
        dtm.addColumn("Nombre Marca");
        dtm.addColumn("Estado");
        
        for(MarcaVO mVo: mDAO.consultarMarca()){
            String estado = "";
            if(mVo.getEstadoMarca() == 1){
                estado = "Activo";
            }else{
                estado = "Desactivo";
            }
            dtm.addRow(new Object[]{mVo.getIdMarca(),mVo.getNombreMarca(),estado});
        }
        
        this.frmM.tblMarcas.setModel(dtm);
    }
    
    private void llenarDatos(){
        int row = this.frmM.tblMarcas.getSelectedRow();
        int estado = 0;
        this.frmM.txtNombreM.setText(String.valueOf(this.frmM.tblMarcas.getValueAt(row, 1)));
        if(String.valueOf(this.frmM.tblMarcas.getValueAt(row, 2)) == "Activo"){
            estado = 1;
        }
        this.frmM.txtEstadoM.setText(String.valueOf(estado));
    }
    
    private void verificarExistencia(){
        
    }
    
    public void insertarMarca(){
        if(!verificarVacios()){
            try {
                int estado = Integer.parseInt(this.frmM.txtNombreM.getText());
                        if((estado == 1)||(estado == 2)){
                            this.mVO.setNombreMarca(this.frmM.txtNombreM.getText());
                            this.mVO.setEstadoMarca(estado);
                            if(this.mDAO.insertarMarca(mVO)){
                                this.frmM.jopMensajeM.showMessageDialog(frmM, "Se agregaron los datos Correctamente");
                                this.frmM.txtEstadoM.setText("");
                                this.frmM.txtNombreM.setText("");
                            }else{
                                
                            }
                        }else{
                            this.frmM.jopMensajeM.showMessageDialog(frmM, "Para el campo de estado unicamente ingrese 1) Activo o 2) Desactivo");
                        }
            } catch (Exception e) {
                this.frmM.jopMensajeM.showMessageDialog(frmM, "Para el campo de estado ingrese 1) Activo o 2) Desactivo");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.frmM.btnSalirM){
            this.frmM.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
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
        mostrarTablaMarcas();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            llenarDatos();
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
}
