What technical debt has been cleaned up
========================================

### Paying off technical debts from Iteration 1 and 2:<br>

##### GUI BUGS :

The GUI was not working properly for some destinations in iteration 1. Though most of<br>the GUI was functional, certain destinations like the browse fragment, contained bugs. Also <br>since we had to deliver iteration 1 on time, some of the GUI which did not serve the main user <br>functionality was intentionally not implemented. This type of technical could be classified as <br>prudent deliberate. We took care of this debt in iteration 2 by taking the time to fix the <br>issues. Since we knew about the problem, and collectively decided not to fix it for iteration 1,<br> this would be a case of prudent, deliberate technical debt. <br>

These GUI bugs are fixed in the following commit:[GUI BUGS FIXES](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/commit/98c3c681ab56d14402ba71ca600686c960c816ee#2d28bd1352843bab11bb279036a731afa5774d55)<br>

##### EXCEPTIONS:

The exception handling was catching any type of exception before and it will return null when an exception actually occurs to easily check the return value for testing. It will also print a statement that just apply for a Null exception, but it doesn't actually handle that specific exception. This happened because we did not plan out our <br>development for the app, and did not code with test driven design and also exceptional code in mind. In the end, due to <br>time constraints, we quickly rushed to cover all of the tests we could think of near the due <br>date of the iteration. We handled the exceptions better in iteration 2. Since we first had no idea <br>about how to test exceptional code correctly, but learned about it after catching up with the lectures after handing <br>in our iteration, this was a case of prudent, inadvertent technical debt.<br>

We fixed the Exception test in the following commit:[Exception Test Fixed](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/blob/9b9a52420da77df70cc92bb39bd5e03ddb8dd7ac/app/src/test/java/com/example/myapplication/Logic/ExceptionsIT.java)

What technical debt did you leave?
==================================

We committed a deliberate prudent technical debt by not using Java Stream to simplify our Search Algorithm implementation. We decided to leave this debt because our Android Studio was having problems importing the Java Stream and we didn’t have enough time to figure it out. We made the intentional decision to leave our previous implementation as is to deliver the iteration on time, knowing that it could be simplified and improved.

Discuss a Feature or User Story that was cut/re-prioritized
============================================
We had a feature planned in iteration 2 for which we needed to create a button to allow the users to rate a store. One of our group members whom the feature was assigned to, dropped the course in the middle of iteration 2. This forced us to re-prioritize the feature and we pushed it further to be implemented in iteration 3.

[Link to the Feature](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/issues/6)

Acceptance test/end-to-end
==========================

We wrote an end-to-end test of at least 1 functionality for each feature. We tested adding an item to the grocery list, adding recipe’s ingredients to the grocery list directly, finding store options that match with the user’s grocery list, logging in, and rating a store. To make the test to be not flaky, we’re testing by using an input that we know exactly what the output is going to look like. Thus, we can be sure that we are going to pass the test if the system is processing our input correctly.

  

[Link to acceptance tests](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/tree/master/app/src/androidTest/java/comp3350/MyGroceryPal/myapplication)

Acceptance test, untestable
===============

One challenge we faced was setting up Espresso on Android Studio to run the acceptance tests. This was because the one in the sample project wouldn't work with the most recent version of Android Studio. Through some digging and trial and error, we were able to overcome this challenge and eventually got Espresso to work.

We didn't experience any untestable features.

Velocity/teamwork
=================

During the course, our group has become better and better at tracking the velocity of the project. At first, in iteration 1, the tracking time is quite off since for most of us this is the first time we worked with Android Studio. Additionally, most of us were first time Software Developers as well as mostly solo programmers, working as a team on a large project was a huge feat. As a result, for the first iteration, we were really bad at estimating the time we need to do different parts. Later on, evidenced from iteration 2 and 3, we became better at dividing and allocating work and communicating more efficiently. Though there were still some miscommunications, our group was well-oiled overall.

For instance, in iteration 1, we estimated the total time for the iteration to be approximately a combined three months worth of time but in reality it took only about a combined time of two months to finish the iteration.