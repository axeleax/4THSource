# Offers App
Spring-Boot Test


**Please follow the instructions below. Once you have finished send an email to HR with the link of your forked repository to review your work.** <br>

## Install
Required Tools:
- Java 8
- Maven 3
- Any Java IDE

Install dependencies:<br>
`mvn install`

Run:<br>
`mvn spring-boot:run`

## Objective
A store committed with the environment has decided to stop publishing their offers through printed media. To do so,
they have implemented a digital flyer, published in the store's web page. As the new dev lead, your responsibility is
to complete the project and implement best practices whenever possible.

    - Currently, the active date filter is not working. When the active date filter is provided, 
      only offers active on that date should be displayed.
    - If the active date filter is not provided, show only offers active today.
    - Currently, the add and edit methods are not working correctly. Find the issues and fix them.
    - DTO classes lack of validation rules. Please ensure all required validation rulles get applied.
      You can find desired validation descriptions in the DTO classes.
    - Add a relationship from Prodct to Offers and ensure whenever a product gets deleted, all related offers 
      get also deleted. 
    - Throw a user friendly error message when an offer to be edited, contains a null ID.
    - Throw a user friendly error message when an offer to be edited, contains a null product ID.
    - The logic contained in the OfferService is too verbose and hard to maintain.
      Can you do something to improve it?
    - Please complete the delete offer service.

Feel free to include any library you need to make the code as clean as possible.

**Evaluation metrics**<br>

    - Readability
    - Solution
    - Maintainance
    - Performance
    - Error handling

**Nice to have**

    - Unit Tests

**If you have any question just send us an email**

