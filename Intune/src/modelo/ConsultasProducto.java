
package modelo;

import java.util.ArrayList;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public interface ConsultasProducto {

    /**
     *
     * @param p
     * @return
     */
    public boolean insertarProducto(ProductoVO p);

    /**
     *
     * @return
     */
    public ArrayList<ProductoVO> consultaProducto();

    /**
     *
     * @param p
     * @return
     */
    public boolean actualizarProducto(ProductoVO p);

    /**
     *
     * @param p
     * @return
     */
    public boolean eliminarProducto(ProductoVO p);

    /**
     *
     * @param p
     * @return
     */
    public ProductoVO mostrarProducto(ProductoVO p);
}
