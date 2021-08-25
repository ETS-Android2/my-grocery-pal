Iteration 1 Worksheet
=====================

Adding a feature
-----------------
[Feature: Find where to buy an item](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/issues/1)
<br />
Firstly, we branch off of master to start implementing the feature and then we created a class called searchAlgorithm,<br /> which launches the method to find the combination of stores to shop at for the provided grocery list. This is an <br />implementation for the “Find all the available options to shop at” user story. To help the searchAlgorithm, two classes <br />were created, namely ShopOption and OptionBundle. One of them keeps the reference to a store and a ref to the grocery <br />item, while the latter of them stores an arrayList of Shop options. This will help us to achieve the “View results <br />quickly” user story. Every change being made to these implementations got added to the branch with a meaningful commit <br />message. Finally, we merge the searchAlgorithm with the master branch when the members have reviewed our code and we   <br />ensure that the implementation is working correctly.
<br />
[Related User Stories](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/issues?scope=all&utf8=%E2%9C%93&state=closed&label_name[]=Feature%231)
<br />
[Merge Request](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/merge_requests/12)
<br />
[Associated tests for finding where to buy an item feature](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/blob/master/app/src/test/java/com/example/myapplication/Logic/SearchAlgoTest.java)
<br />
[Merge commit to complete the feature](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/commit/92c93fb4427c660fa6424f6a7af96fd413973fa5)

Exceptional code
----------------

[Exceptional Code Testing](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/blob/MichaelGroceryList/app/src/test/java/com/example/myapplication/Logic/ExceptionTest.java) <br />

The code is modified in such a way that when a user tries to add, <br /> delete or update a NULL Object, it generates an exception, which is <br />handled by the try-catch block while printing an appropriate message. <br />


Branching
----------
[Branching Strategy](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/blob/master/README.md) <br />
![git](git.png)


SOLID
-----
[SOLID violation issue in Group 3](https://code.cs.umanitoba.ca/3350-winter-2021-a02/thrive/-/issues/20)


Agile Planning
--------------
Filtering the list of suggested stores by maximum distance and minimum review based on a parameter being passed from the  <br /> user were not implemented entirely. It is because we are going to show the list from the closest to the furthest <br />when a user chooses to filter by distance, and if they filter by review, the list is going to show from the       <br /> best-reviewed stores to the least-reviewed stores. However, the filtering idea based on a value might be carried 
<br />forward in the next iteration.
<br />
Changed/Pushed User Stories:
<br />
[Filter stores based on distance](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/issues/17)
<br />
[Filter stores based on reviews](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/issues/16)

