package com.magnetron.billing.application.controllers;

import com.magnetron.billing.application.controllers.dtos.*;
import com.magnetron.billing.domain.services.ImplViewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/views")
@AllArgsConstructor
public class ViewController {

    private final ImplViewService<ViewTotalBilledPerPersonDTO> viewTotalBilledPerPersonEntityImplViewService;
    private final ImplViewService<ViewPersonBuysMoreExpensiveProductDTO> viewPersonBuysMoreExpensiveProductDTOImplViewService;
    private final ImplViewService<ViewProductsByInvoicedQuantityDTO> viewProductsByInvoicedQuantityDTOImplViewService;
    private final ImplViewService<ViewProductsByUtilityDTO> viewProductsByUtilityDTOImplViewService;
    private final ImplViewService<ViewProductsWithProfitMarginDTO> viewProductsWithProfitMarginDTOImplViewService;

    @GetMapping("/total-billed-per-person")
    public ResponseEntity<List<ViewTotalBilledPerPersonDTO>> getAllTotalBilledPerPerson() {
        List<ViewTotalBilledPerPersonDTO> viewTotalBilledPerPersonDTOS = viewTotalBilledPerPersonEntityImplViewService.getAll();
        return new ResponseEntity<>(viewTotalBilledPerPersonDTOS, HttpStatus.OK);
    }

    @GetMapping("/person-buys-more-expensive-product")
    public ResponseEntity<List<ViewPersonBuysMoreExpensiveProductDTO>> getAllPersonBuysMoreExpensiveProduct() {
        List<ViewPersonBuysMoreExpensiveProductDTO> viewPersonBuysMoreExpensiveProductDTOS = viewPersonBuysMoreExpensiveProductDTOImplViewService.getAll();
        return new ResponseEntity<>(viewPersonBuysMoreExpensiveProductDTOS, HttpStatus.OK);
    }

    @GetMapping("/products-by-invoiced-quantity")
    public ResponseEntity<List<ViewProductsByInvoicedQuantityDTO>> getAllProductsByInvoicedQuantity() {
        List<ViewProductsByInvoicedQuantityDTO> viewProductsByInvoicedQuantityDTOS = viewProductsByInvoicedQuantityDTOImplViewService.getAll();
        return new ResponseEntity<>(viewProductsByInvoicedQuantityDTOS, HttpStatus.OK);
    }

    @GetMapping("/products-by-utility")
    public ResponseEntity<List<ViewProductsByUtilityDTO>> getAllProductsByUtility() {
        List<ViewProductsByUtilityDTO> viewProductsByUtilityDTOS = viewProductsByUtilityDTOImplViewService.getAll();
        return new ResponseEntity<>(viewProductsByUtilityDTOS, HttpStatus.OK);
    }

    @GetMapping("/products-with-profit-margin")
    public ResponseEntity<List<ViewProductsWithProfitMarginDTO>> getAllProductsWithProfitMargin() {
        List<ViewProductsWithProfitMarginDTO> viewProductsWithProfitMarginDTOS = viewProductsWithProfitMarginDTOImplViewService.getAll();
        return new ResponseEntity<>(viewProductsWithProfitMarginDTOS, HttpStatus.OK);
    }

}