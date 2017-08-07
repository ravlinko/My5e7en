Feature: Seven company test task requirements

  Background: application is up
    Given application is UP

  @success_flow @application @registering
  Scenario: anonymous should be able to register in application
    Given a registration page is opened
    And fill out form at registration page
      | firstName        | John                   |
      | lastName         | Kalem                  |
      | email            | jkalem@cherystreet.com |
      | phone            | 099 999 02 03          |
      | password         | jkalem                 |
      | passwordRepeated | jkalem                 |
    When click on sign up button
    Then the user is at login page
    And successful info pop-up is displayed with message
      """
      New user John Kalem has been created
      """

  @success_flow @application @registering
  Scenario: user should see registration data at his page
    Given a registration page is opened
    And fill out form at registration page
      | firstName        | Jeremy                  |
      | lastName         | Jonson                  |
      | email            | jjonson@cherystreet.com |
      | phone            | 099 999 02 04           |
      | password         | jjonson                 |
      | passwordRepeated | jjonson                 |
    And the user is at login page
    And click on sign up button
    And successful info pop-up is displayed with message
      """
      New user John Kalem has been created
      """
    And jjonson@cherystreet.com user is logging in with password jjonson
    When a dashboard page is opened
    And dashboard page contains
      | firstName | Jeremy                  |
      | lastName  | Jonson                  |
      | email     | jjonson@cherystreet.com |
      | phone     | 099 999 02 04           |


  @success_flow @condition0 @condition2 @admin @application
  Scenario: admin should have access to all tabs
    Given a login page is opened
    When admin user is logging in with password www
    Then a dashboard page is opened
    And navigation panel is available
    And there are available tabs
      | Companies |
      | Users     |
      | Reports   |

  @success_flow @condition1 @admin @user
  Scenario: available application security roles of user
    Given a login page is opened
    And admin user is logging in with password www
    When a create user page is opened
    Then user role selector is available
    And there are available roles
      | ADMIN            |
      | COMPANY_OWNER    |
      | COMPANY_EMPLOYER |

  @success_flow @condition2 @admin @companies
  Scenario: admin user should be able to create companies
    Given a login page is opened
    And admin user is logging in with password www
    And a company create page is opened
    And fill out form at company create page
      | name    | Green Garden inc.    |
      | email   | info@greengarden.com |
      | address | USA, NYC             |
    When click on company save button
    Then a companies page is opened
    # TODO: implement pop-ups
    And successful info pop-up is displayed with message
      """
      New company Green Garden inc. has been created
      """
    And companies table contains new company with name "Green Garden inc."

  @success_flow @condition2 @admin @users
  Scenario: admin user should be able to create users
    Given a login page is opened
    And admin user is logging in with password www
    And a create user page is opened
    And fill out form at create user page
      | firstName        | Derek              |
      | lastName         | Tailor             |
      | email            | dtailor@cherystreet.com |
      | phone            | 0999999999         |
      | password         | dpassword          |
      | passwordRepeated | dpassword          |
    When click on user save button
    Then a users page is opened
    And successful info pop-up is displayed with message
      """
      New user Derek Tailor has been created
      """
    And users table contains new user with email "dtailor@cherystreet.com"

  @success_flow @condition2 @admin @reports
  Scenario: admin user should be able to view companies reports
    Given a login page is opened
    And admin user is logging in with password www
    When a reports page is opened
    Then reports table contains reports with names
      | Red Dragon inc. 2017 May month report   |
      | Chery Street inc. 2017 May month report |

  @success_flow @condition2 @company_owner @application
  Scenario: company owner should have access to all tabs
    Given a login page is opened
    And jkelly@jkassistance.com user is logging in with password www
    Then a dashboard page is opened
    And navigation panel is available
    And there are available tabs
      | Companies |
      | Users     |
      | Reports   |

  @success_flow @condition2 @restriction1 @company_owner @company
  Scenario: company owner should be able to view his company
    Given a login page is opened
    And jkelly@jkassistance.com user is logging in with password www
    When a companies page is opened
    Then company JK Assistance inc. view page is opened
    And company edit button is present and active

