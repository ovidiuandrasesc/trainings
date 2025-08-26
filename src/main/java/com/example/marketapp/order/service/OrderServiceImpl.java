package com.example.marketapp.order.service;

import com.example.marketapp.order.OrderService;
import com.example.marketapp.order.StripeOrderService;
import com.example.marketapp.order.dto.OrderDto;
import com.example.marketapp.order.dto.StripePaymentDto;
import com.example.marketapp.order.entity.OrderEntity;
import com.example.marketapp.order.entity.StripePayment;
import com.example.marketapp.order.mapper.OrderMapper;
import com.example.marketapp.order.repository.OrderRepository;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository  repository;
    private final OrderMapper orderMapper;
    private final StripeOrderService stripeOrderService;

    @Override
    @Transactional
    public String createOrder(OrderDto orderDto) {
        var entityOrder = orderMapper.toEntity(orderDto);
        entityOrder.setStatus("PENDING");

        StripePaymentDto stripePayment = getStripePayment(orderDto, entityOrder);
        entityOrder.setStripePayment(orderMapper.toEntity(stripePayment));

        entityOrder = repository.save(entityOrder);
        return entityOrder.getId();
    }

    @Override
    public void cancelOrder(String orderId) {

    }

    @Override
    public void completeOrder(String orderId) {

    }


    private StripePaymentDto getStripePayment(OrderDto orderDto, OrderEntity entityOrder) {
        try {
            return stripeOrderService.createStripePayment(orderDto.clientId(), orderDto.stripeCustomerId(), entityOrder.getTotalPrice());
        } catch (StripeException e) {
            throw new RuntimeException("Failed to create Stripe payment", e);
        }
    }
}
