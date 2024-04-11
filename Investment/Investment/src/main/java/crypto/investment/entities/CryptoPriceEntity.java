package crypto.investment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class CryptoPriceEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @NotNull
    private Timestamp recordDate;
    @NotNull
    private String symbol;
    @NotNull
    private BigDecimal price;
    @CreationTimestamp
    private LocalDateTime createdDate;
}
