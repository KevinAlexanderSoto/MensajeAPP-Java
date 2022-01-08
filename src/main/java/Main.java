
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int option =0;

        do{
            System.out.println("------------------------------------------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. crear mensaje");
            System.out.println("2. Listar Mensajes");
            System.out.println("3 . Editar Mensaje");
            System.out.println("4 . Eliminar Mensaje");
            System.out.println("5 . Salir");
            option = sc.nextInt();
            switch (option){
                case 1 :
                    MensajeSevice.crearMensaje();
                    break;
                case 2 :
                    MensajeSevice.listarMensajes();
                    break;
                case 3 :
                    MensajeSevice.actualizarMensajes();
                    break;
                case 4 :
                    MensajeSevice.borrarMensajes();
                    break;
                default:

                    break;
            }
        }while(option != 5);

    }
}
