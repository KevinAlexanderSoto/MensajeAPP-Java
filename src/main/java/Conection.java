import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    Dotenv dotenv = Dotenv.load();

    /**
     * conectarse a una dataBase MySql
     *
     * **/
    public Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://"
                    +dotenv.get("DATABASE_HOST")+":"+dotenv.get("DATABASE_PORT")
                    +"/"+dotenv.get("DATABASE_NAME"),dotenv.get("DATABASE_USER"),dotenv.get("DATABASE_PASSWORD"));

        } catch (SQLException e) {
            System.out.println("no se pudo conectar");
            e.printStackTrace();
        } {

        }
return connection;
    }
}
