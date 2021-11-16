# JChef Phase 1 Write Up

## Contents

* [Introduction](#introduction)
* [Updated Specification](#updated-specification)
* [Class Diagram](#class-diagram)
* [Major Design Decisions](#major-design-decisions)
* [SOLID Design Principles](#SOLID-design-principles)
* [Clean Architecture](#clean-architecture)
* [Packaging Strategies](#packaging-strategies)
* [Design Patterns](#design-patterns)
* [Progress report](#progress-report)

## Introduction

During the production of JChef, our group was able to effectively apply our knowledge to modern design questions resulting in a strong demonstration of clean architecture. However, our achievement was not without challenge and compromise as we were not able to meet our ambitious goal of a fully-fledged full-stack application in Phase 1. Currently, JChef exists as a comprehensive functional backend separate from its intuitive Android GUI. Though we hoped to join the two, we were unable to do so due to the learning curve of working together as a group, Java, and Android (see progress report). In Phase 2, we hope to address this shortcoming (see progress report) and highlight our proficiency in software design. 

## Updated Specification

Main ideas:
*PRITHEE WILL FINISH THIS*
- Serialization of entities (Specifically into JSON text)
- Implemented Use-Cases, commands, and response objects to drive code
- Began developing the Android front-end 


## Class Diagram

Main ideas:
*PRITHEE WILL FINISH THIS*
- Part of the clean architecture is that our high level, matchers, scorers, and middle level entities, storages, do not care about details such as data storage. 
- They do not depend on low-level modules (dependency inversion). Our interfaces are relatively small and single focused meaning that classes have single responsibilities and don't implement unnecessary behaviour. 
- On this, we also utilise interfaces from the Java standard library when possible (like writers and collections). 
None of our subclasses are incompatible with their super classes (Liskov).


## Major Design Decisions

*PRITHEE WILL FINISH THIS*

## SOLID Design Principles
- Part of the clean architecture is that our high level, matchers, scorers, and middle level entities, storages, do not care about details such as data storage. 
- They do not depend on low-level modules (dependency inversion). Our interfaces are relatively small and single focused meaning that classes have single responsibilities and don't implement unnecessary behaviour. 
- On this, we also utilise interfaces from the Java standard library when possible (like writers and collections). 
-None of our subclasses are incompatible with their super classes (Liskov).


## Clean Architecture

Main ideas:
*PRITHEE WILL FINISH THIS*
Clean Architecture, we can talk about how these command/response classes keep use cases ignorant of the UI behind it. Entities are built through generic Row objects and loaders / writers to keep storage details away from our data. Matchers, scorers, only depend on interfaces for working on our data (such as the entity and storage interfaces). Make sure to look over class slides and use real terminology, don't just say something cause it sounds right.

## Packaging Strategies

Main ideas:
*PRITHEE WILL FINISH THIS*
we started with a strategy which was just everything grouped into related interfaces / functionality. This meant parts of the system that worked together may be far apart (IE entity builders and interfaces are separate). We have since changed to a more nested strategy to keep Components of the system grouped together. IE entities and builders, storages, loaders and writers. Look at slides and find the specific name of this strat

## Design Patterns

*PRITHEE WILL FINISH THIS*

## Progress Report

Throughout the development of JChef we encountered many obstacles, of which we’ve worked hard to overcome. However as mentioned earlier, there are many questions our group needs to address in Phase 2. This includes addressing:
- Managing the file structure to correct the build errors. This will help us:
    - Connect the backend to the Android GUI to make the application wholistically functional
    - Create a more robust testing system to ensure the application works as intended
    - Allow us to address all IntelliJ warnings and style concerns

Despite the aforementioned concerns, we believe JChef’s current design to be effective for many reasons. Because we followed clean architecture and the SOLID principles, our codebase is easy to understand and led to good stratification in terms of levels. Furthermore, our compartmentalized codebase is conducive to scalability, the implementation of new features, and general maintenance due to its design. The ease of scalability and maintenance can be seen by looking at the quantified recipe item discussed in Phase 0. This item was turned into two different implementations in Phase 1 but, it didn’t affect the rest of the code base as the implementation was done using the same interface, highlighting the effectiveness of our design. This adjustment is just one example of the principles we implemented which will allow us to address the shortcomings in Phase 1, resulting in easy testing and future expansion in Phase 2. 

Regarding Phase 1 Contributions:
- Ariel worked on … 
- Ayush worked on … 
- Derek worked on … 
- Ezra worked on …
- Gerd worked on …
- Prithee worked on …

Moving forward:
- Ariel will work on … 
- Ayush will work on … 
- Derek will work on … 
- Ezra will work on …
- Gerd will work on …
- Prithee will work on …

Though our group did not meet our goal we believe we displayed a strong understanding of software engineering and design principles. We hope to learn from our mistakes in Phase 1 to develop an even stronger display in Phase 2. 
