Maven cucumber framework
-------------------------------
Build tool: Maven
Program language: java
Testing suite: selenium webDriver
Testing approach: BDD cucumber

note: point the JRE system librsry to installed jre path(jre 1.8 preferable)

Overview
-----------------------------------
This framework is a BDD driven automation test framework where the feature and scenarios are written 
in feature file available under /BBC_commentingTest/src/test/resources/functionalTest

Before run the framework a config file which is a property file contains test data and can be used as
a data provider which is available in the location /BBC_commentingTest/src/test/resources/ConfigFiles/config.properties.

The values will be reading in the class /BBC_commentingTest/src/test/java/fileReaders/ConfigFileReader.java
using corresponding methods.

To start the test always check the test data are provided in the file. (password provided in the file is encrypted).

Each scenario and its steps are implemented in step definition classes which are available in stepDefinitions.

TestRunner class in runners package will responsible for running the feature, the feature file as well as the
step definition package must be pointed in this class.

The test framework is designed in page object model for better readability and re usability. Utilised PageFactory
for the element initialisation and better synchronisation and each classes responsible for certain page objects 
are available in the package src/test/java/pageObjects.

A generic action class for implementing common and generic methods to be available and maintainable for better re usability.
This class can be developed to its extent to create most common methods to perform actions in selenium.
Available in the location /BBC_commentingTest/src/test/java/genericActions/GenaricActionMethods.java.


Prerequisite to run the framework
------------------------------------
1. System must be installed java jdk 18
2. Set environment variable for java path
3. System must be installed with maven binary
4. Set environment variable for maven

Steps to run via IDE
--------------------------
1. Copy project file in desired location
2. Import the project as a maven project from the location in Eclipse(Any IDE)
3. Update maven project by right click on pom.xml and select maven > update project
4. Run maven clean Install using right click on pom.xml and Run as > Maven clean, Maven Install
5. Run using the project using maven test by Run as > Maven test

Run the feature file using JUnit
----------------------------------
1. Navigate to feature file, go to src/test/resources > functionalTest> commentingTest.feature
2. Right click on feature file and Run as > Run configuration > JUnit Test

Run the test from command prompt
-------------------------------------
1. Change directory to project location
2. Run the command mvn test or mvn test –DCucumber.options="Your Options"
3. Run the cucumber feature from CLI java -cp <classpath> org.junit.runner.JUnitCore <class packagename>.<classname>

Result Target
--------------------------------------
1. Maven build will provide stack trace in the console as wells the JUnit console
2. An extensive and user experience report is available once after the test run
   in the location /BBC_commentingTest/target/cucumber-reports/report.html
   
   In this report user can easy to read the feature test result by knowing the result of each
   scenarios and its steps. pass/fail is denoted to indicate the result.
   
3. Failed cases will manage to capture the screenshot once after the assertion failed or exceptions occured.