#  @success_flow @condition2 @restriction1 @company_owner @company
#  Scenario: company owner should be able to edit his company
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And company JK Assistance inc. edit page is opened
#    And form is filled out as
#      | name    | JK Assistance inc.    |
#      | email   | info@jkassistance.com |
#      | address | GB, London            |
#    And enter address GB, Nottingham
#    When click on save button
#    Then company JK Assistance inc. view page is opened
#    And successful info pop-up is displayed with message
#      """
#      Company address of JK Assistance inc. has been changed
#      """
#    And company JK Assistance inc. view page with address GB, Nottingham
#
#  @success_flow @condition2 @restriction2 @company_owner @users
#  Scenario: company owner should be able to view his company employees
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And employees of JK Assistance inc. view page is opened
#    And employees table is
#      | Jane | Jonson | jjonson@jkassistance.com | 099 999 01 01 |
#      | Adel | Nemec  | anemecn@jkassistance.com | 099 999 01 02 |
#      | Kate | Rone   | krone@jkassistance.com   | 099 999 01 04 |
#    And user edit buttons are present and active
#    And user delete buttons are present and active
#    And user add button is present and active
#
#  @success_flow @condition2 @restriction2 @company_owner @users
#  Scenario: company owner should be able to view specific employee of his company
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And jjonson@jkassistance.com employee of JK Assistance inc. view page is opened
#    And employee view contains
#      | firstName | Jane                     |
#      | lastName  | Jonson                   |
#      | email     | jjonson@jkassistance.com |
#      | phone     | 099 999 01 01            |
#    And user edit buttons are present and active
#
#  @success_flow @condition2 @restriction2 @company_owner @users
#  Scenario: company owner should be able to edit specific employee of his company
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And jjonson@jkassistance.com employee of JK Assistance inc. edit page is opened
#    And form is filled out as
#      | firstName | Jane                     |
#      | lastName  | Jonson                   |
#      | email     | jjonson@jkassistance.com |
#      | phone     | 099 999 01 01            |
#    And enter phone 099 999 01 03
#    When click on save button
#    Then jjonson@jkassistance.com employee of JK Assistance inc. view page is opened
#    And successful info pop-up is displayed with message
#      """
#      Employee phone of Jane Jonson has been changed
#      """
#    And employee view contains
#      | firstName | Jane                     |
#      | lastName  | Jonson                   |
#      | email     | jjonson@jkassistance.com |
#      | phone     | 099 999 01 03            |
#
#  @success_flow @condition2 @restriction2 @company_owner @users
#  Scenario: company owner should be able to remove his company employees from table
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And employees of JK Assistance inc. view page is opened
#    And employees table is
#      | Jane | Jonson | jjonson@jkassistance.com | 099 999 01 03 |
#      | Adel | Nemec  | anemecn@jkassistance.com | 099 999 01 02 |
#      | Kate | Rone   | krone@jkassistance.com   | 099 999 01 04 |
#    And user edit buttons are present and active
#    And user delete buttons are present and active
#    And user add button is present and active
#    When click on delete button at jjonson@jkassistance.com employee
#    Then employees table is
#      | Adel | Nemec | anemecn@jkassistance.com | 099 999 01 02 |
#      | Kate | Rone  | krone@jkassistance.com   | 099 999 01 04 |
#
#  @success_flow @condition2 @restriction2 @company_owner @users
#  Scenario: company owner should be able to remove his company employee
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And anemecn@jkassistance.com employee of JK Assistance inc. edit page is opened
#    And user delete button is present and active
#    When click on delete button
#    Then a users page is opened
#    And employees table is
#      | Kate | Rone | krone@jkassistance.com | 099 999 01 04 |
#
#  @success_flow @condition2 @restriction2 @company_owner @users
#  Scenario: company owner should be able to add employee to his company
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And a user create page is opened
#    And fill out form at user create page
#      | firstName | John                      |
#      | lastName  | Spencer                   |
#      | email     | jspencer@jkassistance.com |
#      | phone     | 099 999 01 05             |
#    When click on save button
#    Then a users page is opened
#    And successful info pop-up is displayed with message
#      """
#      Employee John Spencer has been added
#      """
#    And employees table is
#      | John | Spencer | jspencer@jkassistance.com | 099 999 01 05 |
#      | Kate | Rone    | krone@jkassistance.com    | 099 999 01 04 |
#
#  @success_flow @condition2 @restriction3 @company_owner @reports
#  Scenario: company owner should be able to generate reports for his company
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And a reports page is opened
#    And report table is
#      | JK Assistance inc. daily report 0001 |
#    And generate report button is present and active
#    When click on generate report button
#    Then successful info pop-up is displayed with message
#    """
#      Report of JK Assistance inc. has been generated
#    """
#    And report table is
#      | JK Assistance inc. daily report 0001 |
#      | JK Assistance inc. daily report 0002 |
#
#  @success_flow @condition2 @restriction3 @company_owner @reports
#  Scenario: company owner should be able to view report of his company
#    Given a login page is opened
#    And jkelly@solidcircle.com user logged in with password jkelly
#    And a reports page is opened
#    When click on JK Assistance inc. daily report 0001 line
#    Then a report view page is opened
#    And report view contains
#      | name | JK Assistance inc. daily report 0001           |
#      | data | Company metrics did not get out of the limits. |
#
#  @success_flow @condition2 @company_employee @application
#  Scenario: company employee should have access to users and reports tabs
#    Given a login page is opened
#    And krone@jkassistance.com user logged in with password krone
#    Then a home page is opened
#    And navigation panel is available
#    And there are available tabs
#      | Users   |
#      | Reports |
#
#  @success_flow @condition2 @restriction1 @company_employee @users
#  Scenario: company employee should have access to view his own profile
#    Given a login page is opened
#    And krone@jkassistance.com user logged in with password krone
#    When a users page is opened
#    Then users page contains
#      | firstName | Kate                   |
#      | lastName  | Rone                   |
#      | email     | krone@jkassistance.com |
#      | phone     | 099 999 01 04          |
#    And edit button is present and active
#
#  @success_flow @condition2 @restriction1 @company_employee @users
#  Scenario: company employee should have access to edit his own profile
#    Given a login page is opened
#    And krone@jkassistance.com user logged in with password krone
#    And a users edit page is opened
#    And form is filled out as
#      | firstName | Kate                   |
#      | lastName  | Rone                   |
#      | email     | krone@jkassistance.com |
#      | phone     | 099 999 01 04          |
#    And enter phone 099 999 01 06
#    When click on save button
#    Then krone@jkassistance.com employee of Green Garden inc. view page is opened
#    And successful info pop-up is displayed with message
#      """
#      Employee phone of Kate Rone has been changed
#      """
#    And employee view contains
#      | firstName | Kate                   |
#      | lastName  | Rone                   |
#      | email     | krone@jkassistance.com |
#      | phone     | 099 999 01 06          |
#
#  @success_flow @condition2 @restriction2 @company_employee @reports
#  Scenario: company employee should be able to generate reports for his company
#    Given a login page is opened
#    And krone@jkassistance.com user logged in with password krone
#    And a reports page is opened
#    And report table is
#      | Green Garden inc. daily report 0001 |
#    And generate report button is present and active
#    When click on generate report button
#    Then successful info pop-up is displayed with message
#      """
#       Report of Green Garden inc. has been generated
#      """
#    And report table is
#      | Green Garden inc. daily report 0001 |
#      | Green Garden inc. daily report 0002 |
#
#  @success_flow @condition2 @restriction2 @company_employee @reports
#  Scenario: company employee should be able to view report of his company
#    Given a login page is opened
#    And krone@jkassistance.com user logged in with password krone
#    And a reports page is opened
#    When click on Green Garden inc. daily report 0001 line
#    Then a report view page is opened
#    And report view contains
#      | name | Green Garden inc. daily report 0001            |
#      | data | Company metrics did not get out of the limits. |