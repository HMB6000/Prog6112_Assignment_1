/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.budgetapp;

import java.util.Scanner;

/**
 *
 * @author hmalu
 */
// Consulted claude for inheritance
// Base class
class Budget {
    protected int currentAmount;
    protected int budgetAmount;
    protected int totalSpent;
    
    public Budget(int currentAmount, int budgetAmount) {
        this.currentAmount = currentAmount;
        this.budgetAmount = budgetAmount;
        this.totalSpent = 0;
    }
    
    // Method to validate budget doesn't exceed current amount
    public void validateBudget(Scanner scanner) {
        while (budgetAmount > currentAmount) {
            System.out.println("Budget amount cannot be higher than current amount.");
            System.out.print("Please enter the amount you want to spend (<= R" + currentAmount + "): R");
            budgetAmount = scanner.nextInt();
        }
    }
    
    // Method to calculate remaining budget
    public int calculateRemainingBudget() {
        if (totalSpent > budgetAmount) {
            System.out.println("You have exceeded the budget amount.");
            return 0;
        } else {
            int remainingAmount = budgetAmount - totalSpent;
            System.out.printf("Remaining Budget Amount: R%d%n", remainingAmount);
            return remainingAmount;
        }
    }
    
    // Method to calculate financial summary
    public void displayFinancialSummary() {
        int amountSaved = budgetAmount - totalSpent;
        int newCurrentAmount = currentAmount - totalSpent;
        
        System.out.println("\nFinancial Summary:");
        System.out.println("Total Spent: R" + totalSpent);
        System.out.println("Amount Saved from Budget: R" + amountSaved);
        System.out.println("New Current Amount: R" + newCurrentAmount);
    }
}

// Derived class
class ShoppingBudget extends Budget {
    private String[] itemNames;
    private int[] itemPrices;
    private int itemCount;
    private static final int MAX_ITEMS = 5;
    
    public ShoppingBudget(int currentAmount, int budgetAmount) {
        super(currentAmount, budgetAmount);
        this.itemNames = new String[100];
        this.itemPrices = new int[100];
        this.itemCount = 0;
    }
    
    // Method to add items to shopping list
    public void addItems(Scanner scanner) {
        char continueAdding = 'y';
        
        while (continueAdding == 'y' && itemCount < MAX_ITEMS) {
            System.out.print("Please enter the name of the item: ");
            itemNames[itemCount] = scanner.next();

            int price;
            do {
                System.out.print("Please enter the price of the item (R): ");
                price = scanner.nextInt();

                if (price > currentAmount) {
                    System.out.println("Item price cannot be higher than your current amount (R" + currentAmount + "). Try again.");
                } else if (price > budgetAmount) {
                    System.out.println("Item price cannot be higher than your budget amount (R" + budgetAmount + "). Try again.");
                } else if (totalSpent + price > budgetAmount) {
                    System.out.println("Adding this item would exceed your budget. Try a cheaper item.");
                } else {
                    break; // Valid price
                }
            } while (true);

            itemPrices[itemCount] = price;
            totalSpent += price;
            itemCount++;

            if (totalSpent >= budgetAmount || itemCount >= MAX_ITEMS) {
                break;
            }

            // Handle continue prompt
            System.out.print("Add another item? (y/n): ");
            String input = scanner.next().trim().toLowerCase();
            
            if (input.isEmpty()) {
                System.out.println("No input received. Cancelling item addition.");
                break;
            }
            
            continueAdding = input.charAt(0);
            
            if (continueAdding != 'y') {
                System.out.println("Cancelling item addition.");
                break;
            }
        }
    }
    
    // Method to display shopping list (overriding would be possible but not necessary here)
    public void displayShoppingList() {
        if (itemCount == 0) {
            System.out.println("\nNo items were added to your shopping list.");
            return;
        }
        
        System.out.println("\nShopping List:");
        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%d. %s - R%d%n", (i + 1), itemNames[i], itemPrices[i]);
        }
    }
    
    // Getter methods
    public int getItemCount() {
        return itemCount;
    }
    
    public int getTotalSpent() {
        return totalSpent;
    }
}

// Main application class
public class BudgetApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Spend Wise!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your current amount: R");
        int currAmount = scanner.nextInt();

        System.out.print("Please enter the amount you want to spend: R");
        int budgetAmount = scanner.nextInt();

        // Create ShoppingBudget object (inherits from Budget)
        ShoppingBudget shoppingBudget = new ShoppingBudget(currAmount, budgetAmount);
        
        // Use inherited method to validate budget
        shoppingBudget.validateBudget(scanner);
        
        // Use derived class method to add items
        shoppingBudget.addItems(scanner);
        
        // Use inherited method to calculate remaining budget
        int remainingBudget = shoppingBudget.calculateRemainingBudget();
        
        // Use derived class method to display shopping list
        shoppingBudget.displayShoppingList();
        
        // Use inherited method to display financial summary
        shoppingBudget.displayFinancialSummary();

        scanner.close();
    }
}
