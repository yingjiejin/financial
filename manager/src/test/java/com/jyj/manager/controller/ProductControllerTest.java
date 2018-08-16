package com.jyj.manager.controller;

import com.jyj.entity.Product;
import com.jyj.entity.enums.ProductStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {


    private static RestTemplate restTemplate = new RestTemplate();

    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    // 正常产品数据
    private static List<Product> normals = new ArrayList<>();

    @BeforeClass
    public static void init() {
        Product p1 = new Product("T001", "LH1", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10), BigDecimal.valueOf(1), BigDecimal.valueOf(3.42));
        Product p2 = new Product("T001", "LH2", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10), BigDecimal.valueOf(0), BigDecimal.valueOf(3.28));
        Product p3 = new Product("T001", "LH3", ProductStatus.AUDITING.name(), BigDecimal.valueOf(100), BigDecimal.valueOf(10), BigDecimal.valueOf(3.86));
        normals.add(p1);
        normals.add(p2);
        normals.add(p3);
    }

    @Test
    public void create() {
        normals.forEach(product -> {

        });
    }

    @Test
    public void findOne() {
    }

    @Test
    public void query() {
    }
}