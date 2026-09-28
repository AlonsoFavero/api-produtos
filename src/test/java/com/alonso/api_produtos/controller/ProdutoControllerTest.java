package com.alonso.api_produtos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveListarProdutos() throws Exception {

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk());
    }

    @Test
    void deveCriarProduto() throws Exception{

        mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content("{\"nome\":\"Mouse\",\"preco\":100,\"quantidade\":5}")

                )
                .andExpect(
                        status().isCreated()
                );
    }
}