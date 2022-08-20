package FunctionPrograming.DesignPattern.model;

public class BasicPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return price;
    }
}
