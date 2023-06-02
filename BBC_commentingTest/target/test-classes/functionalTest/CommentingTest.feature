Feature: A signed in user can comment in articles in sports page

	Background:
	
				Given user is on Home Page
				
  Scenario: Verify a comment section is enabled for few articles in sports
				When he navigate to sports page
				Then verify few article has comment section enabled by validating comment icon
				
  Scenario: verify user is not able to comment in a section without sign in
				When he navigate to sports page
				And  click on an article with comment enabled
				And  click on view comments menu in article
				Then verify that user is not abled to comment in article without sign
				Then verify comment section has options for Sign in and Register
		
	Scenario: verify a signed in user is able to comment in an article
				When he navigate to sports page
				And  user click on sign in menu on header bar
				When user enter credentials and submit
				Then verify user is signed in successfully
				And  click on an article with comment enabled
				And  click on view comments menu in article
				Then verify sign in or register button is not displayed in comment section
				Then verify signed in user can add comments