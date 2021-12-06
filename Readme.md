# JChef
###### The pinnacle of cuisine technology

---

JChef is a program to help you organize and decide on dinner!

## Contents

* [Introduction](#introduction)
  * [Example Usage](#example-usage)
* [Installation](#installation)
  * [Requirements](#requirements)
* [How to Use](how-to-use) 
* [Development](#development)
  * [Local Setup](#local-setup)
* [Maintainers](#maintainers)

## Introduction

This project was created as part of the University of Toronto's CSC207 course project.

Can't think of a recipe?
Don't know if you have everything you need for your favorite dish?
Have no fear, JChef is here.

### Example Usage

For now, just run the main function within [`JChef.java`](app/src/main/java/JChef.java) or run the tests!

## Installation
The JChef application is open source and can be retrieved from the https://github.com/CSC207-UofT/course-project-gries-fan-club
repository.
### Requirements
The application currently requires the user to have android studios.

## How to Use
This application is a comprehensive, interactive cookbook. The user will open the app and will be presented with a UI offering a number of potential options.

**Fridge**

The user will be able to add ingredients that they have in real life to their virtual fridge by clicking the “add to fridge” button and inputting a string of the ingredient.

**Grocery list**

If there are items missing from their fridge that are needed for a recipe, the  user can add the ingredients to a “Grocery List” by pressing the button “add to grocery list”. This serves as a shopping list that is portable and efficient. Once the user gets the item they can automatically add the item to the Fridge and remove it from the Grocery list. The user can remove them from the grocery list all at once by clicking “Add All To Fridge”,  or one by one by using the “Add to Fridge” button.

**Recipes**

Once the user has added their available ingredients the user will be able to search the recipe list using a number of filters, the app will provide recipes based on the ingredients presented in their fridge.
Each recipe has a list of tags like “Gluten Free” that can be used to filter the recipes. The app will return the “best” recipes for the user to make. The user can click on a recipe to view it’s instructions and it’s ingredients.


## Development

The development of This application was for the purpose of a project in CSC207 at University of Toronto.
The project consisted of 3 phases, with each phase pushing further towards our final goals.

### Local Setup

Make sure you create a `local.properties` file in the root of the project. 

For Windows add the following line:
```
sdk.dir=C\:\\users\\username\\Appdata\\Local\\Android\\Sdk
```

For Mac add the following line: 
```
sdk.dir=/Users/username/Library/Android/sdk
```

Replacing `username` as appropriate.

## Maintainers

Current Maintainers:

* Derek Cresswell - [DerekCresswell](https://github.com/DerekCresswell)
* Ariel Chouminov - [arieldeveloper](https://github.com/arieldeveloper)
* Gerd Bizi - [gerd-bizi](https://github.com/gerd-bizi)
* Ezra Robens-Paradise - [ezrarp](https://github.com/ezrarp)
* Prithee Roy - [pritheeroy](https://github.com/pritheeroy)
* Ayush Sahi - [ayushsahi](https://github.com/ayushsahi)
