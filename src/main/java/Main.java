import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;
public class Main {
    public static void main(String[] args) {
Conection dbConnection =  new Conection();
try{
    dbConnection.get_connection();
}catch (Exception e){
    System.out.println(e);
        }

    }
}
