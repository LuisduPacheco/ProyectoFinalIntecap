
package modelo;

import java.util.ArrayList;

/**
 *
 * @author zoila, luis, gerardo y balvy
 */
public interface ConsultasUsuario {

    /**
     *
     * @param u
     * @return
     */
    public boolean insertarUsuario(UsuarioVO u);

    /**
     *
     * @return
     */
    public ArrayList<UsuarioVO> consultarUsuario();

    /**
     *
     * @param u
     * @return
     */
    public boolean actualizarUsuario(UsuarioVO u);

    /**
     *
     * @param u
     * @return
     */
    public boolean eliminarUsuario(UsuarioVO u);
}
