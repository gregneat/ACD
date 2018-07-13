# Test Driven Development lab proof of concept

This lab contains an example of how test driven development could be used in a lab.

Requires the installation of JUnit and hamcrest, which can be found in the `labs/lib` directory. See the [README](https://github.com/gregneat/ACD/tree/processing/labs/lib) in that directory for installation instructions.

Running the test script in this directory will run the tests present in the CalculatorTest. As an example, CalculatorTest runs two tests, each which calls a method in the Calculator class and essentially makes sure that it works. This could be used in a variety of ways: the test cases in a lab could be provided as a test file instead of a verbal description, or the students could write the tests themselves. Changing the methods in Calculator.java will result in a failing test- try it out if you want.
