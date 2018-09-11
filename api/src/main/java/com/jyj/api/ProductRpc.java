package com.jyj.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.jyj.api.domain.ProductRpcReq;
import com.jyj.entity.Product;
import org.springframework.data.domain.Page;

/**
 * 产品相关的RPC服务
 */
@JsonRpcService("rpc/products")
public interface ProductRpc {

    /**
     * 查询多个产品
     *
     * @param productRpcReq
     * @return
     */
    Page<Product> query(ProductRpcReq productRpcReq);

    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    Product findOne(String id);
}
