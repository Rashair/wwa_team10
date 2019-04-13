package pl.allegro.braincode.team10.exception;

public class GoogleDistancesCalculationException extends RuntimeException {

    public GoogleDistancesCalculationException() {
        super();
    }

    public GoogleDistancesCalculationException(String s) {
        super(s);
    }

    public GoogleDistancesCalculationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GoogleDistancesCalculationException(Throwable throwable) {
        super(throwable);
    }
}
