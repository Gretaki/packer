# Packer application

## Overview
The Packer Application helps to compile a list of items to take to your hiking trip based 
on its distance and duration.

## Required technologies:
- Java 21

## Running
Run in command line:  
```shell
./mvnw spring-boot:run
```
Example URL: 
- http://localhost:8080/packer/?lengthInKm=10&season=SPRING
- http://localhost:8080/packer/?lengthInKm=70&season=SUMMER&nights=1

## Architecture overview:
Main business logic is in ItemCalculator class. It loads all predefined items from ItemRepository
which is set up to use H2 database. Data is automatically inserted into database on app startup 
from `resources/data.sql` file. Items are scaled by either distance or number of nights spent in 
the hike. Items can also be "must have" (e.g. first aid kit) and have a maximum amount.

## To do later:
- Deletion of items
- Addition of items
- Trip types (Hiking, Skiing, etc.)
- Weight of the items and logic around it
- Conditions of hiking (mountain/ swamp/ etc.)
- Third party integration for weather forecast
