package com.commercial_website.Services.Impl;

import com.commercial_website.DTOs.LaptopDTO;
import com.commercial_website.Entities.Laptop;
import com.commercial_website.Exception.ResourceNotFoundException;
import com.commercial_website.Mappers.LaptopMapper;
import com.commercial_website.Repositories.BrandRepository;
import com.commercial_website.Repositories.DiscountRepository;
import com.commercial_website.Repositories.LaptopRepository;
import com.commercial_website.Services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImplLaptopService implements LaptopService {

    @Autowired
    BrandRepository brdRepo;

    @Autowired
    DiscountRepository disRepo;

    @Autowired
    LaptopRepository repo;

    @Autowired
    LaptopMapper laptopMapper;

    @Override
    public LaptopDTO createLaptop(LaptopDTO lapDTO) {
        Laptop laptop = laptopMapper.mapToEntity(lapDTO);
        Laptop saved = repo.save(laptop);
        return laptopMapper.mapToDTO(saved);
    }

    @Override
    public Set<LaptopDTO> getAll() {
        return repo.findAll().stream()
                .map(laptopMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public LaptopDTO getLaptop_byID(Long id) {
        Laptop laptop = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop not found"));
        return laptopMapper.mapToDTO(laptop);
    }

    @Override
    public Set<LaptopDTO> searchLaptops(String model, String ram, String gpu, String processor, String storage, Integer price, Double sz, String brandName) {
        Set<LaptopDTO> laptops = new HashSet<>();
        if (model != null && !model.isEmpty()) {
            laptops = repo.findByModelContaining(model).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (gpu != null && !gpu.isEmpty()) {
            laptops = repo.findByGpuContaining(gpu).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (processor != null && !processor.isEmpty()) {
            laptops = repo.findByProcessorContaining(processor).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (storage != null && !storage.isEmpty()) {
            laptops = repo.findByStorageContaining(storage).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (ram != null && !ram.isEmpty()) {
            laptops = repo.findByRamContaining(ram).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (price != null) {
            laptops = repo.findByPrice(price).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (sz != null) {
            laptops = repo.findByScreenSizeGreaterThan(sz).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        if (brandName != null && !brandName.isEmpty()) {
            laptops = repo.findByBrand_BrandNameContaining(brandName).stream()
                    .map(laptopMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }
        return laptops;
    }

    @Override
    public void deleteLaptop(Long id) {
        repo.deleteById(id);
    }

    @Override
    public LaptopDTO updateLaptop(Long id, LaptopDTO lapDTO) {
        // Fetch the laptop entity or throw an exception if it doesn't exist
        Laptop laptop = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop not found"));

        // Update fields from LaptopDTO to Laptop entity
        laptop.setModel(lapDTO.getModel());
        laptop.setPrice(lapDTO.getPrice());
        laptop.setStockQuantity(lapDTO.getStockQuantity());
        laptop.setDescription(lapDTO.getDescription());
        laptop.setCreatedAt(lapDTO.getCreatedAt());
        laptop.setProcessor(lapDTO.getProcessor());
        laptop.setRam(lapDTO.getRam());
        laptop.setStorage(lapDTO.getStorage());
        laptop.setGpu(lapDTO.getGpu());
        laptop.setScreenSize(lapDTO.getScreenSize());
        laptop.setBattery(lapDTO.getBattery());
        laptop.setWeight(lapDTO.getWeight());
        laptop.setOs(lapDTO.getOs());
        laptop.setImage(lapDTO.getImage());

        // Map referenced entities (Brand, Discount, Order) if they are present in DTO
        if (lapDTO.getBrandName() != null) {
            laptop.setBrand(brdRepo.findByBrandName(lapDTO.getBrandName()));
        }
        if (lapDTO.getDiscount() != null) {
            laptop.setDiscount(lapDTO.getDiscount());
        }

        // Save the updated entity
        Laptop savedLaptop = repo.save(laptop);

        // Convert back to DTO for return
        return laptopMapper.mapToDTO(savedLaptop);
    }


}
