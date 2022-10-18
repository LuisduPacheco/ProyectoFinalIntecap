
package modelo;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public class MarcaVO {
    private int idMarca;
    private String nombreMarca;
    private int estadoMarca;

    /**
     *
     */
    public MarcaVO() {
    }
 
    /**
     *
     * @param idMarca
     * @param nombreMarca
     */
    public MarcaVO(int idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
     }
 
    /**
     *
     * @param nombreMarca
     */
    public MarcaVO( String nombreMarca) { 
        this.nombreMarca = nombreMarca;
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

    /**
     *
     * @return
     */
    public String getNombreMarca() {
        return nombreMarca;
    }

    /**
     *
     * @param nombreMarca
     */
    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    /**
     *
     * @return
     */
    public int getEstadoMarca() {
        return estadoMarca;
    }

    /**
     *
     * @param estadoMarca
     */
    public void setEstadoMarca(int estadoMarca) {
        this.estadoMarca = estadoMarca;
    }
    
    public String toString(){
        return idMarca+" - "+nombreMarca;
    }

}
