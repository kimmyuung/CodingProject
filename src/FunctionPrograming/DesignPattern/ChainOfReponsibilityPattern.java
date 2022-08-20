package FunctionPrograming.DesignPattern;

import FunctionPrograming.DesignPattern.service.OrderProcessStep;
import FunctionPrograming.Stream.Order;
import FunctionPrograming.Stream.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;

public class ChainOfReponsibilityPattern {
    // 행동 패턴의 하나
    // 명령과 명령을 각각의 방법으로 처리할 수 있는 처리 객체들이 있을 때,
    // 처리 객체들을 체인으로 엮음
    // 명령을 처리 객체들이 체인의 앞에서부터 하나씩 처리해보도록 함
    // 각 처리 객체는 자신이 처리할 수 없을 때 체인의 다음 처리 객체로 명령을 넘김
    // 체인의 끝에 다다르면 처리가 끝남
    // 새로운 처리 객체를 추가하는 것으로 매우 간단히 처리 방법을 더 할 수 있음

    public static void main(String[] args) {
        OrderProcessStep initallizeStep = new OrderProcessStep(order ->
        {
            if(order.getStatus() == Order.OrderStatus.CREATED) {
                System.out.println("Start processing order " + order.getId());
                order.setStatus(Order.OrderStatus.IN_PROGRESS);
            }
        });

        OrderProcessStep setOrderAmountStep = new OrderProcessStep(order -> {
           if(order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
               System.out.println("Setting amount of order " + order.getId());
               order.setAmount(order.getOrderLines().stream()
                       .map(OrderLine::getAmount)
                       .reduce(BigDecimal.ZERO, BigDecimal::add));
           }
        });

        OrderProcessStep verifyOrderStep = new OrderProcessStep(order -> {
            if(order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("verifying of order " + order.getId());
                if(order.getAmount().compareTo(BigDecimal.ZERO) <=0) {
                    order.setStatus(Order.OrderStatus.ERROR);
                }
            }
        });

        OrderProcessStep paymentOrderStep = new OrderProcessStep(order -> {
            if(order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("payment of order " + order.getId());
                order.setStatus(Order.OrderStatus.PROCESSED);
            }
        });

        OrderProcessStep handleErrorStep = new OrderProcessStep(order -> {
            if(order.getStatus() == Order.OrderStatus.ERROR) {
                System.out.println("Failed to process order " + order.getId());
            }
        });

        OrderProcessStep completeProcessingOrderStep = new OrderProcessStep(order -> {
           if(order.getStatus() == Order.OrderStatus.PROCESSED) {
               System.out.println("Finished processing order " + order.getId());
           }
        });

        OrderProcessStep chainedOrderProcessSteps = initallizeStep
                .setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(paymentOrderStep)
                .setNext(handleErrorStep)
                .setNext(completeProcessingOrderStep);

        Order order = new Order()
                .setId(1001L)
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        Order order2 = new Order()
                .setId(1001L)
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(-2000))));

        chainedOrderProcessSteps.process(order);
        chainedOrderProcessSteps.process(order2);

    }

}
