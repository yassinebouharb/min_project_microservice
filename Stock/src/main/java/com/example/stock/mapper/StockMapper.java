package com.example.stock.mapper;

import com.example.stock.dto.StockDTO;
import com.example.stock.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    StockDTO stockToStockDTO(Stock stock);

    Stock stockDTOToStock(StockDTO stockDTO);
}
