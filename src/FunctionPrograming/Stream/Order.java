package FunctionPrograming.Stream;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private LocalDateTime creadtdAt;
    private long createdBuUserId;
    private OrderStatus status;
    private BigDecimal amount; // 큰 숫자 무리없이 다룰수 있게 함
    private List<OrderLine> orderLine;

    public enum OrderStatus {
        CREATED,
        IN_PROGRESS,
        ERROR,
        PROCESSED
    }

    public enum OrderLine{
        PURCHASE,
        DISCOUNT
    }

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreadtdAt() {
        return creadtdAt;
    }

    public Order setCreadtdAt(LocalDateTime creadtdAt) {
        this.creadtdAt = creadtdAt;
        return this;
    }

    public long getCreatedBuUserId() {
        return createdBuUserId;
    }

    public Order setCreatedBuUserId(long createdBuUserId) {
        this.createdBuUserId = createdBuUserId;
        return this;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Order setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public Order setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creadtdAt=" + creadtdAt +
                ", createdBuUserId=" + createdBuUserId +
                ", status=" + status +
                ", amount=" + amount +
                ", orderLine=" + orderLine +
                '}';
    }


}
