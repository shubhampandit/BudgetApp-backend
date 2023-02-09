package com.shubhampandit.budgetapp.income.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.income.dto.IncomeDto;
import com.shubhampandit.budgetapp.income.model.Income;
import com.shubhampandit.budgetapp.income.service.IncomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = IncomeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class IncomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IncomeService incomeService;

    @Autowired
    private ObjectMapper objectMapper;

    private Income income;

    @BeforeEach
    void setUp() {
        Bank bank = Bank.builder()
                .id(100L).name("Chase").type("saving").amount(1000L).interestRate(2.3).build();
        income = Income.builder()
                .id(100L).name("Salary").amount(1000L).bank(bank).build();
    }

    @Test
    void IncomeController_getAllIncome() throws Exception {
        when(incomeService.getAllIncome()).thenReturn(Collections.singletonList(income));
        ResultActions mockResult = mockMvc.perform(get("/api/v1/income/")
                .contentType(MediaType.APPLICATION_JSON));

        mockResult.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void IncomeController_addIncome() throws Exception {
        IncomeDto expectedIncomeDto = IncomeDto.builder()
                .name("Salary").amount(1000L).bankName("Chase").build();

        ResultActions mockResult = mockMvc.perform(post("/api/v1/income/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expectedIncomeDto)));

        ArgumentCaptor<IncomeDto> incomeDtoArgumentCaptor = ArgumentCaptor.forClass(IncomeDto.class);
        verify(incomeService).addIncome(incomeDtoArgumentCaptor.capture());
        IncomeDto actualIncomeDto = incomeDtoArgumentCaptor.getValue();
        assertThat(actualIncomeDto).isNotNull();
        assertThat(actualIncomeDto.getName()).isEqualTo(expectedIncomeDto.getName());
        mockResult.andExpect(status().isCreated());
    }
}