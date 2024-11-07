package com.commercial_website.Controllers;

import com.commercial_website.DTOs.InstallmentPlansDTO;
import com.commercial_website.Services.InstallmentPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/plans")
public class InstallmentPlansController {
    @Autowired
    private InstallmentPlansService installmentPlansService;

    @GetMapping
    public ResponseEntity<Set<InstallmentPlansDTO>> getAllInstallmentPlans() {
        return ResponseEntity.ok(installmentPlansService.getAllInstallmentPlans());
    }

    @GetMapping("{id}")
    public ResponseEntity<InstallmentPlansDTO> getInstallmentPlanById(@RequestBody Long id) {
        InstallmentPlansDTO getIP = installmentPlansService.getInstallmentPlans(id);
        return ResponseEntity.ok(getIP);
    }

    @PostMapping("/create")
    public ResponseEntity<InstallmentPlansDTO> createInstallmentPlan(@RequestBody InstallmentPlansDTO plans) {
        return ResponseEntity.ok(installmentPlansService.createInstallmentPlans(plans));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInstallmentPlan(@PathVariable Long id) {
        installmentPlansService.deleteInstallmentPlans(id);
        return ResponseEntity.ok("Installment plans deleted");
    }
}
