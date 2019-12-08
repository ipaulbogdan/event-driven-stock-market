package event.listener;

import entity.User;
import event.RequestEvent;
import event.RequestEventType;
import lombok.Getter;

import java.util.EventObject;

@Getter
public class NewRequestListener implements EventListener {

    private User user;
    private String stockName;

    public NewRequestListener(User user, String stockName) {
        this.user = user;
        this.stockName = stockName;
    }

    public void listen(EventObject eventObject) {
        if(eventObject instanceof RequestEvent && ((RequestEvent) eventObject).getType().equals(RequestEventType.NEW_REQUEST)) {
            user.alert("New request for " + stockName +"stocks has appeared!");
        }
    }
}
