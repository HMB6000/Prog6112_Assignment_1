# Programming 6112 Assignment 1

This repository contains two Java applications developed as part of Programming 6112 Assignment 1:

## 1. Budget App (SpendWise)

A Java application that helps users manage their budget and track spending. Features include:

- Budget validation to ensure spending doesn't exceed available funds
- Shopping list management with up to 5 items
- Item price validation against current amount and budget
- Financial summary including:
  - Total spent
  - Amount saved from budget
  - Updated current amount

### Key Features
- Inheritance-based design with `Budget` as base class and `ShoppingBudget` as derived class
- Input validation for budget and item prices
- Detailed financial reporting

## 2. TV Series Management Application (TVSMA)

A console-based application for managing TV series information. Features include:

- CRUD Operations:
  - Create: Add new TV series with ID, name, age restriction, and number of episodes
  - Read: Search for series by ID
  - Update: Modify series details
  - Delete: Remove series from the system

### Key Features
- Age restriction validation (2-18 years)
- Comprehensive error handling
- Detailed series reporting
- Interactive menu system
- Data persistence during runtime

### Technical Details
Both applications are developed in Java and demonstrate:
- Object-Oriented Programming principles
- Input validation and error handling
- User-friendly console interfaces
- ArrayList data structures (in TVSMA)
- Inheritance and encapsulation

## Usage

### Budget App
1. Enter your current amount
2. Set your budget (must be less than current amount)
3. Add items to your shopping list (up to 5 items)
4. View financial summary

### TVSMA
1. Launch the application
2. Choose from the following options:
   - Capture a new series
   - Search for a series
   - Update series age restriction
   - Delete a series
   - Print series report
   - Exit Application

## Author
Hlelo Maluleke

## Date
September 2025
