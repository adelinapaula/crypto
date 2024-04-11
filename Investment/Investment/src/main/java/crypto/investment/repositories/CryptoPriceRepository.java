package crypto.investment.repositories;

import crypto.investment.entities.CryptoPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CryptoPriceRepository extends JpaRepository<CryptoPriceEntity, UUID> {

}


