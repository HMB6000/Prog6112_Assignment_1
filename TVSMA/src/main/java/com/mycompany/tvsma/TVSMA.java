/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tvsma;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hmalu
 */
// Class to represent a TV series
class SeriesModel {
    // Public fields for series information
    public int seriesId;
    public String seriesName;
    public int seriesAge;
    public int seriesNumberOfEpisodes;
    
    // Constructor to create a new series
    public SeriesModel(int seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
    
    // Display series information as a string
    @Override
    public String toString() {
        return "Series ID: " + seriesId + 
               ", Name: " + seriesName + 
               ", Age Restriction: " + seriesAge + 
               ", Episodes: " + seriesNumberOfEpisodes;
    }
}

// Main TV Series Management Application class
public class TVSMA {
    // Store all series in an ArrayList
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    // Scanner to read user input
    private static Scanner scanner = new Scanner(System.in);

    // Main method - program starts here
    public static void main(String[] args) {
        // Keep running until user chooses to exit
        while (true) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("*************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            
            // Get user's main choice
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer
            
            // If user doesn't enter 1, exit the program
            if (mainChoice != 1) {
                break;
            }
            
            // Show the main menu options
            menuItems();
        }
        
        // Close the scanner when done
        scanner.close();
    }
    //Consulted claude for the menuItems method
    // Show the menu items and handle user choices
    private static void menuItems() {
        int choice;
        // Keep showing menu until user chooses to exit (option 6)
        do {
            mainMenu(); // Display menu options
            choice = userChoice(); // Get user's choice
            
            // Handle each menu option
            switch (choice) {
                case 1: captureSeries(); // Add new series
                 break;
                case 2: searchSeries(); // Search for a series
                 break;
                case 3: updateSeries(); // Update series information
                 break;
                case 4: deleteSeries(); // Delete a series
                 break;
                case 5: seriesReport(); // Print all series
                 break;
                case 6: exitSeriesApplication(); // Exit menu
                 break;
                default: System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add blank line for readability
        } while (choice != 6);
    }
    
    // Display the main menu options
    private static void mainMenu() {
        System.out.println("Please select one of the menu items: ");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction.");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");
    }
    
    // Get user's menu choice
    private static int userChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        return choice;
    }
    
    // Add a new series to the collection
    private static void captureSeries() {
        System.out.println("Capture a new series");
        System.out.println("**************************");
        
        // Get series details from user
        System.out.print("Enter the series id: ");
        int seriesId = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        
        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();
        // Consulted claude for age restriction validation
        // Get and validate age restriction
        int seriesAge;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            try {
                seriesAge = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                if (seriesAge >= 2 && seriesAge <= 18) {
                    break;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.println("Please re-enter the series age >>> ");
                }
            } catch (Exception e) {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.println("Please re-enter the series age >>> ");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        System.out.print("Enter the number of episodes for " + seriesName + ":");
        int seriesNumberOfEpisodes = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        
        // Create new series and add to list
        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
        seriesList.add(newSeries);
        System.out.println("Series processed successfully!!!");
    }
    
    // Search for a series by ID
    private static void searchSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series found. Please add series first.");
            return;
        }
        
