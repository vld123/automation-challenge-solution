#Feature: Bff Application
#
#  Scenario: Check the Application is running OK
#    When the System sends a ping to check the Application is alive
#    Then it should get a http code 200 and the message "pong" with key "message"
#
#  Scenario: Get all the existing people in the application database
#    When the front-end queries the bff to get the list of people
#    Then it get a http code 200 and list non-empty
#
#  Scenario: Get all the existing countries in the application database
#    When the front-end queries the bff to get the list of countries
#    Then it should get a http code 200 and the number of expected countries should be 4
#
#  Scenario: Create a person successfully
#    When the front-end requests to the bff to add a new person with first name "Raul" last name "Rodriguez" age "34" and country id "1"
#    Then it should get a http code 201 and the person "id" not null
#
#  Scenario: Create a person with existing first name and last name should return an error code
#    When the front-end requests to the bff to add a new person with first name "Raul" last name "Rodriguez" age "18" and country id "2"
#    Then it should get a http code 400 and the message "person with same first name and last name already exists" with key "error"
#
#  Scenario Outline: Create a person with incomplete data should return an error code
#    When the front-end requests to the bff to add a new person with first name "<FIRST_NAME>" last name "<LAST_NAME>" age "<AGE>" and country id "<COUNTRY_ID>"
#    Then it should get a http code <HTTP_CODE>
#
#    Examples:
#      | FIRST_NAME  | LAST_NAME   | AGE | COUNTRY_ID  | HTTP_CODE |
#      | Julieta     |             | 34  | 3           | 400       |
#      |             | Dominguez   | 40  | 2           | 400       |
#      | Julieta     | Dominguez   |     | 1           | 400       |
#      | Julieta     | Perez       | 33  |             | 400       |
#
#  Scenario: Delete a person successfully
#    When the front-end requests to the bff to delete the person with id "5"
#    Then it should get a http code 204 and the message "Person deleted successfully" with key "message"
#
#  Scenario Outline: Delete a person with invalid id should return error code
#    When the front-end requests to the bff to delete the person with id "<ID>"
#    Then it should get a http code 400
#
#    Examples:
#      | ID |
#      | -1 |
#      |    |
