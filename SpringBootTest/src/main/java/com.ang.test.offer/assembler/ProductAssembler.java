package com.ang.test.offer.assembler;

import com.ang.test.offer.domain.Product;
import com.ang.test.offer.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductAssembler extends ResourceAssembler<ProductDTO, Product> {

    private ModelMapper modelMapper;

    public ProductAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO toResource(Product o) {
        return modelMapper.map(o, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> toResourceList(Iterable<Product> l) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        l.forEach(o -> productDTOList.add(toResource(o)));
        return productDTOList;
    }

    @Override
    public Product toResourceInverse(ProductDTO o) {
        return modelMapper.map(o, Product.class);
    }

    @Override
    public List<Product> toResourceInverse(Iterable<ProductDTO> l) {
        List<Product> productList = new ArrayList<>();
        l.forEach(o -> productList.add(toResourceInverse(o)));
        return productList;
    }
}
