
package modelo;

public class TipoUsuarioVO {
    private int idTipoUsuario;
    private String descripcionTipo;

    public TipoUsuarioVO() {
    }

    public TipoUsuarioVO(int idTipoUsuario, String descripcionTipo) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripcionTipo = descripcionTipo;
    }

    
    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
    public String toString(){
    return idTipoUsuario+" - "+descripcionTipo;
    }
        
}
