package com.commercial_website.Services;

import com.commercial_website.DTOs.LaptopDTO;
import com.commercial_website.Entities.Laptop;

import java.util.List;
import java.util.Set;

public interface LaptopService {
    LaptopDTO createLaptop(LaptopDTO lapDTO);
    Set<LaptopDTO> getAll();
    LaptopDTO getLaptop_byID(Long id);
    Set<LaptopDTO> searchLaptops(String model, String ram, String gpu, String processor, String storage, Integer price, Double sz, String brandName);
    void deleteLaptop(Long id);
    LaptopDTO updateLaptop(Long id ,LaptopDTO lapDTO);
}
