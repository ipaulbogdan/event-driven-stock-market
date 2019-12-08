package event.listener;

import entity.User;
import event.OffertEvent;
import event.OffertEventType;
import lombok.Getter;

import java.util.EventObject;

@Getter
public class SeenOffertListener implements EventListener {

    private User user;
    private String stockName;

    public SeenOffertListener(User user, String stockName) {
        this.user = user;
        this.stockName = stockName;
    }

    public void listen(EventObject eventObject) {
        if(eventObject instanceof OffertEvent && ((OffertEvent) eventObject).getType().equals(OffertEventType.NEW_OFFERT)) {
            user.alert("Someone has seen your " + stockName +" offert!");
        }
    }
}
