---
banner:
  enable: true
  bg_image: images/5084622_grocery-store-generic-img.jpg
  bg_overlay: true
  title: My Grocery Pal
  content: We take care of your groceries. Keep your grocery list and find stores options to buy them in one app!
  button:
    enable: false
    label: Discover Our Project
    link: project
about:
  enable: true
  title: Our Vision
  description: My Grocery Pal is an application that automates and innovates the grocery
    shopping experience by offering store options based on user needs.
  content: "Users provide their personal grocery list, and My Grocery Pal will quickly
    offer store options, enough to tailor any current user demand. These options can
    range from cheapest price, to closest location, or even to the best reviewed local
    stores.\n\n\nThe application will feature the ability to scroll through data about
    each option, allowing users to compare and contrast the pros and cons between
    different options. The data displayed within each option will be concise and filled
    with only enough information to allow for quick and efficient comparisons. Each
    option will contain information such as total price, distance, and reviews. With
    this knowledge at hand, users can freely choose an option that best satisfies
    their demands.\n\n\nUsers will be able to browse through many provided or user-created
    recipes. Any wanted recipes can then be selected, and a grocery list will be created
    seamlessly from the recipe’s ingredient list. Trying and experimenting with new
    recipes can now be done with ease. Through many complementary features like these,
    My Grocery Pal will be the go-to application for any grocery needs.\n\n\nThe importance
    of My Grocery Pal is to allow users to save not only money, but also the most
    valuable resource, their time. Shopping for groceries is an essential, time consuming
    chore for everyone. With \nMy Grocery Pal, the monotonous process of individually
    sifting through advantages and disadvantages of potential grocery choices will
    be automated and streamlined. A feature so desperately needed in our busy lifestyles.\n\n\nThis
    application is intended to be a mobile application with support for iOS and android
    devices. Future releases could support compatibility with MacOs and Windows.\n\n\nThe
    project will be considered a success based on two criteria. First, users will
    be allowed to submit their honest opinion about the application and will be able
    to provide ratings from 1 - 5 on the specifics of the application through an evaluation
    form, with 1 being the lowest rating, and 5 being the highest. Second, users will
    also have an option to give an overall rating on their respective app-store. If
    the average app rating is found to be 4 or greater, or if the average evaluation
    form rating is greater than 4, then the application will be considered a success."
  image: images/doc2-1.jpg
 

portfolio:
  enable: true
  bg_image: images/gettyimages-1158242033_4110232.jpg
  title: TARGET USERS
  content: My Grocery Pal is targeted for all people who buy groceries, including
    chefs of all ages and skill levels, with a main focus on those with a busy lifestyle.
    This includes but is not limited to, working individuals, students, and people
    with big families. The simple to use and automated functionality of My Grocery
    Pal accommodates those with busy lives. With one press of a button, users will
    be provided with a plethora of options to satisfy any current criteria one would
    require.
  button:
    enable: false
    label: View Works
    link: project
service:
  enable: true
  service_item: []
