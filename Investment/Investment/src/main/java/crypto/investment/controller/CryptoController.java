package crypto.investment.controller;

import crypto.investment.entities.CryptoPriceReportEntity;
import crypto.investment.service.impl.CryptoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/crypto")
public class CryptoController {
    private static final String CSV_PATH = "/api/v1/beer";

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    /**
     * This Endpoint returns statistic data about all crypto prices filtered by a specific period of time.
     * @return a list with statistic data for all crypto prices.
     */
    //TODO as an improvement we could add params @RequestParam(value = "from") LocalDateTime from, @RequestParam(value = "from") LocalDateTime to
    @GetMapping("/reports")
    public ResponseEntity<List<CryptoPriceReportEntity>> getReportsBetween() {
        return ResponseEntity.ok(cryptoService.getLastMounthReport());
    }

    @GetMapping("/report")
    public ResponseEntity<CryptoPriceReportEntity> getReportsBetween(@RequestParam("symbol") String symbol) {
        return ResponseEntity.ok(cryptoService.getReportBySymbol(symbol));
    }


}
