package com.jyj.saller.service;

import com.jyj.api.ProductRpc;
import com.jyj.api.domain.ProductRpcReq;
import com.jyj.entity.Product;
import com.jyj.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品相关服务
 */
@Service
public class ProductRpcService {

    private static Logger logger = LoggerFactory.getLogger(ProductRpcService.class);

    @Autowired
    private ProductRpc productRpc;

    /**
     * 查询全部产品
     *
     * @return
     */
    public List<Product> findAll() {
        ProductRpcReq req = new ProductRpcReq();
        List<String> status = new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());
        Pageable pageable = new PageRequest(0, 1000, Sort.Direction.DESC, "rewardRate");
        req.setStatusList(status);
        req.setPageable(pageable);
        logger.info("rpc查询全部产品，请求：{}", req);
        Page<Product> result = productRpc.query(req);
        logger.info("rpc查询全部产品，结果：{}", result);
        return result.getContent();
    }

    @PostConstruct
    public void testFindAll(){
        findAll();
    }
}
