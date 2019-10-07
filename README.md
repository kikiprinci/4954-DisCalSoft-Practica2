## Diseño y calidad del Software 
### Practica 2
* Fecha de entrega: 07/10/2019
* Integrante:
  * Fran Arboleya

   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="https://plantuml-server.kkeisuke.app/svg/hLPRQzim57xthz2Zkypz0IQ4Rc4RWmJ62kcpOf-c0bioajAaPFdlqysMB2jPGmV1iSxzVETYFGY9kTotJPPL3HO2hR6Gm5j2wrE6K84QjYDLkT9FStubS2Wtwg5ECzGr-2s_AryPgRDpvdNHfw9c1reiaDLCSOoHZ535UCOLcFCfco53mPNCbunApfe6-E11ow3x-mNol3vmHH6i0Mj5HphOgGRPScBIfYI8p0qGdby-ZiyJUGvYtqAWy3iYJ3GwpZece5woTaiebeJHGFtNDUuOWFaVYs6OSnQyUumVeU8W0vENHHF-BmlhN9k9NLU9f5DRamCd4XhgMyQfN72ULD8a3hXMvuIQr_Z6EUCvw6TftWDz8v1ZAQ7jubYIkTb8T2SHkeSVk0NbViiKC9YwY7Jr4mpZQgMY7vm_QSfFyKGe1HvcvHWhfdBY4unyDzXWLCDAq6qgmPntodUf0p2JUS9R8NNxdn6kAkZ2STheTWpmcA4To4dLLa1tyaM5eGQf5_fY41DZuf8rZ8klRvRfK9LQugvS4I7dHc0njY6LWaChC6MnJvGrLwi3ZjQc5J8gnAFeC4UEliP75qzO3lqxPnu9FqhHk2TbheveKYFU2LVwFIwlgreLLwsyK4TabvxuJYWHBr17ROZhskAMMaEfGGhwKkccIdAReQ6F8wG_agtPsNbgW4FGF-B1ZdLEuQ2RjKSqzgXv_KU7o72aBzOZCKp5UyQmI4nSC1lZUIlyJ6atXccF4VVzjHo6psWdH0P72Tx2OH8FhIEdPZPi6-b0fd2Kuw-1W151HRR1pHwCZcAOVqFnzip5vD-Rr2vzzurUusxkRNtsdRFmkx0dARV1t9ypuo_uCaVx9c9VNpMHy6JBH7oJojI_oZQuVat6G6Cpk-rkDBlrQZJxVpUZR9A0NyFzHQRVp-CRf1CFBQ2YXosYETWUWDRgqlmN.svg">
</p>

### PlantUML
 
 ```PlantUML
@startuml
class Mastermind{
  - logic:Logic
  - view:View
  + play():void
}
Mastermind *-down-> Logic
Mastermind *-down-> View

interface View{
+ interact(Controller):void
}
View ..> Controller

class ConsoleView{
  - interact(controller:Controller):void
  - visit(startController:StartController):void
  - visit(resumeController:ResumeController):void
  - visit(proposedCombinationController:ProposedCombinationController):void
}
View <|-down- ConsoleView
ConsoleView *-down-> SecretCombinationView
ConsoleView *-down-> ProposedCombinationView
ConsoleView *-down-> ResultCombinationView

class SecretCombinationView{
  - writeln():void
}

class ProposedCombinationView{
  - writeln():void
  - read():ProposedCombination
  - writeError(error:Error):void
  - write(attemp):void
}

class ResultCombinationView{
  - continueGame():boolean
  - resumeGame():boolean
  - writeLn()void
  - WriteIsWinner():void
  - WriteIsLooser():void
}

class Controller{
  - state:State
  - game:Game
  + {abstract} accept(ControllerVisitor):void
  + getSecretCombinationLength():int
  + getAttemps():int
  + getColorsByAttemp(attempt:int):List<Color>
  + getAttemptsByGame():int
  + getResultProposedCombination(index:int):Result
  + isWinner():boolean 
  + isMaxAttemp():boolean
  
  
}
Controller <|-down- StartController
Controller <|-down- ProposedCombinationController
Controller <|-down- ResumeController

class ProposedCombinationController{
  - accept(controllerVisitor:ControllerVisitor):void 
  - isFinished():boolean
  - addResult(proposedCombination:ProposedCombination):void
  - addProposedCombination(proposedCombination:ProposedCombination):void
}

class StartController{
  - accept(controllerVisitor:ControllerVisitor):void 
  - start():void
}

class ResumeController{
  - accept(controllerVisitor:ControllerVisitor):void 
  - resume(newGame:boolean):void
}

class Game{
  - init():void
  - isFinished():boolean
  - getAttemps():int
  - getSecretCombinationLength():int
  - getColorsByAttemp(index:int):List<Color>
  - getResults():List<Result>
  - getResult(proposedCombination:ProposedCombination):Result
  - getProposedCombinations():List<ProposedCombination>
  - isWinner():boolean
  - isMaxAttemp():boolean
}

class State{
  - next():void
  - reset():void
  - getValueState():StateValue
}

class Logic{
  - state:State
  - game:Game
  - controller:Map<StateValue,Controller>
  + getController():Controller
}
Logic *-down-> StartController
Logic *-down-> ProposedCombinationController
Logic *-down-> ResumeController
Logic *-down-> Game
Logic *-down-> State

interface ControllerVisitor{
  +visit(startController:StartController):void
  +visit(resumeController:ResumeController):void
  +visit(proposedCombinationController:ProposedCombinationController):void
}

ControllerVisitor <|-down- View
Controller ..> ControllerVisitor

Controller --> Game
Controller --> State

@enduml
```
