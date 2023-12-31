# Bridge Builder
This bridge builder application builds a command line game where the user can choose the easy mode or hard mode in which the user will act as a civil engineer and will construct a bridge across a vast lake where the swamp is in the bottom right corner and in the hard mode the rival group has hired their own automated engineer to intervene in your bridge construction. However, there are many restrictions. The bridge can only be made from left to right and/or bottom to top. If the player constructs a bridge from left to right, they score 5 points. if they construct a bridge from bottom to top, they score 7 points. If they construct a bridge diagonally from top left to bottom right, they score 10 points. If the players won on a grid larger than 3 x 3 they will get a bonus points of the grid minus three. If the player has tied, where all squares are filled with no bridge completed then the player is awarded 1 point. In the hard mode, if the rival engineer builds its own bridge before the player, the player loses and earns 0 points in that round. Engineer's move is detected by '0', player's move is detected by '+' and empty positions are identified by '.'. In the easy mode, the engineer will randomly choose a position on the grid and in the hard mode, the engineer strategically chooses a posiyion one point to right of player's recent position and if that position si full keeps moving to the right or top until an empty spot is found. The engineer's algorithm will be using a rightward and top down search. 

The following image is an example of what the command line game will look like 

![image](https://github.com/simrank13/bridgebuilder/assets/132793467/4cdd7da4-59fd-489d-a623-cec566be9e48)
![image](https://github.com/simrank13/bridgebuilder/assets/132793467/6c9cb2c5-65fb-4775-9f20-3c9c92b9e739)



