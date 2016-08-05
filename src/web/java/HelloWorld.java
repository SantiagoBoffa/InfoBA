import static spark.Spark.*;
import com.edu.utn.infoba.Coordenadas;

public class HelloWorld
{
    public static void main(String[] args)
    {

        Coordenadas coordenadas  = new Coordenadas(-34.603075, -58.381653); // Obelisco
        Coordenadas coordenadas2 = new Coordenadas(-34.608333, -58.371944); // Plaza de mayo

        Double d = coordenadas.distanciaCon(coordenadas2);

        get("/hello", (req, res) -> d.toString());
    }
}