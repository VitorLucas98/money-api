package vitorluc.moneyapi.services.exceptions;

public class ObjectNotFoundException extends  RuntimeException{

    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String s) {
        super(s);
    }
}
