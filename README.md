# IS2545 - DELIVERABLE 2: Unit Testing

![build status](https://travis-ci.org/asphaltpanthers/CitySim9002.svg?branch=master)

___
##For Writing Codes
In order to faciliate test, all the methods would not includes to much components and methods. The clear input parameters and output results will provide code clearly and much eaier for reading. All methods should build more independently. It will improve the reusability of code. The clear relationship between each method could make code maintainable. The storage type of variables, especially for data with internal relation, will enhance the effectiency to retrieve or insert. 

##For Testing Codes
In the test process, the most difficulty thing is to understand how to use Double varibles. Sometimes, the test code will have error because of the NullPointerException or Wrong Matcher. The basic reason to lead to error is the confusion about doubles and stubs. In my test, the "testVisit", and "testVisitLocations" test method spent me much time to fix the errors. The common error is NullPointerException. The reason caused that problem is I used double class to place at the position which need the real data to computer.

##For Doubt
I still have question about how to conduct a test when the parameters of variable contains many other different classes. Or the structure of variable is complex. It is not eaier to instantiate a variable. And maybe the return value could be a list or something with high architecture. How could I judge the result?
