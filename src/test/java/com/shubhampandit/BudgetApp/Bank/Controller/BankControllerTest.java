package com.shubhampandit.BudgetApp.Bank.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubhampandit.BudgetApp.Bank.Dto.BankDto;
import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Service.BankService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BankController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class BankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankService bankService;

    @Autowired
    private ObjectMapper objectMapper;

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = Bank.builder()
                .id(100L)
                .name("HSBC")
                .type("current")
                .amount(1000L)
                .interestRate(0.0)
                .build();
    }

    @Test
    void BankController_getAllBank_verifySize() throws Exception {
        when(bankService.getAllBank()).thenReturn(Collections.singletonList(bank));
        ResultActions mockResult = mockMvc.perform(get("/api/v1/bank/").contentType(MediaType.APPLICATION_JSON));

        mockResult.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    void BankController_addBank_returnsCreatedBank() throws Exception {
        BankDto bankDto = BankDto.builder()
                        .name("HSBC").type("current").amount(1000L).interestRate(0.0).build();

        when(bankService.addBank(any())).thenReturn(bank);
        ResultActions mockResult = mockMvc.perform(post("/api/v1/bank/")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bankDto)));

        mockResult.andExpect(status().isCreated())
                .andExpect(content().string(objectMapper.writeValueAsString(bank)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateBank() {
    }

    @Test
    void deleteBank() {
    }
}