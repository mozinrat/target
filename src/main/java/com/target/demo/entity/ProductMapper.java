package com.target.demo.entity;

import com.target.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity toProductEntity(Product product);

    ProductEntity.PriceEntity map(Product.Price value);

    @Mapping(source = "name",target = "name")
    Product toProduct(ProductEntity productEntity,String name);

    Product.Price mapT(ProductEntity.PriceEntity priceEntity);
}