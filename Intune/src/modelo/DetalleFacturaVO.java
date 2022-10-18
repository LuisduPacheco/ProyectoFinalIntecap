
package modelo;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public class DetalleFacturaVO {
    private int idDetalleFactura;
    private int cantidadProducto;
    private double precioProductoUnitario;
    private double precioTotalProducto;
    private int idProducto;
    private int idFactura;

    /**
     *
     */
    public DetalleFacturaVO() {
    }

    /**
     *
     * @return
     */
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    /**
     *
     * @param idDetalleFactura
     */
    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
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
    public double getPrecioProductoUnitario() {
        return precioProductoUnitario;
    }

    /**
     *
     * @param precioProductoUnitario
     */
    public void setPrecioProductoUnitario(double precioProductoUnitario) {
        this.precioProductoUnitario = precioProductoUnitario;
    }

    /**
     *
     * @return
     */
    public double getPrecioTotalProducto() {
        return precioTotalProducto;
    }

    /**
     *
     * @param precioTotalProducto
     */
    public void setPrecioTotalProducto(double precioTotalProducto) {
        this.precioTotalProducto = precioTotalProducto;
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
    public int getIdFactura() {
        return idFactura;
    }

    /**
     *
     * @param idFactura
     */
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

}
