package com.commercial_website.Services;

import com.commercial_website.DTOs.DiscountDTO;

import java.util.Set;

public interface DiscountService {
    DiscountDTO createDiscount(DiscountDTO disDTO);
    Set<DiscountDTO> getAll();
    DiscountDTO findDiscountById(Long id);
    void deleteDiscount(Long id);
}
