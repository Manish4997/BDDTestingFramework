@WebScrapping
Feature: Webscrapping from Table and graphs

  @WorldPopulationGraph @parallel
  Scenario: User reads data from the graph from World Population site and stores it in Excel
    Given User navigates to World Population site
    Then User validates population data is displayed on hovering on the graph and user writes the data in an Excel Sheet
