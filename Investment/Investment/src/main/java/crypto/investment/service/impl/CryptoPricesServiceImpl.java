package crypto.investment.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import crypto.investment.converter.CryptoPriceConverter;
import crypto.investment.entities.CryptoPriceEntity;
import crypto.investment.exception.CryptoRecommendationsException;
import crypto.investment.model.CryptoPriceCsvRecord;
import crypto.investment.repositories.CryptoPriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.util.List;

@Slf4j
@Service
public class CryptoPricesServiceImpl implements CryptoService {

    String CSV_FILE_PATH;

    private final CryptoPriceRepository cryptoPriceRepository;
    private final CryptoPriceConverter cryptoPriceConverter;

    public CryptoPricesServiceImpl(@Value(value = "${csv.path}") String CSV_FILE_PATH,
                                   CryptoPriceRepository cryptoPriceRepository, CryptoPriceConverter cryptoPriceConverter) {
        this.CSV_FILE_PATH = CSV_FILE_PATH;
        this.cryptoPriceRepository = cryptoPriceRepository;
        this.cryptoPriceConverter = cryptoPriceConverter;
    }

    @Override
    public List<CryptoPriceCsvRecord> getFromCsv(String pathName) {
        //TODO Add checks for pathName
        try {
            log.info("Trying to read from path: " + pathName);
            File csvFile = ResourceUtils.getFile(pathName);
            return new CsvToBeanBuilder<CryptoPriceCsvRecord>
                    (new FileReader(csvFile))
                    .withType(CryptoPriceCsvRecord.class)
                    .build().parse();
        } catch (
                FileNotFoundException exception) {
            throw new CryptoRecommendationsException("The csv file could not be read.", exception);
        }
    }

    public void loadInitialCryptoData() {
        INITIAL_CSVS
                .forEach(csvName -> {
                    List<CryptoPriceCsvRecord> csvCryptoPrices = getFromCsv(CSV_FILE_PATH + FileSystems.getDefault().getSeparator() + csvName);
                    List<CryptoPriceEntity> entityCryptoPrices = csvCryptoPrices.stream()
                            .map(cryptoPriceConverter::toEntity)
                            .toList();
                    cryptoPriceRepository.saveAll(entityCryptoPrices);
                });
    }
}
