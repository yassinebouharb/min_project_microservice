package com.example.stock.service;

import com.example.stock.dto.StockDTO;
import com.example.stock.entity.Stock;
import com.example.stock.mapper.StockMapper;
import com.example.stock.service.Stockrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private Stockrepository stockRepository;

    public List<StockDTO> findAll() {
        return stockRepository.findAll().stream()
                .map(StockMapper.INSTANCE::stockToStockDTO)
                .collect(Collectors.toList());
    }

    public StockDTO findById(String id) {
        return stockRepository.findById(id)
                .map(StockMapper.INSTANCE::stockToStockDTO)
                .orElse(null);
    }

    public StockDTO save(StockDTO stockDTO) {
        Stock stock = StockMapper.INSTANCE.stockDTOToStock(stockDTO);
        Stock savedStock = stockRepository.save(stock);
        return StockMapper.INSTANCE.stockToStockDTO(savedStock);
    }

    public void deleteById(String id) {
        stockRepository.deleteById(id);
    }
    public boolean checkStock(StockDTO stockDTO) {
        Stock stock = stockRepository.findByProductId(stockDTO.getProductId());
        return stock != null && stock.getQuantity() >= stockDTO.getQuantity();
    }

    public void updateStock(StockDTO stockDTO) {
        Stock stock = stockRepository.findByProductId(stockDTO.getProductId());
        if (stock != null) {
            int newQuantity = stock.getQuantity() - stockDTO.getQuantity();
            if (newQuantity < 0) {
                throw new RuntimeException("Insufficient stock available");
            }
            stock.setQuantity(newQuantity);
            stockRepository.save(stock);
        } else {
            throw new RuntimeException("Stock entry not found for product: " + stockDTO.getProductId());
        }
    }

}
