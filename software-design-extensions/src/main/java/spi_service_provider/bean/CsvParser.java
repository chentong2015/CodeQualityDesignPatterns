package spi_service_provider.bean;

public class CsvParser implements IDocumentParser {

    @Override
    public void parse() {
        System.out.println("Parse Csv");
    }
}
