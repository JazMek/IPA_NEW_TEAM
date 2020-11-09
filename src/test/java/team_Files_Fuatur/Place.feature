Feature:validating a google map place API
  Scenario:Verify if a place is successfully added using addPlace API
    Given add place payload
    When  user calls "AddPlace" with "POST" http request
    Then  the API call got success with status code 200
#    And   "status" in response body is "OK"