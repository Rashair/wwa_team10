package pl.allegro.braincode.team10.exception;

public class SearchingGoogleCoordinatesException extends RuntimeException{

    public SearchingGoogleCoordinatesException() {
        super();
    }

    public SearchingGoogleCoordinatesException(String s) {
        super(s);
    }

    public SearchingGoogleCoordinatesException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SearchingGoogleCoordinatesException(Throwable throwable) {
        super(throwable);
    }
}
