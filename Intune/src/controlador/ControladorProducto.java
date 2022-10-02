 
package controlador;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoDAO;
import modelo.ProductoVO; 
import vista.FrmProductos;

public class ControladorProducto implements ActionListener, MouseListener {
    FrmProductos vProd = new FrmProductos();
    ProductoDAO pDAO = new ProductoDAO();
    ProductoVO pVO = new ProductoVO();
    
    public ControladorProducto(FrmProductos vProd, ProductoDAO pDAO, ProductoVO pVO){
        this.vProd = vProd;
        this.pDAO = pDAO;
        this.pVO = pVO;
        this.vProd.btnIngresarP.addActionListener(this);
        this.vProd.btnActualizarP.addActionListener(this);
        this.vProd.btnEliminarP.addActionListener(this);
        this.vProd.tblProductos.addMouseListener(this);
        LlenarTabla(vProd.tblProductos);
    }
    
    public void LlenarTabla(JTable tablaDatos){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDatos.setModel(modeloTabla);
        modeloTabla.addColumn("idProducto");
        modeloTabla.addColumn("Descripcio");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estado");
        Object[] columna = new Object[6];
        int numRegistros = pDAO.consultaProducto().size();
        for (int i=0;i<numRegistros;i++){
            columna[0]=pDAO.consultaProducto().get(i).getIdProducto();
            columna[1]=pDAO.consultaProducto().get(i).getIdMarca();
            columna[2]=pDAO.consultaProducto().get(i).getDescripcionProducto();
            columna[3]=pDAO.consultaProducto().get(i).getCantidadProducto();
            columna[4]=pDAO.consultaProducto().get(i).getPrecioProducto();
            columna[5]=pDAO.consultaProducto().get(i).getEstadoProducto();
            modeloTabla.addRow(columna);
        }
    }
    
    public void limpliarRegistro(){ 
        vProd.txtMarcaP.setText("");
        vProd.txtDescripP.setText("");
        vProd.txtCantidadP.setText("");
        vProd.txtPrecioP.setText("");
        vProd.txtEstadoP.setText("");
        vProd.txtMarcaP.requestFocus();
    }
    
    public void insertaRegistro(){
 //       pVO.setIdMarca(vProd.txtMarcaP.getText());
        pVO.setDescripcionProducto(vProd.txtDescripP.getText());
        pVO.setCantidadProducto(Integer.parseInt(vProd.txtCantidadP.getText()));
        pVO.setPrecioProducto(Double.parseDouble(vProd.txtPrecioP.getText()));
        pVO.setEstadoProducto(Integer.parseInt(vProd.txtEstadoP.getText()));
        boolean respuesta = pDAO.insertarProducto(pVO);
        if (respuesta=false){
            JOptionPane.showMessageDialog(null,"Error al Insertar Producto");
            limpliarRegistro();
            LlenarTabla(vProd.tblProductos);
        }
    }
    
    public void modificarRegistro(){
//        pVO.setIdMarca(vProd.txtMarcaP.getText());
        pVO.setDescripcionProducto(vProd.txtDescripP.getText());
        pVO.setCantidadProducto(Integer.parseInt(vProd.txtCantidadP.getText()));
        pVO.setPrecioProducto(Double.parseDouble(vProd.txtPrecioP.getText()));
        pVO.setEstadoProducto(Integer.parseInt(vProd.txtEstadoP.getText()));
        boolean respuesta = pDAO.actualizarProducto(pVO);
        if (respuesta=false){
            JOptionPane.showInputDialog(null,"Error al Modificar Producto");
            limpliarRegistro();
            LlenarTabla(vProd.tblProductos);
        }
    }
    
    public void eliminarRegistro(){
 //       pVO.setIdProducto(Integer.parseInt(vProd.txtIdProducto.getText()));
        boolean respuesta=pDAO.eliminarProducto(pVO);
        if(respuesta=false){
            JOptionPane.showInputDialog(null,"Error al Eliminar Producto");
            limpliarRegistro();
            LlenarTabla(vProd.tblProductos);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
