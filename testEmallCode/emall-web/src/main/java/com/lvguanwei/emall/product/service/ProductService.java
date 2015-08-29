package com.lvguanwei.emall.product.service;

import com.lvguanwei.emall.product.dao.model.ProductDO;

public interface ProductService {
    
    /**
     * 添加产品信息
     * <p></p>
     * @author lvguanwei 2015年8月25日 下午7:27:11
     * @return
     */
    public Integer addProduct(ProductDO product);

}
