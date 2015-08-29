package com.lvguanwei.emall.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvguanwei.emall.product.dao.model.ProductDO;
import com.lvguanwei.emall.product.service.ProductService;

@Controller
@RequestMapping("/rest/product")
public class ProductAction {
    private static final Log    logger  = LogFactory.getLog(ProductAction.class);
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value="/add")
    public @ResponseBody Object add( Model model,HttpServletRequest request,HttpServletResponse response,ProductDO product){
        
        try{
            Integer productId = productService.addProduct(product);
            if(productId == null ){
                model.addAttribute("result", "error");
            }else{
                model.addAttribute("result", "ok");
            }
            
        }catch(Exception e){
            model.addAttribute("result", "error");
            logger.error("product add error :errorInfo="+e.getMessage(), e);
        }
        return model;
    }

}
