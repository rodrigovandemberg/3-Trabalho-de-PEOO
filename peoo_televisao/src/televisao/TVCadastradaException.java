package televisao;

public class TVCadastradaException extends Exception {

    public Televisao televisao;

    /**
     * Exceção da TV já cadastrada
     * @param msg
     * @param televisao
     */


    public TVCadastradaException (String msg, Televisao televisao){

        super(msg);
        this.televisao = televisao;

    }

}
