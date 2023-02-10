package com.shubhampandit.budgetapp.expense.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.expense.dto.ExpenseDto;
import com.shubhampandit.budgetapp.expense.model.Expense;
import com.shubhampandit.budgetapp.expense.service.ExpenseService;
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

import java.util.Calendar;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExpenseController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void ExpenseController_getAllExpense() throws Exception {
        Bank bank = Bank.builder()
                .id(100L).name("HSBC").type("current").amount(1000L).interestRate(0.0).build();
        Expense expense = Expense.builder()
                .id(100L).name("Food").type("variable").amount(100L).bank(bank).date(Calendar.getInstance().getTime()).build();

        when(expenseService.getAllExpense()).thenReturn(Collections.singletonList(expense));
        ResultActions mockResult = mockMvc.perform(get("/api/v1/expense/")
                .contentType(MediaType.APPLICATION_JSON));

        mockResult.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    void ExpenseController_addExpense() throws Exception {
        ExpenseDto expenseDto = ExpenseDto.builder()
                .name("Food").type("variable").amount(100L).bankName("HSBC").date(Calendar.getInstance().getTime()).build();

        ResultActions mockResult = mockMvc.perform(post("/api/v1/expense/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expenseDto)));

        mockResult.andExpect(status().isCreated());
        verify(expenseService).addExpense(expenseDto);
    }
}