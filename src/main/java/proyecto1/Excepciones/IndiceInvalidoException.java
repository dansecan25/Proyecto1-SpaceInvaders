package proyecto1.Excepciones;

public class IndiceInvalidoException extends Exception{
    public IndiceInvalidoException(){
    }
    public IndiceInvalidoException(String mensaje){
        super(mensaje);
    }
}
