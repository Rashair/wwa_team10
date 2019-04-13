package pl.allegro.braincode.team10.exception;

public class SearchingInPostDeliveryException extends RuntimeException {

    public SearchingInPostDeliveryException(){
        super();
    }

    public SearchingInPostDeliveryException(String s) {
        super(s);
    }

    public SearchingInPostDeliveryException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SearchingInPostDeliveryException(Throwable throwable) {
        super(throwable);
    }
}