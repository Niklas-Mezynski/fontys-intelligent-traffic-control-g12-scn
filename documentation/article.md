# Article

This article is written as an additional overview of the traffic control system developed by group 12 in PRJ3. 
The purpose of the article is to inform the assessment committee about the overall architecture of the software system, 
as well as to explain which design patterns and principles have been applied and how and why they have been integrated. 
The article will also provide individual explanation of the contribution to the project written by each team member.

## Overall architecture
In terms of architecure our group decided to organize our system into separate layers, where each layer has different responsibilities. There are two main layers - the business logic and the presentation logic layers. The business logic layer is responible for handling the business rules, calculations, and logic within an application which dictate how it behaves. The purpose of the presentation logic layer is to display information to and collect information from the user - in other words it is responible for maintaining the user interface, where the end user interacts with the application. The two layers are closed - all user requests go throught the presentation layer to the business logic layer where they are executed and results are returned to the presentation layer and displayed to the user. The separate layers work in isolation in order to prevent business logic from accessing view logic directly, because we know that a lower level layer should not be able to access a higher level layer. This way we keep our layers as independent from each other as possible, which allows us to easily test them in isolation, maintain and extend them or even completely replace them in case such measures are needed, without worrying about accidentally breaking the system. Changes in one layer do not affect the other layer directly and the amount of rework needed to adapt to those new changes is very low.


## Design patterns
In this part we will describe the design patterns we used in our software design.

### The traffic lights with different light behaviours and states (Niklas)
First, we created a few requirements for the traffic light. Important to know is that traffic lights can have multiple states (basically the color they show). A state can have different meanings, i.e. 'passing', 'stop' and 'transition'. Each traffic lights has one passing and one stopping state and can have additional transition states. The traffic lights can have different light behaviours as well. A light behaviour determines which states the traffic light can have and how iteration order looks like.

![Traffic light class diagram](../design/poster_class_diagram.png?raw=true "Class diagram for the traffic light and its corresponding classes")

The class diagram shows the TrafficLight interface and the classes it needs in order to work properly. First, we designed the different light behaviour. It is very straight forward that the light behaviour consists of multiple states following one and another, therefor we decided to use a state-machine-pattern like design here. Each behaviour-enum implements the LightState interface and therfore each state of this behavior needs to implement the 'getNextState' method. This way we can easily define different light states and the order of them. 


### Factory Pattern (Henrik)


## Design principles

## Scrum (Patrick)
As the scrum master I was responsible for the general organization of the project team. I made sure that everyone knew when the meetings took place through the Outlook Calendar, checked that everyone is present and got a chance to voice their opinion or concerns. 

I also made sure that the meetings took place within the limitations of the timebox. Henrik and I worked together closely to make sure that he, as product owner, got the deliverables he wanted in-time. We planned the deliverables together in the project board and I made sure that everyone knew what their tasks were. 

## Tests (Henrik, Patrick)

The application itself has gotten quite big. It was paramount that we implemented high-quality tests with an excellent coverage. We also configured a task in GitHub which automatically runs all our tests for every new push. This made sure that our application continued to work as expected throughout the project. It also saved us a lot of time because we didn’t have to test everything manually after every sprint.

Our layered architecture also makes testing quite easy because we had the possibility to test every module independently.

## Crossing modes (Patrick)
Crossings look different in every country. Therefore, it was essential that the crossings support different (pedestrian) traffic lights. 

The first “Simple crossing” iteration consisted of two Pedestrian traffic lights. It was also already completely modular in the sense that it supported all kinds of pedestrian lights.

After the first iteration was complete it got extended with two traffic lights. All lights were placed on an axis (horizontal and vertical). It was only possible for cars and pedestrians to go straight.

When that was done the advanced crossing was created. This crossing consists of pedestrian lights going each direction + traffic lights with 3 lanes. Straight, left and right. We can control every light individually and thus create an entirely modular traffic light system. Its also possible to create an advanced crossing with only 1 or 2 traffic lanes. That’s completely up to the implementer. 

## Your (individual) role - area(s) you worked on

* Daniel - 
* Henrik - 
As a product owner, I was responsible for frequently updating the product backlog. After every sprint planning meeting, I set up the "To Do" log for the next sprint. At the start of every meeting of the group, I basically communicated the current status of our work and where we are right now. What we are actually doing in a specific meeting is either decided by the group itself or by me. I prioritized the different worked out user stories and based on that, put them into the "To Do" log for each sprint. At the sprint review meeting, I took a look at our work and determined what eventually missed and how we could improve. 

* Niklas - 
* Patrick -
* Tanja -  
