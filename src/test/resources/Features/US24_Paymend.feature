Feature: US_24 Payment

Background: User logs in and add an item to the shopping cart
* User makes driver adjustments
* User clicks the button with description "Profile"
* User clicks the button with description "Sign In"
* As a user muss be "phoneNumber" phone and "password" password Login
* User adds an item to shopping card and goes to the shopping card.
* User clicks the button with description "Proceed to Checkout"
* User selects an address for shipping.
* User clicks the button with description "Save & Pay"


@24
Scenario: Testing that card information form of Stripe Payment Method could be filled and payment could be made
  * User verifies the "Stripe" button is viewable and clickable
  * User clicks the button with description "Confirm Order"
  * User fills card informations and clicks the confirm button