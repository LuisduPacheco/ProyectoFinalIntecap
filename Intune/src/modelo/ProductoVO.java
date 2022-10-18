
package modelo;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public class ProductoVO {
    private int idProducto;
    private String descripcionProducto;
    private int cantidadProducto;
    private double precioProducto;
    private int estadoProducto;
    private int idMarca;

    /**
     *
     */
    public ProductoVO() {
    }

    /**
     *
     * @return
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     *
     * @param idProducto
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     *
     * @return
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     *
     * @param descripcionProducto
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     *
     * @return
     */
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    /**
     *
     * @param cantidadProducto
     */
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    /**
     *
     * @return
     */
    public double getPrecioProducto() {
        return precioProducto;
    }

    /**
     *
     * @param precioProducto
     */
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    /**
     *
     * @return
     */
    public int getEstadoProducto() {
        return estadoProducto;
    }

    /**
     *
     * @param estadoProducto
     */
    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    /**
     *
     * @return
     */
    public int getIdMarca() {
        return idMarca;
    }

    /**
     *
     * @param idMarca
     */
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
}
