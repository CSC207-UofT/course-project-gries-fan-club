# JChef Phase 1 Write Up

## Contents

* [Introduction](#introduction)
* [Updated Specification](#updated specification)
* [Class Diagram](#class diagram)
* [Major Design Decisions](#major design decisions)
* [SOLID Design Principles](#SOLID Design Principles)
* [Clean Architecture](#Clean Architecture)
* [Packaging Strategies](#Packaging Strategies)
* [Design Patterns](#Design Patterns)
* [Progress report](#Progress report)

## Introduction

During the production of JChef, our group was able to effectively apply our knowledge to modern design questions resulting in a strong demonstration of clean architecture. However, our achievement was not without challenge and compromise as we were not able to meet our ambitious goal of a fully-fledged full-stack application in Phase 1. Currently, JChef exists as a comprehensive functional backend separate from its intuitive Android GUI. Though we hoped to join the two, we were unable to do so due to the learning curve of working together as a group, Java, and Android (see progress report). In Phase 2, we hope to address this shortcoming (see progress report) and highlight our proficiency in software design. 

## Updated Specification
- Serialization of entities (Specifically into JSON text)
- Implemented Use-Cases, commands, and response objects to drive code
- Began developing the Android front-end 


## Class Diagram

Prithee's work

## Major Design Decisions

Prithee's work

## SOLID Design Principles
- Part of the clean architecture is that our high level, matchers, scorers, and middle level entities, storages, do not care about details such as data storage. 
- They do not depend on low-level modules (dependency inversion). Our interfaces are relatively small and single focused meaning that classes have single responsibilities and don't implement unnecessary behaviour. 
- On this, we also utilise interfaces from the Java standard library when possible (like writers and collections). 
-None of our subclasses are incompatible with their super classes (Liskov).


## Clean Architecture

Prithee's work

## Packaging Strategies

Prithee's work

## Design Patterns

Prithee's work

## Progress Report

Throughout the development of JChef we encountered many obstacles, most of which we’ve worked hard to overcome. However as mentioned earlier, there are many questions our group needs to address in Phase 2. This includes addressing:
- Managing the file structure to correct the build errors. This will help us:
    - Connect the backend to the Android GUI to make the application wholistically functional
    - Create a more robust testing system to ensure the application works as intended
    - Allow us to address all IntelliJ warnings and style concerns
    
In spite of the aforementioned concerns, we believe JChef’s current design to be effective for a multitude of reasons. Because we followed clean architecture and the SOLID principles our codebase is easy to understand and led to good stratification in terms of levels. Our compartmentalized code base is conducive to scalability and the implementation of new features as well as general maintenance due to its design which can be seen by looking at the quantified recipe item discussed in Phase 0. This item was turned into two different implementations in Phase 1 but it didn’t affect the rest of the code base as the implementation was done using the same interface, highlighting the effectiveness of our design. These principles will allow us to address the shortcomings in Phase 1, resulting in easy testing and future expansion in Phase 2. 

Regarding Phase 1 Contributions:
Ariel worked on … 
Ayush worked on … 
Derek worked on … 
Ezra worked on …
Gerd worked on …
Prithee worked on…

Moving forward:
Ariel will work on … 
Ayush will work on … 
Derek will work on … 
Ezra will work on …
Gerd will work on …
Prithee will work on …

