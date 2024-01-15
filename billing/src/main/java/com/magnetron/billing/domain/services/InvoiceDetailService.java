package com.magnetron.billing.domain.services;

import com.magnetron.billing.domain.entities.InvoiceDetailEntity;
import com.magnetron.billing.infrastructure.adapters.repositories.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public List<InvoiceDetailEntity> getAllInvoiceDetailEntities() {
        return invoiceDetailRepository.findAll();
    }

    public Optional<InvoiceDetailEntity> getInvoiceDetailById(Long id) {
        return invoiceDetailRepository.findById(id);
    }

    public InvoiceDetailEntity createInvoiceDetail(InvoiceDetailEntity invoiceDetailEntity) {
        return invoiceDetailRepository.save(invoiceDetailEntity);
    }

    public InvoiceDetailEntity updateInvoiceDetail(Long id, InvoiceDetailEntity updatedInvoiceDetailEntity) {
        if (invoiceDetailRepository.existsById(id)) {
            updatedInvoiceDetailEntity.setId(id);
            return invoiceDetailRepository.save(updatedInvoiceDetailEntity);
        }
        return null;
    }

    public void deleteInvoiceDetail(Long id) {
        invoiceDetailRepository.deleteById(id);
    }

}