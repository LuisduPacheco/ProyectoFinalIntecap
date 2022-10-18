
package modelo;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public class TipoUsuarioVO {
    private int idTipoUsuario;
    private String descripcionTipo;

    /**
     *
     */
    public TipoUsuarioVO() {
    }

    /**
     *
     * @param idTipoUsuario
     * @param descripcionTipo
     */
    public TipoUsuarioVO(int idTipoUsuario, String descripcionTipo) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripcionTipo = descripcionTipo;
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

    /**
     *
     * @return
     */
    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    /**
     *
     * @param descripcionTipo
     */
    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
    public String toString(){
    return idTipoUsuario+" - "+descripcionTipo;
    }
        
}
