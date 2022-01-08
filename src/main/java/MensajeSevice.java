import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MensajeSevice {// capa intermedia entre menu principal y capa de acceso

    public static void crearMensaje(){
        Scanner sc =  new Scanner(System.in);

        //Pedir datos por consola
        System.out.println("Autor del mensaje");
        String Autor = sc.nextLine();


        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        //Instanciar un mensaje y llenar sus atributos
        Mensajes registro = new Mensajes();

        registro.setAutor_mensaje(Autor);
        registro.setMensaje(mensaje);

        //Insertar la info a una DB
        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensajes(){
MensajesDAO.leerMensajeDB();
    }

    public static void borrarMensajes(){

        Scanner sc =  new Scanner(System.in);

        //Pedir datos por consola
        System.out.println("Id del mensaje a borrar");
        String idMensaje = sc.nextLine();

MensajesDAO.borrarMensajeDB(parseInt(idMensaje));
    }

    public static void actualizarMensajes(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("id mensaje a actualizar");
        String id = sc.nextLine();

        System.out.println("Nuevo Autor del mensaje");
        String Autor = sc.nextLine();

        System.out.println("Escribe nuevo mensaje");
        String mensaje = sc.nextLine();

        Mensajes registro = new Mensajes(mensaje,Autor,parseInt(id));


        MensajesDAO.actualizarMensajeDB(registro);

    }

}
