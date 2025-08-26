package com.example.marketapp.order.mapper;

import com.example.marketapp.order.dto.OrderDto;
import com.example.marketapp.order.dto.StripePaymentDto;
import com.example.marketapp.order.entity.CheckoutProduct;
import com.example.marketapp.order.entity.OrderEntity;
import com.example.marketapp.order.entity.StripePayment;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderedProducts", source = "orderedProducts")
    @Mapping(target = "stripePayment", ignore = true)
    OrderEntity toEntity(OrderDto orderEntity);

    CheckoutProduct toEntity(OrderDto.CheckoutProductDto request);

    StripePayment toEntity(StripePaymentDto request);


    @AfterMapping
    default void calculateTotals(OrderDto request, @MappingTarget OrderEntity order) {
        double totalPrice = order.getOrderedProducts()
                .stream()
                .mapToDouble(p -> p.price() * p.quantity())
                .sum();
        order.setTotalPrice(totalPrice);
    }
}
