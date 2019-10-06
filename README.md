## Diseño y calidad del Software 
### Practica 2
* Fecha de entrega: 07/10/2019
* Integrantes:
  * Fran Arboleya

   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="">
</p>

### PlantUML
 
 ```PlantUML
@startuml

class Mastermind
Mastermind *-down-> Logic
Mastermind *-down-> View

interface View
View ..> Controller

class ConsoleView
View <|-down- ConsoleView
ConsoleView *-down-> SecretCombinationView
ConsoleView *-down-> ProposedCombinationView
ConsoleView *-down-> ResultCombinationView

class Controller
Controller <|-down- StartController
Controller <|-down- ProposeCombinationController
Controller <|-down- ResumeController

class Logic
Logic *-down-> StartController
Logic *-down-> ProposeCombinationController
Logic *-down-> ResumeController
Logic *-down-> Game
Logic *-down-> State

interface ControllerVisitor

ControllerVisitor <|-down- View
Controller ..> ControllerVisitor

Controller --> Game
Controller --> State

@enduml

```
