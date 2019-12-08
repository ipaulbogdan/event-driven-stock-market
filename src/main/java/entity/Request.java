package entity;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Setter
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Request {

    private String stockName;
    private User user;
    private BigInteger numberOfStocks;
    private BigDecimal price;
}
