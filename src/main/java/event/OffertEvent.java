package event;

import lombok.Getter;

import java.util.EventObject;

@Getter
public class OffertEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    private OffertEventType type;

    public OffertEvent(Object source, OffertEventType eventType) {
        super(source);
        this.type = eventType;
    }


}

