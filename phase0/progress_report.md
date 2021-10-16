#Progress Report

##Specification Review
Our project, JChef, is a sophisticated cook book program that allows users to maintain a record of the ingredients in their fridge and pantry to see what they can cook. Users are able to sort through recipes through filters such as recipes that they can make with food on hand, dietary restrictions, and food by reviews.

##CRC Model Review
We have the following entity classes:
The Item, Recipe, Ingredient, the Tag and their related classes are the entity classes. Then the Use Case Classes are the FridgeMatcher and the TagMatcher which both extend the AbstractMatcher abstract class. Then, a few controllers that we have include the FridgeStorage, the IngredientStorage, The ItemStorage, and so on. The Reader Classes are the Controllers. The JChef.java file is the BCI in this example. As per your conversation with Derek on October 14, this is tentative, and we have not fully implemented our CRC model into code yet.

##Scenario Walkthrough
The scenario walkthrough that we’ve created covers a scenario where the program automatically loads all its recipes into its storage, and then we try an example of the user searching for recipes by a certain dietary restriction tag. This demonstrates our program’s power to show recipes with respect to such tags.
For a lack of time, we have hardcoded examples of recipes into the driver class and the walkthrough behaves more along the lines of a proof of concept.

##Skeleton Program
The skeleton program is complete enough such that the user can interact with it and have mostly complete functionality. Due to issues that we had with implementing the Loader, we will demonstrate the functionality of the Walkthrough through hard coded examples and through test cases.

##Current Struggles
Our group was having a few issues with the organization of the CRC model. With such a complex project, and the need to adhere to SOLID principles and Uncle Bob’s Clean Architecture, we found ourselves making much more frequent use of Interfaces than in our previous experience. Derek and Ariel had a relatively easy time implementing the cards into classes after. However, Derek had some difficulty in implementing the Loader class so close to the deadline, and that functionality was pushed back to Phase 1. The coders also had some difficulties adhering to the DIP, as the dependency on objects from different levels was high and contracts could have been broken. Ariel remarked that it was at times confusing when referring to Entities’ interfaces or their implementations.
We found that it was slightly difficult at times to communicate within our group. Being in a group where so many of the members are incredibly busy makes it difficult for everyone to be on the same page all the time. We will strive to have meetings more frequently and delegate more precise tasks such that our group members can work more autonomously and without confusion.
Gerd, Derek and Ezra had some difficulties with the CRC cards as new models and cards kept being updated, which forced Ezra to keep updating his CRC dependency model, Derek to make new cards, and Gerd to adequately create a good walkthrough.

##What’s Working Well?
The code base, especially the high-level code is thorough, and will make it easy for us to build lower level classes, especially if we need to pivot while we progress into phase 2. We have through unit testing as well, as Ariel and Derek programmed with Test Driven Development in mind. They adhered to Clean Architecture’s core principles and the SOLID principles throughout their programming as well.
Ezra’s CRC dependency model made it easy for Gerd with Prithee and Ayush to make a thorough scenario. Additionally, Gerd made dependency charts in IntelliJ that made it very easy to see class interactions, along with preventing contract violation.

##Group Members’ Contributions
- Derek 
  - Was working on coding the Loader along with a temporary CLI. Helped create the CRC cards, and organized them into higher and lower levels. Plans on coding the Readers and Loaders.
- Ezra 
  - Created CRC cards and the dependency CRC model. Plans on updating the CRC model as more modes and a GUI is implemented in the future. 
- Ariel
  - Coded the high-level entities along with the Matcher. Provided Test Cases for his code. Will continue to code, potentially work on the aforementioned Tinder functionality. 
- Gerd 
  - Wrote the Progress Report, created the CRC Walkthrough Scenario with Ayush and Prithee. Plans to move into a stronger coding role, where he wants to spearhead the development of the GUI and implement broad functionality, such as shopping carts, multi-item adding to the cart, and the Tinder mode. 
- Ayush
  - Assisted with the CRC Walkthrough. Created thorough commenting and descriptions of the classes and methods. Will focus on implementing the Android app along with its GUI. 
- Prithee
  - Assisted with the CRC Walkthrough. Created thorough commenting and descriptions of the classes and methods. Will focus on implementing the Android app along with its GUI.
