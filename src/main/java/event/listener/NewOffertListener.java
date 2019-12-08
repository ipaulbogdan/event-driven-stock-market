package event.listener;

import entity.User;
import event.OffertEvent;
import event.OffertEventType;
import lombok.Getter;

import java.util.EventObject;

@Getter
public class NewOffertListener implements EventListener {

    private User user;
    private String stockName;

   public NewOffertListener(User user, String stockName) {
       this.user = user;
       this.stockName = stockName;
   }

    public void listen(EventObject eventObject) {
       if(eventObject instanceof OffertEvent && ((OffertEvent) eventObject).getType().equals(OffertEventType.NEW_OFFERT)) {
           user.alert("New " + stockName + " offert has been added!");
       }
    }
}
