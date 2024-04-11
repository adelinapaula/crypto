package crypto.investment.repositories;

import crypto.investment.entities.CryptoPriceEntity;
import crypto.investment.entities.CryptoPriceReportEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CryptoPriceRepository extends JpaRepository<CryptoPriceEntity, UUID> {


    /**
     * TODO add documentation here
     *
     * @param symbol
     * @param from
     * @param to
     * @return
     */

    @Query("""
            SELECT  new crypto.investment.entities.CryptoPriceReportEntity(
                cryptoPrice.symbol,
                MIN(cryptoPrice.price),
                MAX (cryptoPrice.price),
                MIN(cryptoPrice.recordDate),
                MAX(cryptoPrice.recordDate))
            FROM
                CryptoPriceEntity cryptoPrice
            WHERE cryptoPrice.symbol = :symbol
            """)
    CryptoPriceReportEntity findReportBySymbol(@NotNull @Param("symbol") String symbol);
}


