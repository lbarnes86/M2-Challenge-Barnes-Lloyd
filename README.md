# M2-Challenge-Month&Math-API

## Project Goal

The user will be able to use the REST web service to retrieve a random month, enter a number to retrieve the
correspoonding month name, and complete math problems and retrieve solutions using Postman.


## Usage

Donwload or fork repo and run app on http://localhost:8080/ Please see the Swagger API documentation for more info: https://github.com/lbarnes86/M2-Challenge-Barnes-Lloyd/blob/main/openapi.yaml

## User Story

```
As an API user, I would like to convert the number of any month to its corresponding text, e.g. "1" = "January".

As an API user, I would like to be able to request a randomly selected month.

As an API user, I would like to be able to add two numbers and receive back the result.

As an API user, I would like to be able to subtract two numbers and receive back the result.

As an API user, I would like to be able to multiply two numbers and receive back the result.

As an API user, I would like to be able to divide two numbers and receive back the result.
```

## Acceptance Criteria

```
WHEN I open the web application and enter randMonth ednpoint
THEN I am provided a random month
WHEN I enter a month number 
THEN I can GET the month name returned
WHEN I add two numbers in Postman
THEN I am presented with the sum.
WHEN I add subtract two numbers in Postman
THEN I am presented with the difference.
WHEN I multiply two numbers in Postman
THEN I am presented with the product.
WHEN I divide two numbers in Postman
THEN I am presented with the quotient.

```

