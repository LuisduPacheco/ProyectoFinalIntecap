package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;
import modelo.MarcaDAO;
import modelo.MarcaVO;
import vista.FrmMarcas;

public class ControladorMarcas implements ActionListener{
    MarcaDAO marcaDAO = new MarcaDAO();
    MarcaVO marcaVO = new MarcaVO();
    FrmMarcas frmMarcas = new FrmMarcas();
    
    public ControladorMarcas(MarcaDAO marcaDAO,MarcaVO marcaVO, FrmMarcas frmMarcas){
        this.marcaDAO = marcaDAO;
        this.marcaVO = marcaVO;
        this.frmMarcas = frmMarcas;
        
        this.frmMarcas.btnIngresarM.addActionListener(this);
    }
    
    private void verificarVacios(){
        
    }
    
    private void mostrarTablaMarcas(){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnCount(0);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
