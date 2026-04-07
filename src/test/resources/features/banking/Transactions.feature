Feature:To login into Banking Applicaton
Scenario Outline:Login functionality with valid username and password

When user is on "LoginPage"
Then user enters text into textbox "userEmail" "john.doe@nexabank.com"
And user enters text into textbox "userPassword" "Password123!"
And user clicks "LoginButton"
Then validate title should be "NexaBank — Modern Banking"

Given user clicks "transactionButton"
When user is on "TransactionsPage"
Then validate "Date" is present
Then validate "Description" is present
Then validate "Account" is present
Then validate "Amount" is present
Then validate "Status" is present
And all transactions should have correct color based on type "colorValidation"
When user enters text into textbox "searchTransactions" "ATM Withdrawal"
Then user should see only matching transactions