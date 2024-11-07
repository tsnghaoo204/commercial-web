package com.commercial_website.Services;

import com.commercial_website.DTOs.BrandDTO;

import java.util.Set;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brand);
    Set<BrandDTO> getAll();
    BrandDTO getBrand_byID(Long id);
    void deleteBrand_byID(Long id);
}
