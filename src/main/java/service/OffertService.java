package service;

import entity.Offert;
import entity.User;
import event.OffertEvent;
import event.OffertEventType;
import event.listener.EventListener;
import event.listener.NewOffertListener;
import event.listener.SeenOffertListener;
import event.listener.UpdatedOffertListener;
import lombok.NoArgsConstructor;
import storage.OffertStorage;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class OffertService {

    private OffertStorage offertStorage = new OffertStorage();
    private List<EventListener> listeners = new ArrayList<EventListener>();

    public void addOffert(Offert offert) {
        offertStorage.add(offert);

        triggerEvent(offert, OffertEventType.NEW_OFFERT);
    }

    public void getOffert(User user, String stockName) {
        Offert offert = offertStorage.get(user,stockName);

        triggerSeenEvent(offert);
    }

    public void updateOffer(Offert offert) {
        Offert updatedOffert = offertStorage.updateOffert(offert);

        triggerEvent(updatedOffert, OffertEventType.UPDATED_OFFERT);
    }



    public void subscribe(User user,String stockName, OffertEventType offertEventType) {
        EventListener eventListener;

        switch (offertEventType) {
            case NEW_OFFERT:
                eventListener = new NewOffertListener(user, stockName); break;
            case UPDATED_OFFERT:
                eventListener = new UpdatedOffertListener(user, stockName); break;
            case SEEN_OFFERT:
                eventListener = new SeenOffertListener(user, stockName); break;
            default:
                throw new IllegalStateException("Unexpected value: " + offertEventType);
        }

        listeners.add(eventListener);
    }

    private void triggerEvent(Offert offert, OffertEventType eventType) {
        OffertEvent offertEvent;
        
        switch(eventType) {
            case NEW_OFFERT:
                offertEvent = new OffertEvent(this, OffertEventType.NEW_OFFERT); break;
            case UPDATED_OFFERT:
                offertEvent = new OffertEvent(this, OffertEventType.UPDATED_OFFERT); break;
            default:
                throw new IllegalStateException("Unexpected value: " + eventType);
        }
        
        for(EventListener eventListener : listeners) {
            if(eventListener.getStockName().equals(offert.getStockName())) {
                eventListener.listen(offertEvent);
            }
        }
    }

    private void triggerSeenEvent(Offert offert) {
        OffertEvent offertEvent = new OffertEvent(this, OffertEventType.SEEN_OFFERT);

        for(EventListener eventListener : listeners) {
            if(eventListener.getUser().equals(offert.getUser()) && eventListener.getStockName().equals(offert.getStockName())) {
                eventListener.listen(offertEvent);
            }
        }
    }
    
    


}

