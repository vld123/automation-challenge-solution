#Feature: Create Person
#
#  Scenario: Create a new person successfully
#    Given Andres is on the Create Person form
#    When he fill the form with first name "Andres" last name "Peralta" age "35" and country "Argentina"
#    Then he should see a popup with legend "Person created successfully"
#
#  Scenario: Create a new person with an existing first name and last name
#    Given aUser is on the Create Person form
#    When he fill the form with first name "Andres" last name "Peralta" age "18" and country "Colombia"
#    Then he should see a popup with legend "An error occurred: person with same first name and last name already exists"
#
#  Scenario: Create a new person with no legal age
#    Given Maria is on the Create Person form
#    When she fill the form with first name "Maria" last name "Lopez" age "17" and country "Brazil"
#    Then she should see a popup with legend "An error occurred: user must be at least 18 years old"
#
#  Scenario Outline: Create a new person without a mandatory data
#    Given Pedro is on the Create Person form
#    When he fill the form with first name "<FIRST_NAME>" last name "<LAST_NAME>" age "<AGE>" and country "<COUNTRY>"
#    Then he should see a popup with legend "<MESSAGE>"
#
#    Examples:
#      | FIRST_NAME  | LAST_NAME   | AGE | COUNTRY   | MESSAGE |
#      | Pedro       |             | 34  | Brazil    | An error occurred: first name is required     |
#      |             | Dominguez   | 40  | Argentina | An error occurred: last name is required      |
#      | Pedro       | Dominguez   |     | Argentina | An error occurred: age is required            |
#      | Pedro       | Miranda     | 19  |           | An error occurred: you must select a country  |
#      |             |             |     |           | An error occurred: first name, last name, age and country are required |
## Existen otras combinaciones que por tratarse de un ejercicio no se plantean. Ejemplo: age and last name empties
#
#  Scenario Outline: Create a new person with invalid data
#    Given aUser is on the Create Person form
#    When she fill the form with first name "<FIRST_NAME>" last name "<LAST_NAME>" age "<AGE>" and country "<COUNTRY>"
#    Then she should see a popup with legend "<MESSAGE>"
#
#    Examples:
#      | FIRST_NAME  | LAST_NAME | AGE   | COUNTRY | MESSAGE |
#      | 11111       | Gomez     | 20    | Brazil  | An error occurred: first name is invalid  |
#      | Carolina    | 1111111   | 40    | Brazil  | An error occurred: last name is invalid   |
#      | Carolina    | Gomez     | -18   | Brazil  | An error occurred: age is invalid         |
#      | Carolina    | Diaz      | x     | Brazil  | An error occurred: age is invalid         |
