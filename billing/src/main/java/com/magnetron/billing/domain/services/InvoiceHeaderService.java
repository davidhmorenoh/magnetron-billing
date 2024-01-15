package com.magnetron.billing.domain.services;

import com.magnetron.billing.domain.entities.InvoiceHeaderEntity;
import com.magnetron.billing.infrastructure.adapters.repositories.InvoiceHeaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceHeaderService {

    private final InvoiceHeaderRepository invoiceHeaderRepository;

    public InvoiceHeaderService(InvoiceHeaderRepository invoiceHeaderRepository) {
        this.invoiceHeaderRepository = invoiceHeaderRepository;
    }

    public List<InvoiceHeaderEntity> getAllInvoiceHeaderEntities() {
        return invoiceHeaderRepository.findAll();
    }

    public Optional<InvoiceHeaderEntity> getInvoiceHeaderById(Long id) {
        return invoiceHeaderRepository.findById(id);
    }

    public InvoiceHeaderEntity createInvoiceHeader(InvoiceHeaderEntity invoiceHeaderEntity) {
        return invoiceHeaderRepository.save(invoiceHeaderEntity);
    }

    public InvoiceHeaderEntity updateInvoiceHeader(Long id, InvoiceHeaderEntity updatedInvoiceHeaderEntity) {
        if (invoiceHeaderRepository.existsById(id)) {
            updatedInvoiceHeaderEntity.setId(id);
            return invoiceHeaderRepository.save(updatedInvoiceHeaderEntity);
        }
        return null;
    }

    public void deleteInvoiceHeader(Long id) {
        invoiceHeaderRepository.deleteById(id);
    }

}