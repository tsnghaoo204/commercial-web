package com.commercial_website.Repositories;

import com.commercial_website.Entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Set<Laptop> findByModelContaining(String model);

    Set<Laptop> findByGpuContaining(String gpu);

    Set<Laptop> findByPrice(int price);

    Set<Laptop> findByRamContaining(String ram);

    Set<Laptop> findByScreenSizeGreaterThan(double screen_size);

    Set<Laptop> findByStorageContaining(String storage);

    Set<Laptop> findByProcessorContaining(String processor);

    Set<Laptop> findByBrand_BrandNameContaining(String brand);
}
