package crypto.investment.service.impl;

import crypto.investment.model.CryptoPriceCsvRecord;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CryptoServiceTest {

    CryptoService service;
    //TODO  This should be a path to test data. An app.properties files should be added for tests */
    private final static String BTC_CSV_FILE_PATH = "classpath:csv_crypto_prices/BTC_values.csv";

    @Test
    void uploadFromCsvSuccessTest() throws FileNotFoundException {
        File file = ResourceUtils.getFile(BTC_CSV_FILE_PATH);
        List<CryptoPriceCsvRecord> pricesFromCsv = service.getFromCsv(String.valueOf(file));
        System.out.println(pricesFromCsv.size());
        assertThat(pricesFromCsv.size()).isGreaterThan(0);
    }
}