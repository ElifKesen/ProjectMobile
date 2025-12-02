Feature: US_25 Return

  Background: User opens the app
    * User makes driver adjustments
  @25
  Scenario: TC01 Test to Verify the Visibility and Activity of the Return Request Button for Delivered Orders in the Dashboard Order History Page
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user muss be "phoneNumber" phone and "password" password Login
    * User clicks the button with description "Profile"
    * User clicks the button with description "Order History"
    * Select with description "Delivered"
    * User swipe to screen coordinates 700, 2400, 700, 400
    * Verifies that the username "Return Request" is displayed on the screen


