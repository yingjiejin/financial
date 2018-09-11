package com.jyj.manager.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jyj.api.ProductRpc;
import com.jyj.api.domain.ProductRpcReq;
import com.jyj.entity.Product;
import com.jyj.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * rpc服务实现类
 */
@AutoJsonRpcServiceImpl
@Service
public class ProductRpcImpl implements ProductRpc {

    private static Logger LOG = LoggerFactory.getLogger(ProductRpcImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    public Page<Product> query(ProductRpcReq productRpcReq) {
        LOG.info("查询多个产品，请求：{}", productRpcReq);
        Page<Product> result = productService.query(productRpcReq.getIdList(), productRpcReq.getMinRewardRate(), productRpcReq.getMaxRewardRate(), productRpcReq.getStatusList(), productRpcReq.getPageable());
        LOG.info("查询多个产品，结果：{}", result);
        return result;
    }

    @Override
    public Product findOne(String id) {
        LOG.info("查询产品详情，请求：{}", id);
        Product result = productService.findOne(id);
        LOG.info("查询产品详情，结果：{}", result);
        return result;
    }
}
