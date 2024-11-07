package com.commercial_website.Controllers;

import com.commercial_website.DTOs.LaptopDTO;
import com.commercial_website.Services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    LaptopService lapSer;

    @GetMapping
    public ResponseEntity<Set<LaptopDTO>> getAlls() {
        return ResponseEntity.ok(lapSer.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<LaptopDTO> createLaptop(@RequestBody LaptopDTO lapDTO) {
        LaptopDTO save = lapSer.createLaptop(lapDTO);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LaptopDTO> getByID(@PathVariable Long id) {
        return ResponseEntity.ok(lapSer.getLaptop_byID(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Set<LaptopDTO>> getByElement(@RequestParam(required = false) String model,
                                                        @RequestParam(required = false) String ram,
                                                        @RequestParam(required = false) String gpu,
                                                        @RequestParam(required = false) String processor,
                                                        @RequestParam(required = false) String storage,
                                                        @RequestParam(required = false) Integer price,
                                                        @RequestParam(required = false) Double screenSize,
                                                        @RequestParam(required = false) String brandName) {

        return ResponseEntity.ok(lapSer.searchLaptops(model, ram, gpu, processor, storage, price, screenSize, brandName));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable Long id) {
        lapSer.deleteLaptop(id);
        return new ResponseEntity<>("Laptop deleted", HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<LaptopDTO> updateLaptop(@PathVariable Long id, @RequestBody LaptopDTO lapDTO) {
        LaptopDTO save = lapSer.updateLaptop(id, lapDTO);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
}