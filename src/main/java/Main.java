import entity.Offert;
import entity.Request;
import entity.User;
import event.OffertEventType;
import event.RequestEventType;
import service.OffertService;
import service.RequestService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;


public class Main {

    private static OffertService offertService = new OffertService();
    private static RequestService requestService = new RequestService();

    public static void main(String[] args) {
        User user1 = User.builder().username("idorasipaul").build();
        User user2 = User.builder().username("bogdan").build();

        Offert offert1 = createRandomOfferts(user2);
        offert1.setStockName("rompetrol");

        Request request = createRandomRequests(user2);
        request.setStockName("gazprom");

        offertService.subscribe(user1, "rompetrol", OffertEventType.NEW_OFFERT);
        offertService.subscribe(user2, "rompetrol", OffertEventType.SEEN_OFFERT);
        offertService.subscribe(user1, "rompetrol", OffertEventType.UPDATED_OFFERT);

        requestService.subscribe(user1, "gazprom", RequestEventType.NEW_REQUEST);

        offertService.addOffert(offert1);
        offertService.getOffert(user2, "rompetrol");

        Offert updateOffert1 = createRandomOfferts(user2);
        updateOffert1.setStockName("rompetrol");

        offertService.updateOffer(updateOffert1);

        requestService.addRequest(request);

    }

    private static User createRandomUser() {
        return User.builder().username(UUID.randomUUID().toString()+"-USER").build();
    }

    private static Offert createRandomOfferts(User user) {
        Random random = new Random();

        return Offert.builder()
                .stockName(UUID.randomUUID().toString()+"-OFFERT")
                .price(BigDecimal.valueOf(random.nextFloat()))
                .numberOfStocks(BigInteger.valueOf(random.nextInt()))
                .user(user)
                .build();
        }

        private static Request createRandomRequests(User user) {
            Random random = new Random();

            return Request.builder()
                    .numberOfStocks(BigInteger.valueOf(random.nextInt()))
                    .price(BigDecimal.valueOf(random.nextFloat()))
                    .stockName(UUID.randomUUID().toString()+"-REQUEST")
                    .user(user)
                    .build();
        }
}
