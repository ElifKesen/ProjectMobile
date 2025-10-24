Feature: Forgot password
  Background: User opens the app
    * User makes driver adjustments
    @06
  Scenario: Forgot password test
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    When User clicks the button with description "Forgot Password"
    Then Verifies that the text "Forgot Password" is displayed on the screen
    Then Verifies that the text "Back to sign in" is displayed on the screen
    When User enters phone number "9988776655" into the phone number textbox
    When User clicks the button with description "Get OTP"
    When User enters "Wise123*" into both the New Password and Confirm Password textboxes
    When User clicks the button with description "Submit"
    When User clicks the button with description "Profile"
    Then Verifies that the username "elif" is displayed on the screen
    Then Driver turns off