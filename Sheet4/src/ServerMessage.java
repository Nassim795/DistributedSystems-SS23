import java.io.Serializable;

public class ServerMessage implements Serializable {
    private Object returnValue;

    public ServerMessage(Object returnValue) {
        this.returnValue = returnValue;
    }
    public Object getReturnValue() { // getter
        return returnValue;
    }
}
