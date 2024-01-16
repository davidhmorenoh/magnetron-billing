package com.magnetron.billing.application.controllers;

import com.magnetron.billing.application.controllers.dtos.*;
import com.magnetron.billing.domain.services.ImplViewService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ViewControllerTest {

    @Mock
    private ImplViewService<ViewTotalBilledPerPersonDTO> totalBilledService;

    @Mock
    private ImplViewService<ViewPersonBuysMoreExpensiveProductDTO> personBuysMoreExpensiveService;

    @Mock
    private ImplViewService<ViewProductsByInvoicedQuantityDTO> productsByInvoicedQuantityService;

    @Mock
    private ImplViewService<ViewProductsByUtilityDTO> productsByUtilityService;

    @Mock
    private ImplViewService<ViewProductsWithProfitMarginDTO> productsWithProfitMarginService;

    @InjectMocks
    private ViewController viewController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTotalBilledPerPerson() {
        // Arrange
        List<ViewTotalBilledPerPersonDTO> mockList = new ArrayList<>();
        when(totalBilledService.getAll()).thenReturn(mockList);

        // Act
        ResponseEntity<List<ViewTotalBilledPerPersonDTO>> response = viewController.getAllTotalBilledPerPerson();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllPersonBuysMoreExpensiveProduct() {
        // Arrange
        List<ViewPersonBuysMoreExpensiveProductDTO> mockList = new ArrayList<>();
        when(personBuysMoreExpensiveService.getAll()).thenReturn(mockList);

        // Act
        ResponseEntity<List<ViewPersonBuysMoreExpensiveProductDTO>> response = viewController.getAllPersonBuysMoreExpensiveProduct();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllProductsByInvoicedQuantity() {
        // Arrange
        List<ViewProductsByInvoicedQuantityDTO> mockList = new ArrayList<>();
        when(productsByInvoicedQuantityService.getAll()).thenReturn(mockList);

        // Act
        ResponseEntity<List<ViewProductsByInvoicedQuantityDTO>> response = viewController.getAllProductsByInvoicedQuantity();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllProductsByUtility() {
        // Arrange
        List<ViewProductsByUtilityDTO> mockList = new ArrayList<>();
        when(productsByUtilityService.getAll()).thenReturn(mockList);

        // Act
        ResponseEntity<List<ViewProductsByUtilityDTO>> response = viewController.getAllProductsByUtility();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllProductsWithProfitMargin() {
        // Arrange
        List<ViewProductsWithProfitMarginDTO> mockList = new ArrayList<>();
        when(productsWithProfitMarginService.getAll()).thenReturn(mockList);

        // Act
        ResponseEntity<List<ViewProductsWithProfitMarginDTO>> response = viewController.getAllProductsWithProfitMargin();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

}