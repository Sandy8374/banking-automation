Feature:To login into Banking Applicaton
Scenario Outline:Login functionality with valid username and password

When user is on "LoginPage"
Then user enters text into textbox "userEmail" "john.doe@nexabank.com"
And user enters text into textbox "userPassword" "Password123!"
And user clicks "LoginButton"
Then validate title should be "NexaBank — Modern Banking"

Given user clicks "accountsButton"
When user is on "AccountsDashBoard"
Then validate total number of accounts under accounts dashboard
And select "Savings Account" under "accountType" 
And user enters text into textbox "initialDeposit" "100000"
And user clicks "openAccount"