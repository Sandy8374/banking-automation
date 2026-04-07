Feature:To login into Banking Applicaton
  Background:
    When user is on "LoginPage"
	Then user enters text into textbox "userEmail" "john.doe@nexabank.com"
	And user enters text into textbox "userPassword" "Password123!"
	And user clicks "LoginButton"
	Then validate title should be "NexaBank — Modern Banking"

  Scenario: Login functionality with valid username and password
	
	Given user clicks "fundTransfer"
	When user is on "FundTransferPage"
	When select "Savings Account – NEXA00001001 (₹1,25,450.75)" under "fromAccount"
	And select "Between My Accounts" under "transferType"
	And select "Current Account – NEXA00001002" under "toAccount"
	And user enters text into textbox "amountTransfer" 30000
	And user clicks "transferNow"
	Then validate "SuccessfullyTransferred" is present
	
	
  Scenario: Transfer fails with zero amount
	
	Given user clicks "fundTransfer"
	When user is on "FundTransferPage"
	When select "Savings Account – NEXA00001001 (₹1,25,450.75)" under "fromAccount"
	And select "Between My Accounts" under "transferType"
	And select "Current Account – NEXA00001002" under "toAccount"
	And user clicks "transferNow"
	Then validate "Enter a valid amount." is displayed
  Scenario: Transfer with insufficeint balance
    
    Given user clicks "fundTransfer"
    When user is on "FundTransferPage"
    When select "Savings Account – NEXA00001001 (₹1,25,450.75)" under "fromAccount"
	And select "Between My Accounts" under "transferType"
	And select "Current Account – NEXA00001002" under "toAccount"
	And user enters text into textbox "amountTransfer" 125453
	And user clicks "transferNow"
    Then validate "Insufficient balance. Available: ₹1,25,450.75" is displayed
    
  Scenario: same account transfer
    Given user clicks "fundTransfer"
    When user is on "FundTransferPage"
    When select "Savings Account – NEXA00001001 (₹1,25,450.75)" under "fromAccount"
	And select "Between My Accounts" under "transferType"
	And select "Savings Account – NEXA00001001" under "toAccount"
	And user enters text into textbox "amountTransfer" 1254
	And user clicks "transferNow"
    Then validate "Cannot transfer to the same account." is displayed
    
  @wip0110a
  Scenario: Transfer type changes
    Given user clicks "fundTransfer"
    When user is on "FundTransferPage"
    When select "Savings Account – NEXA00001001 (₹1,25,450.75)" under "fromAccount"
    And select "To Another Customer" under "transferType"
    And user enters text into textbox "recipientAccountNo" "NEXA00001003"
    And user enters text into textbox "recipientName" "Sandeep"
    And user enters text into textbox "ifscCode" "NEXA0000001"
    And user enters text into textbox "amountTransfer" 30
	And user clicks "transferNow"
	Then validate "SuccessfullyTransferred" is present
    



