package com.example.stock.controller;

import com.example.stock.dto.StockDTO;
import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<StockDTO> getAllStocks() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public StockDTO getStockById(@PathVariable String id) {
        return stockService.findById(id);
    }

    @PostMapping
    public StockDTO createStock(@RequestBody StockDTO stockDTO) {
        return stockService.save(stockDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable String id) {
        stockService.deleteById(id);
    }
    @PostMapping("/checkStock")
    public boolean checkStock(@RequestBody StockDTO stockDTO) {
        return stockService.checkStock(stockDTO);
    }

    @PutMapping("/updateStock")
    public void updateStock(@RequestBody StockDTO stockDTO) {
        stockService.updateStock(stockDTO);
    }
}
