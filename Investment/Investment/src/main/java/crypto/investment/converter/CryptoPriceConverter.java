package crypto.investment.converter;

import crypto.investment.entities.CryptoPriceEntity;
import crypto.investment.model.CryptoPriceCsvRecord;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Component
public class CryptoPriceConverter {

    public CryptoPriceEntity toEntity(CryptoPriceCsvRecord csvRecord) {
        CryptoPriceEntity entity = new CryptoPriceEntity();
        entity.setRecordDate(Objects.requireNonNull(getRecordDateFromTimestamp(csvRecord.getTimestamp())));
        entity.setSymbol(csvRecord.getSymbol());
        entity.setPrice(csvRecord.getPrice());
        return entity;
    }

    private LocalDateTime getRecordDateFromTimestamp(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }
}
