Feature:To login into Banking Applicaton
Scenario Outline:Login functionality with valid username and password

When user is on "LoginPage"
Then user enters text into textbox "userEmail" "john.doe@nexabank.com"
And user enters text into textbox "userPassword" "Password123!"
And user clicks "LoginButton"
Then validate title should be "NexaBank — Modern Banking"

When user is on "DashBoard"
Then last 6 transactions should be displayed
And validate "nameUnderTransaction" is present in each transaction
And validate "dateUnderTransaction" is present in each transaction
And validate "amountUnderTransactionCredit" is present in each transaction
And validate "amountUnderTransactionDebited" is present in each transaction
And validate "statusUnderTransaction" is present in each transaction
