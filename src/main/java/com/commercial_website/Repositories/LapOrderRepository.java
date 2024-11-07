package com.commercial_website.Repositories;

import com.commercial_website.Entities.LaptopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LapOrderRepository extends JpaRepository<LaptopOrder, Long> {
}
