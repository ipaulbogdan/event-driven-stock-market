package event.listener;

import entity.User;

import java.util.EventObject;

public interface EventListener {

    public void listen(EventObject eventObject);

    public User getUser();

    public String getStockName();
}
