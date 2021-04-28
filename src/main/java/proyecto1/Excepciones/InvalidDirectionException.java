package proyecto1.Excepciones;

public class InvalidDirectionException extends Exception{
    public InvalidDirectionException(){
    }
    public InvalidDirectionException(String mensaje){
        super(mensaje);
    }
}
