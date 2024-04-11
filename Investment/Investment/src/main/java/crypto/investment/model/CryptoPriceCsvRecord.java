package crypto.investment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CryptoPriceCsvRecord {
    private  Long timestamp;
    private  String symbol;
    private  BigDecimal price;
}
