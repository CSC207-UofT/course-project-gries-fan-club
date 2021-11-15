# JChef Phase 1 Write Up

## Contents

* [Introduction](#introduction)
* [Updated Specification](#Updated Specification)
* [Class Diagram](#Class Diagram)
* [Major Design Decisions](#Major Design Decisions)
* [SOLID Design Principles](#SOLID Design Principles)
* [Clean Architecture](#Clean Architecture)
* [Packaging Strategies](#Packaging Strategies)
* [Design Patterns](#Design Patterns)
* [Progress report](#Progress report)

## Introduction

Intro here

## Updated Specification
- Serialization of entities (Specifically into JSON text)
- Implemented Use-Cases, commands, and response objects to drive code
- Began developing the Android front-end 


## Class Diagram

Class diagram here

## Major Design Decisions

Major design decisions here

## SOLID Design Principles
- Part of the clean architecture is that our high level, matchers, scorers, and middle level entities, storages, do not care about details such as data storage. 
- They do not depend on low-level modules (dependency inversion). Our interfaces are relatively small and single focused meaning that classes have single responsibilities and don't implement unnecessary behaviour. 
- On this, we also utilise interfaces from the Java standard library when possible (like writers and collections). 
-None of our subclasses are incompatible with their super classes (Liskov).


## Clean Architecture

clean architecture here

## Packaging Strategies

packaging strategies here

## Design Patterns

design patterns here

## Progress Report

progress report here
