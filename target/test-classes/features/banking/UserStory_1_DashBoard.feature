✅ User Story:

As a bank customer, 
I want to view my dashboard with account balances, recent transactions, and financial summary 
so that I can quickly understand my financial status.

🔷 Business Value
Helps users track finances instantly
Improves user experience
Reduces need to navigate multiple pages
🔷 Acceptance Criteria (BDD Format)
🟢 Scenario 1: Dashboard Load

Given user is logged into NexaBank
When user navigates to dashboard
Then dashboard should load successfully
And user name should be displayed
And current date should be visible

🟢 Scenario 2: Total Balance Display

Given user has multiple accounts
When dashboard loads
Then total balance should be sum of all accounts
And currency should be displayed in ₹ format

🟢 Scenario 3: Credits & Debits

Given user has transactions
When dashboard is displayed
Then total credits should be shown in green
And total debits should be shown in red

🟢 Scenario 4: Recent Transactions

Given user has recent transactions
When dashboard loads
Then last 5 transactions should be displayed
And each transaction should show:

Name
Date
Amount
Status
🟢 Scenario 5: Account Summary

Given user has multiple accounts
When dashboard loads
Then all accounts should be listed
And each account should show balance

🟢 Scenario 6: Quick Transfer

Given user clicks "Quick Transfer"
When user initiates transfer
Then transfer page should open

