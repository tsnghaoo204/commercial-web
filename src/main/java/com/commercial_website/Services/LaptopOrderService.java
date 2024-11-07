package com.commercial_website.Services;

import com.commercial_website.DTOs.LaptopOrderDTO;
import com.commercial_website.Entities.LaptopOrder;

import java.util.Set;

public interface LaptopOrderService {
    LaptopOrderDTO createOrder(LaptopOrderDTO dto);
    Set<LaptopOrderDTO> getAll();
}
