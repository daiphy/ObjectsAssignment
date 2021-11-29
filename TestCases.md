# TEST CASES :)

### Test cases for piece moving: 

1. Move pieces out of the board, from the left, right, up, top. Sample cases: Move from (0, 1) to (-1, 0)
      
      -> This should be illegal, and not return any runtime errors. 
      
2. Move pieces backward diagonally when they **aren't** a ascended piece and when they **are** a ascended piece. Ex: from (4, 4) to (3, 3)
      
      -> They should be considered an illegal move when they aren't a ascended piece, and legal when they are a ascended piece.
3. Move pieces forward diagonally when the square is empty. Ex: from (5, 5) to (6, 6)

      -> ***TRY MOVING TO DIAGONAL EDGES, and make sure there are no array errors.***
      
      -> Should be free of errors.
4. Move pieces forward diagonally when the square has an enemy piece or friendly piece. 
	
4. Move pieces forward and backward(horizontally and vertically) Ex: from (2, 2) to (1, 2)

      -> Should return an illegal move. 

5. Move a piece to the back rank from home square and check if they automatically royally ascended. 


