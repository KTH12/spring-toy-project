package com.spring.commerce.domain;

import com.spring.commerce.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderItemRequestDto {
    private Long itemId;

    private int count;

    public Order toOrderEntity() {
        return Order.builder()
                .orderDate(LocalDateTime.now())
                .orderStatus(OrderStatus.READY)
                .build();
    }

    public OrderItem toEntity(Order order, Item item, int price) {
        return OrderItem.builder()
                .order(order)
                .item(item)
                .orderPrice(count * price)
                .count(count)
                .build();
    }
}