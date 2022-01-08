import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {// Data Acces Object: permite conexion con dataBase

    public static void crearMensajeDB(Mensajes mensaje){

        Conection dbConnection = new Conection();
        try (Connection conexion = dbConnection.getConnection()) {
            PreparedStatement ps=null;
            try {
                String query="insert into mensajes(mensaje,autor_mensaje,fecha_mensaje) values (?,?,CURRENT_TIMESTAMP)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());

                ps.executeUpdate();// se encarga de enviar a la base de datos la consulta
                System.out.println("createdMessage");
            } catch (SQLException e) {
                System.out.println("cantCreateMessage");
                System.out.println(e);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    public static void leerMensajeDB(){
        Conection dbConnection = new Conection();
        try (Connection conexion = dbConnection.getConnection()) {
            PreparedStatement ps=null;
            ResultSet rs = null;

            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs= ps.executeQuery();// utilizamos este por que no estamos incertando datos

            while(rs.next()){
                System.out.print("\n[ID: "+rs.getInt("id_mensajes")+" | ");
                System.out.print("Autor: "+rs.getString("autor_mensaje")+" ] ");
                System.out.print("mensaje: -"+rs.getString("mensaje")+" | ");
                System.out.print("fecha: -"+rs.getString("fecha_mensaje")+" | ");
            }


        }catch(Exception ex){
            System.out.println(ex);
        }


    }

    public static void borrarMensajeDB(int id_mensaje){
        Conection dbConnection = new Conection();
        try(Connection conexion = dbConnection.getConnection()){
            PreparedStatement ps=null;
            try {
                String query="delete  from mensajes where id_mensajes = ? ";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                int countRowsUpdated = ps.executeUpdate();

                if (countRowsUpdated != 0){
                    System.out.println("deletedMessage");

                    return;
                }
                System.out.println("no rows afected");

            } catch (SQLException e) {
                System.out.println("cantDeleteMessages");
                System.out.println(e);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conection dbConnection = new Conection();
        try(Connection conexion = dbConnection.getConnection()){
            PreparedStatement ps=null;
            try {
                String query="update mensajes SET mensaje = ? ,autor_mensaje =? ," +
                        "fecha_mensaje = CURRENT_TIMESTAMP" +
                        " where id_mensajes = ? ";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.setInt(3, mensaje.getIdMensaje());
                int countRowsUpdated = ps.executeUpdate();

                if (countRowsUpdated != 0){
                    System.out.println("Message Updated");

                    return;
                }
                System.out.println("no rows afected");

            } catch (SQLException e) {
                System.out.println("cantUpdatedMessage");
                System.out.println(e);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
