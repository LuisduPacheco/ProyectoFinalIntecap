
package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements ConsultasUsuario{
 
    @Override
    public boolean insertarUsuario(UsuarioVO u) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "INSERT INTO USUARIO (nombre_usuario, "+
                           "apellido_usuario, "+
                           "codigo_usuario, "+
                           "clave_usuario, "+
                           "estado_usuario, "+
                           "id_tipo_usuario_fk ) "+
                           "VALUES ('"+u.getNombreUsuario()+"', '"+
                                        u.getApellidoUsuario()+"', '"+
                                        u.getCodigoUsuario()+"', '"+
                                        u.getClaveUsuario()+"', "+
                                        u.getEstadoUsuario()+", "+
                                        u.getIdTipoUsuario()+")";
        c.consultasMultiples(query);
        }catch (Exception e){
            System.err.println("Error(InsertMarca):"+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> consultarUsuario() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        try{ 
            c.conectar();
            String query="SELECT id_usuario,"+
                         "nombre_usuario,"+
                         "apelllido_usuario,"+
                         "codigo_usuario,"+
                         "clave_usuario,"+
                         "estado_usuario, "+
                         "id_tipo_usuario_fk "+
                         "from usuario";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()){
                UsuarioVO uvo = new UsuarioVO();
                uvo.setIdUsuario(rs.getInt(1));
                uvo.setNombreUsuario(rs.getString(2));
                uvo.setApellidoUsuario(rs.getString(3));
                uvo.setCodigoUsuario(rs.getString(4));
                uvo.setClaveUsuario(rs.getString(5));
                uvo.setEstadoUsuario(rs.getInt(6));
                uvo.setIdTipoUsuario(rs.getInt(7));
                info.add(uvo);
            }
        }catch (Exception e){
            System.err.println("Error(MostrarMarca): "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean actualizarUsuario(UsuarioVO u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarUsuario(UsuarioVO u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
