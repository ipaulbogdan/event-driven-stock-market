package service;

import entity.Offert;
import entity.Request;
import entity.User;
import event.RequestEvent;
import event.RequestEventType;
import event.listener.EventListener;
import event.listener.NewRequestListener;
import storage.RequestStorage;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class RequestService {

    private List<EventListener> eventListeners = new ArrayList<EventListener>();
    private RequestStorage requestStorage = new RequestStorage();

    public void addRequest(Request request) {
        requestStorage.add(request);
        triggerNewRequestEvent(request);
    }

    public void subscribe(User user, String stockName, RequestEventType eventType) {
        EventListener eventListener;
        switch(eventType) {
            case NEW_REQUEST:
                eventListener = new NewRequestListener(user, stockName);
                eventListeners.add(eventListener);
        }
    }

    private void triggerNewRequestEvent(Request request) {
        EventObject newRequestEvent = new RequestEvent(this, RequestEventType.NEW_REQUEST);
        for(EventListener eventListener : eventListeners) {
            if(eventListener.getStockName().equals(request.getStockName())) {
                eventListener.listen(newRequestEvent);
            }
        }
    }

}
