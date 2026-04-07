Feature:To login into Banking Applicaton
Scenario Outline:Login functionality with valid username and password

When user is on "LoginPage"
Then user enters text into textbox "userEmail" "john.doe@nexabank.com"
And user enters text into textbox "userPassword" "Password123!"
And user clicks "LoginButton"
Then validate title should be "NexaBank — Modern Banking"

Given user clicks "fundTransfer"
When user is on "FundTransferPage"
When select "Savings Account – NEXA00001001 (₹1,25,450.75)" under "fromAccount"
And select "Between My Accounts" under "transferType"
And select "Current Account – NEXA00001002" under "toAccount"
And user enters text into textbox "amountTransfer" 30000
And user clicks "transferNow"
Then validate "SuccessfullyTransferred" is present



