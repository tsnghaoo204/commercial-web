package com.commercial_website.Services;

import com.commercial_website.DTOs.InstallmentPlansDTO;

import java.util.Set;

public interface InstallmentPlansService {
    InstallmentPlansDTO createInstallmentPlans(InstallmentPlansDTO installmentPlansDTO);
    InstallmentPlansDTO getInstallmentPlans(Long installmentPlanId);
    Set<InstallmentPlansDTO> getAllInstallmentPlans();
    void deleteInstallmentPlans(Long installmentPlanId);
    InstallmentPlansDTO searchInstallmentPlans(String companyName);
    InstallmentPlansDTO updateInstallmentPlans(Long id ,InstallmentPlansDTO installmentPlansDTO);
}
