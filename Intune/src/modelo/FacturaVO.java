
package modelo;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public class FacturaVO {
    private int idFactura;
    private String serieFactura;
    private int numeroFactura;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String nit;
    private String email;
    private int totalCantidad;
    private double totalFactura;
    private int estadoFactura;

    /**
     *
     */
    public FacturaVO() {
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

    /**
     *
     * @return
     */
    public String getSerieFactura() {
        return serieFactura;
    }

    /**
     *
     * @param serieFactura
     */
    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    /**
     *
     * @return
     */
    public int getNumeroFactura() {
        return numeroFactura;
    }

    /**
     *
     * @param numeroFactura
     */
    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    /**
     *
     * @return
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     *
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     *
     * @return
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     *
     * @param apellidoCliente
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    /**
     *
     * @return
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     *
     * @param direccionCliente
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**
     *
     * @return
     */
    public String getNit() {
        return nit;
    }

    /**
     *
     * @param nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getTotalCantidad() {
        return totalCantidad;
    }

    /**
     *
     * @param totalCantidad
     */
    public void setTotalCantidad(int totalCantidad) {
        this.totalCantidad = totalCantidad;
    }

    /**
     *
     * @return
     */
    public double getTotalFactura() {
        return totalFactura;
    }

    /**
     *
     * @param totalFactura
     */
    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    /**
     *
     * @return
     */
    public int getEstadoFactura() {
        return estadoFactura;
    }

    /**
     *
     * @param estadoFactura
     */
    public void setEstadoFactura(int estadoFactura) {
        this.estadoFactura = estadoFactura;
    }
    
    
}
