/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.budgetapp;

import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hmalu
 */
public class BudgetTest {
    
    public BudgetTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of validateBudget method, of class Budget.
     */
    @Test
    public void testValidateBudget() {
        System.out.println("validateBudget");
        Scanner scanner = null;
        Budget instance = null;
        instance.validateBudget(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateRemainingBudget method, of class Budget.
     */
    @Test
    public void testCalculateRemainingBudget() {
        System.out.println("calculateRemainingBudget");
        Budget instance = null;
        int expResult = 0;
        int result = instance.calculateRemainingBudget();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFinancialSummary method, of class Budget.
     */
    @Test
    public void testDisplayFinancialSummary() {
        System.out.println("displayFinancialSummary");
        Budget instance = null;
        instance.displayFinancialSummary();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
