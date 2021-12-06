# JChef Progress Report

Throughout the development of JChef we encountered many obstacles, of which we’ve worked hard to overcome. However, as mentioned earlier, there are many questions our group addressed in Phase 2. This includes addressing:
- Managing the file structure to correct the build errors. This will help us:
    - Connect the backend to the Android GUI to make the application holistically functional
    - Create a more robust testing system to ensure the application works as intended
    - Allow us to address all IntelliJ warnings and style concerns

In spite of the aforementioned concerns, we believe JChef’s current design to be effective for a multitude of reasons.

Because we followed clean architecture and the SOLID principles, as mentioned before, our codebase is easy to understand and led to good stratification in terms of levels. Our compartmentalized code base is conducive to scalability and the implementation of new features. As well, general maintenance was easy.

For instance, consider our Recipe Items: This class was turned into two different subclasses in Phase 1, but it didn't affect the rest of the code base as the implementation was done using the same interface.

These principles will allow us to address the shortcomings in Phase 1. This was then changed in phase 2 again to decorator design pattern.

**Regarding Phase 2 Contributions:**
- Ariel: Refactored the use cases, refactored the responseImpl class and create the controllers.
    - significant PR :
- Ayush: Worked on the Android GUI redesigning some components and hooking it up to the back end.
    - significant PR:
- Derek: Did a lot of general work reviewing code and looking at the architecture of the program. The accessibility Documents.
    - significant PR:
- Ezra: The Design Doc and the Presentation. Helped Ariel with the use cases, created the presentation.
    - significant PR:
- Gerd: created a decorator design pattern for the recipeItem, refactored a large amount of concluding the matchers and scored and all the associated tests we remade. He also fixed the builders.
    - significant PR:
- Prithee: Worked on the Android GUI redesigning some components and hooking it up to the back end, added the Grocery list use case.
    - significant PR

**Reflection Moving Forward:**
* Having an API connected to our application with lists of recipes and ingredients
* We wish we could have added photos to our recipes
* We wish we could have implemented our Tinder like function for the application when searching for recipes. 
