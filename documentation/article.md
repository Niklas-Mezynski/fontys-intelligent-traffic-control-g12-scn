# Article

This article is written as an additional overview of the traffic control system developed by group 12 in PRJ3. 
The purpose of the article is to inform the assessment committee about the overall architecture of the software system, 
as well as to explain which design patterns and principles have been applied and how and why they have been integrated. 
The article will also provide individual explanation of the contribution to the project written by each team member.

## Overall architecture



## Design patterns
In this part we will describe the design patterns we used in our software design.

### The traffic lights with different light behaviours and states (Niklas)
First, we created a few requirements for the traffic light. Important to know is that traffic lights can have multiple states (basically the color they show). A state can have different meanings, i.e. 'passing', 'stop' and 'transition'. Each traffic lights has one passing and one stopping state and can have additional transition states. The traffic lights can have different light behaviours as well. A light behaviour determines which states the traffic light can have and how iteration order looks like.

![Traffic light class diagram](../design/poster_class_diagram.png?raw=true "Class diagram for the traffic light and its corresponding classes")

The class diagram shows the TrafficLight interface and the classes it needs in order to work properly. First, we designed the different light behaviour. It is very straight forward that the light behaviour consists of multiple states following one and another, therefor we decided to use a state-machine-pattern like design here. Each behaviour-enum implements the LightState interface and therfore each state of this behavior needs to implement the 'getNextState' method. This way we can easily define different light states and the order of them. 

## Design principles



## Your (individual) role - area(s) you worked on

* Daniel - 
* Henrik - 
* Niklas - 
* Patrick -
* Tanja -  