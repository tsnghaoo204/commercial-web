package com.commercial_website.Services.Impl;

import com.commercial_website.DTOs.InstallmentPlansDTO;
import com.commercial_website.Entities.InstallmentPlans;
import com.commercial_website.Exception.ResourceNotFoundException;
import com.commercial_website.Mappers.InstallmentPlansMapper;
import com.commercial_website.Repositories.InstallmentPlansRepository;
import com.commercial_website.Services.InstallmentPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImplInstallmentPlansService implements InstallmentPlansService {
    @Autowired
    private InstallmentPlansRepository installmentPlansRepository;

    @Autowired
    private InstallmentPlansMapper mapper;

    @Override
    public InstallmentPlansDTO createInstallmentPlans(InstallmentPlansDTO installmentPlansDTO) {
        InstallmentPlans installmentPlans = mapper.mapToEntity(installmentPlansDTO);
        InstallmentPlans savedInstallmentPlans = installmentPlansRepository.save(installmentPlans);
        return mapper.mapToDTO(savedInstallmentPlans);
    }

    @Override
    public InstallmentPlansDTO getInstallmentPlans(Long installmentPlanId) {
        InstallmentPlans search = installmentPlansRepository.findById(installmentPlanId)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return mapper.mapToDTO(search);
    }

    @Override
    public Set<InstallmentPlansDTO> getAllInstallmentPlans() {
        return installmentPlansRepository.findAll().stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public void deleteInstallmentPlans(Long installmentPlanId) {
        installmentPlansRepository.deleteById(installmentPlanId);
    }

    @Override
    public InstallmentPlansDTO searchInstallmentPlans(String companyName) throws ResourceNotFoundException   {
        InstallmentPlans search = installmentPlansRepository.findByCompanyContaining(companyName);
        return mapper.mapToDTO(search);
    }

    @Override
    public InstallmentPlansDTO updateInstallmentPlans(Long id, InstallmentPlansDTO installmentPlansDTO) {

        InstallmentPlans installmentPlans = installmentPlansRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        installmentPlans.setInstallmentPrice(installmentPlansDTO.getInstallmentPrice());
        installmentPlans.setMonthlyInstallment(installmentPlansDTO.getMonthlyInstallment());
        installmentPlans.setCompany(installmentPlansDTO.getCompany());
        installmentPlans.setTerm(installmentPlansDTO.getTerm());
        installmentPlans.setDownPayment(installmentPlansDTO.getDownPayment());
        installmentPlans.setFlatInterestRate(installmentPlansDTO.getFlatInterestRate());
        installmentPlans.setRequiredDocuments(installmentPlansDTO.getRequiredDocuments());
        installmentPlans.setTotalPayment(installmentPlansDTO.getTotalPayment());
        InstallmentPlans savedInstallmentPlans = installmentPlansRepository.save(installmentPlans);

        return mapper.mapToDTO(savedInstallmentPlans);
    }
}
