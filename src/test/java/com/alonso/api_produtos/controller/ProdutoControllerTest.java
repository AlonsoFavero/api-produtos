package com.alonso.api_produtos.controller;

import com.alonso.api_produtos.dto.ProdutoResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void deveListarProdutos() throws Exception {

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk());
    }

    @Test
    void deveCriarProduto() throws Exception {

        mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content("{\"nome\":\"Mouse\",\"preco\":100,\"quantidade\":5}")
        ).andExpect(
                status().isCreated()
        );
    }

    @Test
    void deveBuscarProdutoId() throws Exception {

        ResultActions resultado = mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content("{\"nome\":\"Mouse\",\"preco\":100,\"quantidade\":5}")
        );

        String resposta = resultado.andReturn()
                .getResponse()
                .getContentAsString();

        ProdutoResponseDTO produto =
                objectMapper.readValue(resposta, ProdutoResponseDTO.class);

        mockMvc.perform(
                get("/produtos/" + produto.getId())
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    void deveAtualizarProduto() throws Exception {

        ResultActions resultado = mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content("{\"nome\":\"Mouse\",\"preco\":100,\"quantidade\":5}")
        );

        String resposta = resultado.andReturn()
                .getResponse()
                .getContentAsString();

        ProdutoResponseDTO produto =
                objectMapper.readValue(resposta, ProdutoResponseDTO.class);

        mockMvc.perform(
                put("/produtos/" + produto.getId())
                        .contentType("application/json")
                        .content("{\"nome\":\"Teclado\",\"preco\":200,\"quantidade\":10}")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    void deveDeletarProduto() throws Exception {

        ResultActions resultado = mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content("{\"nome\":\"Mouse\",\"preco\":100,\"quantidade\":5}")
        );

        String resposta = resultado.andReturn()
                .getResponse()
                .getContentAsString();

        ProdutoResponseDTO produto =
                objectMapper.readValue(resposta, ProdutoResponseDTO.class);

        mockMvc.perform(
                delete("/produtos/" + produto.getId())
        ).andExpect(
                status().isNoContent()
        );
    }

    @Test
    void deveRetornar404AoBuscarProdutoInexistente() throws Exception{

        mockMvc.perform(
                get("/produtos/" + 9999)
        ).andExpect(
                status().isNotFound()
        );
    }

    @Test
    void deveRetornar400AoCriarProdutoSemNome() throws Exception{

        mockMvc.perform(
                post("/produtos")
                        .contentType("application/json")
                        .content("{\"preco\":100,\"quantidade\":5}")

        ).andExpect(
                status().isBadRequest()
        );
    }
}