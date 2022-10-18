
package modelo;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public class UsuarioVO {
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String codigoUsuario;
    private String claveUsuario;
    private int estadoUsuario;
    private int idTipoUsuario;

    /**
     *
     */
    public UsuarioVO() {
    }

    /**
     *
     * @param idTipoUsuario
     */
    public UsuarioVO(int idTipoUsuario) {
        
    }

    /**
     *
     * @return
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     *
     * @return
     */
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    /**
     *
     * @param apellidoUsuario
     */
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    /**
     *
     * @return
     */
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     *
     * @param codigoUsuario
     */
    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     *
     * @return
     */
    public String getClaveUsuario() {
        return claveUsuario;
    }

    /**
     *
     * @param claveUsuario
     */
    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    /**
     *
     * @return
     */
    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    /**
     *
     * @param estadoUsuario
     */
    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    /**
     *
     * @return
     */
    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    /**
     *
     * @param idTipoUsuario
     */
    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
    
}
