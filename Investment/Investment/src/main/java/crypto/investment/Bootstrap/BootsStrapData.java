package crypto.investment.Bootstrap;

import crypto.investment.service.impl.CryptoService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsStrapData implements CommandLineRunner {
    private final CryptoService cryptoService;

    public BootsStrapData(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        cryptoService.loadInitialCryptoData();
    }
}
