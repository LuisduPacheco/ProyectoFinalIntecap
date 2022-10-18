
package modelo;

import java.util.ArrayList;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public interface ConsultasMarca {

    /**
     *
     * @param m
     * @return
     */
    public boolean insertarMarca(MarcaVO m);

    /**
     *
     * @return
     */
    public ArrayList<MarcaVO> consultarMarca();

    /**
     *
     * @param m
     * @return
     */
    public boolean actualizarMarca(MarcaVO m);

    /**
     *
     * @param m
     * @return
     */
    public boolean eliminarMarca(MarcaVO m);
}
