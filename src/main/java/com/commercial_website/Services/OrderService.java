package com.commercial_website.Services;

import com.commercial_website.DTOs.OrderDTO;

import java.util.Set;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    Set<OrderDTO> getAllOrders();
}
