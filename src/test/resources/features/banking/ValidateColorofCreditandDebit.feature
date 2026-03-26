Feature:To login into Banking Applicaton
Scenario Outline:Login functionality with valid username and password

When user is on "LoginPage"
Then user enters text into textbox "userEmail" "john.doe@nexabank.com"
And user enters text into textbox "userPassword" "Password123!"
And user clicks "LoginButton"
Then validate title should be "NexaBank — Modern Banking"

When user is on "DashBoard"
Then validate color of "creditColor" should be "green"
And validate color of "debitColor" should be "red"