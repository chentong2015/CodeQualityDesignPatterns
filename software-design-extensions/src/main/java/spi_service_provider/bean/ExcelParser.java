package spi_service_provider.bean;

public class ExcelParser implements IDocumentParser {

    @Override
    public void parse() {
        System.out.println("Parse excel");
    }
}