        System.out.print("Enter the series id to search: ");
        int searchSeriesId = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        
        SeriesModel foundSeries = findSeriesId(searchSeriesId);
        if (foundSeries != null) {
            System.out.println("---------------------------------");
            System.out.println("SERIES ID: " + foundSeries.seriesId);
            System.out.println("SERIES NAME: " + foundSeries.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + foundSeries.seriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + foundSeries.seriesNumberOfEpisodes);
            System.out.println("---------------------------------");
        } else {
            System.out.println("---------------------------------");
            System.out.println("Series with ID " + searchSeriesId + " not found!");
            System.out.println("---------------------------------");
        }
    }
    
    // Update an existing series
    private static void updateSeries() {
        // Check if there are series to update
        if (seriesList.isEmpty()) {
            System.out.println("No series found. Please add series first.");
            return;
        }
        
        // Get series ID to update
        System.out.print("Enter the series id to update: ");
        int updateSeriesId = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        
        // Find the series to update
        SeriesModel seriesToUpdate = findSeriesId(updateSeriesId);
        if (seriesToUpdate != null) {
            // Update series name
            System.out.print("Enter the series name: ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                seriesToUpdate.seriesName = newName;
            }
            // Consulted claude for age restriction update
            // Update age restriction
            System.out.print("Enter the age restriction: ");
            while (true) {
                try {
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    if (newAge == -1) {
                        break;
                    } else if (newAge >= 2 && newAge <= 18) {
                        seriesToUpdate.seriesAge = newAge;
                        break;
                    } else {
                        System.out.println("You have entered a incorrect series age!!!");
                        System.out.println("Please re-enter the series age >>> ");
                    }
                } catch (Exception e) {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.println("Please re-enter the series age >>> ");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            // Consulted claude for try catch loop
            // Update number of episodes
            System.out.print("Enter the number of episodes: ");
            while (true) {
                try {
                    int newEpisodes = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    if (newEpisodes == -1) {
                        break;
                    } else if (newEpisodes > 0) {
                        seriesToUpdate.seriesNumberOfEpisodes = newEpisodes;
                        break;
                    } else {
                        System.out.print("Invalid number of episodes, Please re-enter the number of episodes: ");
                    }
                } catch (Exception e) {
                    System.out.print("You have entered a incorrect series age!!! ");
                    System.out.print("Please re-enter the series age >>> ");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            
            System.out.println("Series updated successfully!");
            System.out.println("Updated series details: " + seriesToUpdate);
        } else {
            System.out.println("Series with ID " + updateSeriesId + " not found.");
        }
    }
    
    // Delete a series from the collection
    private static void deleteSeries() {
         // Check if there are series to delete
        if (seriesList.isEmpty()) {
            System.out.println("No series found. Please add series first.");
            return;
        }
        
        // Get series ID to delete
        System.out.print("Enter the series id to delete: ");
        int deleteSeriesId = scanner.nextInt();
        scanner.nextLine();
        
        // Find the series to delete
        SeriesModel seriesToDelete = findSeriesId(deleteSeriesId);
        if (seriesToDelete != null) {
            System.out.println("Series to be deleted:");
            System.out.println(seriesToDelete);
            System.out.print("Are you sure you want to delete series " + deleteSeriesId + " from the system? (y) to delete. ");
            String confirmation = scanner.nextLine();
            
            // Confirm deletion
            if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
                seriesList.remove(seriesToDelete);
                System.out.println("---------------------------------");
                System.out.println("Series with Id: "+ deleteSeriesId +" WAS deleted!");
                System.out.println("---------------------------------");
            } else {
                System.out.println("Series deletion cancelled.");
            }
        } else {
            System.out.println("Series with ID " + deleteSeriesId + " not found.");
        }
    }
    
    // Print all series in the collection
    private static void seriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series found. Please add series first.");
            return;
        }
        
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("---------------------------------");
            System.out.println("SERIES ID: " + series.seriesId);
            System.out.println("SERIES NAME: " + series.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
            System.out.println("NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
            System.out.println("---------------------------------");
        }
    }
    
    // Find a series by its ID
    private static SeriesModel findSeriesId(int id) {
        // Look through all series to find matching ID
        for (SeriesModel series : seriesList) {
            if (series.seriesId == id) {
                return series; // Return found series
            }
        }
        return null; // Return null if not found
    }

    // Exit the TV Series Management Application
    private static void exitSeriesApplication() {
        System.out.println("Exiting the TV Series Management Application. Goodbye!");
        scanner.close(); // Close the scanner
        System.exit(0); // Exit the program
    }

    static void main(String args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}