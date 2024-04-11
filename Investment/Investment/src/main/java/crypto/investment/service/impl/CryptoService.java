package crypto.investment.service.impl;

import crypto.investment.entities.CryptoPriceReportEntity;
import crypto.investment.model.CryptoPriceCsvRecord;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public interface CryptoService {
    List<String> INITIAL_CSVS = Arrays.asList("BTC_values.csv", "DOGE_values.csv", "ETH_values.csv", "LTC_values.csv" , "XRP_values.csv");
    List<String> INITIAL_CRYPTOS = Arrays.asList("BTC", "DOGE", "ETH", "LTC" , "XRP");

    List<CryptoPriceCsvRecord> getFromCsv(String csvPathName);

    void loadInitialCryptoData() throws FileNotFoundException;

    List<CryptoPriceReportEntity> getLastMounthReport();
}

