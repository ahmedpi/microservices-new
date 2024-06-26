package com.ahmedproject.inventoryservice.service;

import com.ahmedproject.inventoryservice.dto.InventoryResponse;
import com.ahmedproject.inventoryservice.model.Inventory;
import com.ahmedproject.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes){
        List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCodes);

        return inventoryList.stream()
                .map(inventory ->
                    InventoryResponse.builder().skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
