package com.skillbox.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenValidIndex_thenReturnsFibonacciNumber() throws Exception {
        mockMvc.perform(get("/fibonacci/7"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.index", is(7)))
                .andExpect(jsonPath("$.value", is(13)));
    }

    @Test
    void whenInvalidIndex_thenReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/fibonacci/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Index should be greater or equal to 1"));
    }
}