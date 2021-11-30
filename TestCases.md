# TEST CASES :)

# Test cases for piece moving: 

### Regular moving and piece input:

1. Move pieces out of the board, from the left, right, up, top. Sample cases: Move from (0, 1) to (-1, 0)
      
 	-> This should be illegal, and not return any runtime errors. **Should be okay**
      
2. Move pieces backward diagonally when they **aren't** a ascended piece and when they **are** a ascended piece. Ex: from (4, 4) to (3, 3)
      
	-> They should be considered an illegal move when they aren't a ascended piece, and legal when they are a ascended piece.
3. Move pieces forward diagonally when the square is empty. Ex: from (5, 5) to (6, 6)

	-> ***TRY MOVING TO DIAGONAL EDGES, and make sure there are no array errors.***
      
 	-> Should be free of errors. **Should be okay**
      
4. Move pieces forward diagonally when the square has an enemy piece or friendly piece. 
	
4. Move pieces forward and backward(horizontally and vertically) Ex: from (2, 2) to (1, 2)

	-> Should return an illegal move. 

5. Move a piece to the back rank from home square and check if they automatically royally ascended. 

	-> Should have no issues. 
	
##### All of the cases should be tested with both Red and Black pieces.
### Input from Console:

1. Make sure something out of the format is still considered invalid and doesn't cause any bugs.
2. No errors pop up when entering correct format
3. Make sure the instructions are clear.

### Captures:

1. Normal Captures (no issues)

	-> **MAKE SURE IT IS MANDATORY**
	-> Make sure the user is told of this.
	-> have the option to choose if there is more than 1 capture possible.
	
3. Multi Captures
	-> Should provide the option to choose between captures if more than 1 capture in the middle is possible.
	-> Automatically capture if it can conisistently with the same piece.
	
# Endgame conditions
1. Checkmate or win. 
-> No pieces, or no legal moves by one side

2. Draw

-> 10 moves with no piece captured by either side.


