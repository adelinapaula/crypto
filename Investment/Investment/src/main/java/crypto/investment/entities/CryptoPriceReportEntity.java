package crypto.investment.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class CryptoPriceReportEntity {

    public CryptoPriceReportEntity(String symbol, BigDecimal minPrice, BigDecimal maxPrice, Timestamp oldest, Timestamp newest) {
        this.symbol = symbol;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.oldest = oldest;
        this.newest = newest;
    }

    private String symbol;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Timestamp oldest;
    private Timestamp newest;
}
