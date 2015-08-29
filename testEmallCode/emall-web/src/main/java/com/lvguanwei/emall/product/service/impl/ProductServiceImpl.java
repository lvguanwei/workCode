package com.lvguanwei.emall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvguanwei.emall.product.dao.ProductDOMapper;
import com.lvguanwei.emall.product.dao.model.ProductDO;
import com.lvguanwei.emall.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductDOMapper prodcutMapper;

    @Override
    public Integer addProduct(ProductDO product) {
        return prodcutMapper.insertSelective(product);
    }

}
