package event;

import lombok.Getter;

import java.util.EventObject;

@Getter
public class RequestEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    private RequestEventType type;

    public RequestEvent(Object source, RequestEventType eventType) {
        super(source);
        this.type = eventType;
    }
}
