#Feature: World View
#
#  Scenario: The View shows a group of people for each registered country
#    When aUser load the World view
#    Then he should see a Group for each country "Argentina,Brazil,Colombia,Uruguay"
#
#  Scenario: The View shows the data of a previously registered user
#    Given Carlos has registered in the Application with his first name "Carlos" last name "Marquez" age "25" and country "Uruguay"
#    When he load the World view
#    Then he should see the first name "Carlos" and last name "Marquez" in the group of "Uruguay"
#
#  Scenario: The View shows the data of Messi
#    When Mario load the World view
#    Then he should see the first name "Lionel Andres" and last name "Messi" in the group of "Argentina"
#
#  Scenario: One of the Country group is collapsed
#    When Maria load the World view
#    And she collapsed the Group of "Brazil"
#    Then she should not see the group of "Brazil" expanded
