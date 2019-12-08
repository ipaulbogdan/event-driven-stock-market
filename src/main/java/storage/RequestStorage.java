package storage;

import entity.Request;
import entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RequestStorage {

    private List<Request> requests = new ArrayList<Request>();

    public void add(Request request) {
        requests.add(request);
    }

    public Request get(User user, String stockName) {
        for (Request request: requests) {
            if(request.getUser().equals(user) && request.getStockName().equals(stockName)) {
                return request;
            }
        }
        return null;
    }

}
