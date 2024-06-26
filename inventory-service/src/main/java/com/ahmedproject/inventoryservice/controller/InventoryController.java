package com.ahmedproject.inventoryservice.controller;

import com.ahmedproject.inventoryservice.dto.InventoryResponse;
import com.ahmedproject.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    //http://localhost:8082/api/inventory/iphone_13,iphone_14
    //http://localhost:8082/api/inventory/skuCode=iphone_13&skuCode=iphone_14
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode ){
        return inventoryService.isInStock(skuCode);
    }
}
