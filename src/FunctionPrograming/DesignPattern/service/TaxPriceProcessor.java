package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.Price;
import FunctionPrograming.DesignPattern.model.PriceProcessor;

public class TaxPriceProcessor implements PriceProcessor {
    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + "then applied tax");
    }
}
