package entity;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    private Request request;
    private User buyer;
    private User seller;
    private BigInteger numberOfStocks;
    private BigDecimal price;
}
