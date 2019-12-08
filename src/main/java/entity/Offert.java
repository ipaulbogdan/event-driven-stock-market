package entity;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
public class Offert {

    private String stockName;
    private User user;
    private BigInteger numberOfStocks;
    private BigDecimal price;

}
