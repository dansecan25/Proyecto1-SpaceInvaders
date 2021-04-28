package proyecto1.Excepciones;

/**
 * Excepcion que se lanza al recibir una direccion invalida en el movimiento de una nave enemiga
 */
public class InvalidDirectionException extends Exception{
    /**
     * Constructor de la excepcion
     */
    public InvalidDirectionException(){
    }

    /**
     * Constructor que incluye un mensaje
     * @param mensaje: String
     */
    public InvalidDirectionException(String mensaje){
        super(mensaje);
    }
}