cta:
  enable: true
  bg_image: images/postmortembg.jpg
  title: POSTMORTEM
  content: "What was the overall architecture of your system (particularly if it is different from the demo system)?\nThe overall architecture of our system is the 3-tier     
    architecture, where we are separating the code into Presentation, Logic, and Data layers.\n\nWhat went right in the development process?\nOne thing that went right during
    the development process is that  our group communicated well with each other. We had a sufficient amount of meetings together and we all made sure we had a plan to 
    follow. Another thing is that we felt our code quality throughout the development process went smoothly. We all discussed together how the code would be divided (what 
    classes and functions to make), that when it came to combine our code, we did not go through too much trouble.\n\nWhat went wrong in the development process?\n
    We didn’t take into account the workload for each feature when we were planning which features we want to accomplish during each iteration, we were focusing on the 
    priority only. Due to having more workload in the first iterations and trying to finish all the features as soon as we can, we left more bugs during the first iterations 
    compared to the last ones.\n\nWhat would you do differently, if you had the chance to start over?\n
    All of us have learned so much from working together and doing this project, and if we ever had the chance to do it again we would apply what we learned from this 
    experience. One thing that caused us a lot of time was when we tried to merge our code together, but since there were a significant amount of changes in both codes, it 
    resolved a lot of merge conflicts. If we were ever going to do this another time, we would instead try to merge our code with each other after every little change. 
    Another thing would be that in the first iteration, we did not really focus too much on the developer tasks or user stories. However, when we did in iteration 2 is when 
    we realized how much these help us to stay organized and to clarify what everyone needs to do. One thing that we should have paid attention to more if we were a group 
    that would work with each other for a long time is our time estimates. We kept track of our time estimates for all iterations however we did not really pay attention to 
    make sure they were accurate. If we did we would have an easier time tracking our velocity and adjusted accordingly to make sure we set a more reasonable goal in what we 
    can complete.\n\nHow large is the project (number of methods, classes, etc)? How much of this is (roughly) devoted to each major system component? And any other 
    quantifiables (e.g. if you have a record of hours spent on tasks).\nThe project has around 70 classes, and 4 interfaces. About 30% of those are devoted to the database, 
    40% devoted to logic, and 30% devoted to the UI.
    \n\nWhat took the most time? The least? Any surprises?\n One thing that took up most of the time was 
    learning how new features work on Android Studio. For example, setting up the HSQLDB and to get it actually working took the most time because we were doing it for the 
    first time on Android Studio and the error messages were not as helpful. To code the Domain-specific Objects took the least time because we were all familiar with Java 
    and how an Object is working in Java.\n\nAre there any particular design smells, or brilliant design decisions?\nThere were some design smells such as we didn’t provide   
    an appropriate message to the user when there’s an invalid input or when the app couldn’t produce the expected result. Additionally, while we’re programming the project, 
    we’re following the Single Responsibility design principle, so we make each object or each logic as its own class. Thus, when we want to change something, we know exactly 
    which class that needs to be changed.
    \n\nAre there any outstanding bugs?\n
    There was a bug in which whenever we switch to a different activity, we couldn't access the database somehow. We couldn’t find the root of the problem for a while until  
    we fixed the place where we are setting up the databases, which is in the Main Activity.\n\nDid any features work better than expected?\nThe search algorithm to find the 
    store options that match the grocery list works better than expected because we were expecting that there will be some bugs related to it after iteration 1, but that 
    didn’t happen. And it also turns out that we can use it for the remaining iterations.
    \n\nAre you using any technologies 
    other than what was required (e.g. JMock, GUI builders, etc.)?\nNo, we are using required technologies only.\n\nAre you using any specific techniques covered in the 
    course (TDD, pair programming, scrums, etc)?\n
    We used pair programming techniques a lot for certain features. Some features that require a lot of effort were done by two people, where one person is writing the code 
    while sharing their screen and another person observes it.\n\nHow did the project change from your initial (iteration 0) vision or stories, or did it work out as 
    predicted?\n
    For the most part, we were able to complete our initial vision of making a grocery list app that can tell you which store combinations you can buy your items from. The 
    main features of our app are complete. However, there were some minor features we planned to do that we were not able to complete due to time constraints, such as making 
    your own recipe.\n\nWhat did you learn about team or large project development? What will you start doing, keep doing, or stop doing next time?\n
    Good planning is a key for completing quality works in a large project development. Getting everyone on the same page and being aware of their own responsibility is also 
    important to make sure that the distributed workload could be finished efficiently and effectively.\n\nCan you draw any conclusions from what you’ve done?\n
    Although our development process did work, there were still quite a few things we could have done to make it better."
  button:
    enable: false
    label: Tell Us Your Story
    link: contact
funfacts:
  enable: true
  title: About Us
  description: "We strive to be the best and make awesome work."
  funfact_item:
  - icon: ion-coffee
    name: Cups Of Coffee
    count: '99'
  - icon: ion-ios-compose-outline
    name: Features Completed
    count: '6'
  - icon: ion-ios-timer-outline
    name: Days of Work
    count: '56'
  testimonial_slider:
  - name: Capillar, Elieser
    image: images/eliavatar.jpg
    content: Throughout this project I learned quite a bit regarding the Android Studio documentation. Being in charge of the GUI, I had to read up on a lot of the 
      documentation in order to effectively and efficiently plan out the layout of the destinations. I gained valuable experience with some of the many facets of Android 
      Studio, a big one being Fragments and Navigation.
  - name: Goldiella, Wynona
    image: images/wynonaavatar.png
    content: I have learned a lot about test-driven development skills as I was in charge of most unit tests, 
      integration tests, and system tests in this project. I also improved my object-oriented programming skills
      while I was programming for the logic of the project as we had to practice the SOLID design principles.
  - name: Kapoor, Raghav
    image: images/raghavavatar.jpeg
    content: I learned how to distribute the construction of a software application into multiple layers using the different 
      software architectural design and patterns. I also honed my logic building skills as I mostly worked on the logic layer of the app development.
  - name: Le, Michael
    image: images/michaelavatar.png
    content: I learned how to divide and connect our code into different layers and how to store data in a persistent database. Furthermore, I learned how to maintain code  
      that's written by other members and make sure that the code work together correctly.
  - name: Nguyen, Hoang Hiep
    image: images/hiepavatar.jpeg
    content: Throughout this project, I have improved my programming skill by implementing programming practice. Moreover, by practicing agile, I have learnt how to be a better team member.
velocity:
  enable: true
  image: images/velocity.png
  title: PROJECT VELOCITY
  content: We’re counting the number of user stories and developer tasks for our velocity chart. The developer tasks also include the fixes that we planned to do. For the 
    second iteration, we commit to more user stories and developer tasks because we could accomplish all the user stories and developer tasks in iteration 1. However, it 
    turns out that there were some bugs that needed to be fixed from iteration 1 and setting up the database also took more time than expected. Thus, we couldn’t complete all 
    of them in iteration 2. Then, for iteration 3, we commit less because we become more aware of how much we could accomplish in 1 iteration and we want to accomplish the 
    tasks more carefully so that we could avoid from having more bugs in the app.
    
title: My Grocery Pal


---


