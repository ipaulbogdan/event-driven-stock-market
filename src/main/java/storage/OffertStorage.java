package storage;

import entity.Offert;
import entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OffertStorage {

    private List<Offert> offerts = new ArrayList<Offert>();

    public void add(Offert offert) {
        offerts.add(offert);
    }

    public Offert get(User user, String stockName) {
        for(Offert offert : offerts) {
            if(offert.getUser().equals(user) && offert.getStockName().equals(stockName)) {
                return offert;
            }
        }
        return null;
    }

    public Offert updateOffert(Offert updateOffert) {
        for(Offert offert: offerts) {
            if(offert.getUser().equals(updateOffert.getUser()) && offert.getStockName().equals(updateOffert.getStockName())) {
                offerts.remove(offert);
                offerts.add(updateOffert);
                return updateOffert;
            }
        }
        return null;
    }
}
