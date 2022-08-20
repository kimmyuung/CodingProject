package FunctionPrograming.DesignPattern;

import FunctionPrograming.DesignPattern.model.BasicPriceProcessor;
import FunctionPrograming.DesignPattern.model.Price;
import FunctionPrograming.DesignPattern.model.PriceProcessor;
import FunctionPrograming.DesignPattern.service.DisountPriceProcessor;
import FunctionPrograming.DesignPattern.service.TaxPriceProcessor;

public class DesignPattern {
    // 디자인 패턴 : 반복해서 등장하는 프로그래밍 문제들에 대한 해법들을 패턴화 해놓은 것
    // 패턴들을 숙지해놓으면 비슷한 문제가 생겼을 때 패턴들이 이정표가 됨

    // 디자인 패턴 종류
    // 생성패턴 : 오브젝트의 생성에 관련된 패턴
    // 구조패턴 : 상속을 이용해 클래스/오브젝트를 조합하여 더 발전된 구조로 만드는 패턴
    // 행동패턴 : 필요한 작업을 여러 객체에 분배하여 객체간 결합도를 줄이게 해주는 패턴

    // 대부분의 디자인 패턴들은 구현에 많은 인터페이스/클래스/메서드를 필요로 함
    public static void main(String[] args) {
        Price unprocessedPrice = new Price("Original Price");

        PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = new DisountPriceProcessor();
        PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor);

        Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);

        System.out.println(processedPrice.getPrice());

        PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
                .andThen(taxPriceProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply another processor"));

        Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
        System.out.println(processedPrice2);
        // 재활용이 불가능!
    }

}
