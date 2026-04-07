Feature: Transaction History

  Background:
    Given user is logged into "NexaBank"
    And user is on "Dashboard"
    When user clicks on "Transactions"
    Then user should be navigated to "Transaction History Page"

  Scenario: View all transactions
    Then user should see list of transactions
    And each transaction should display "Date, Description, Account, Amount, Status"

  Scenario: Validate transaction type (Credit/Debit)
    Then credit transactions should be displayed in green with "+"
    And debit transactions should be displayed in red with "-"

  Scenario: Search transactions
    When user enters "ATM Withdrawal" in "Search Transactions"
    Then user should see only matching transactions

  Scenario: Filter by transaction type
    When user selects "Credit" from "All Types"
    Then only credit transactions should be displayed

  Scenario: Filter by status
    When user selects "Completed" from "All Status"
    Then only completed transactions should be displayed

  Scenario: Filter by account
    When user selects account "NEXA00001001" from "All Accounts"
    Then transactions of selected account should be displayed

  Scenario: Validate transaction status
    Then transactions should display status as "Completed" or "Pending"

  Scenario: Validate default sorting
    Then latest transactions should appear at the top