package gui.exceptions;

public class PlayerDeathException extends Exception {

    public PlayerDeathException() {
        super("El jugador ha muerto");
    }
}
