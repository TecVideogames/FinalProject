package finalproject;

/**
 * Sat_Dungeon
 * 
 * @author Marco Antonio Peyrot
 */
public class Sat_Dungeon {
    
    // Dungeon Structure Identifiers
    final int OCCUPIED = -1;
    final int FREE = 0;
    final int ROOM_TYPE1 = 1;
    final int ROOM_TYPE2 = 2;
    final int ROOM_TYPE3 = 3;
    final int HALL_TYPE1 = 4;
    final int HALL_TYPE2 = 5;
    final int HALL_TYPE3 = 6;
    
    // Class variables
    final int iDungeonSize = 12;
    private int iLevel;
    private int iNumDungeonElements;
    private int iArrDungeonLayout [][];
    private int iPosX;
    private int iPosY;
    
    /**
     * Sat_Dungeon
     * 
     * Only constructor for the creation of a dungeon logic scheme
     * 
     * @param iLevel is an <code> int </code> with the games difficulty level
     * this parameter modifies the dungeon's behavior
     */
    Sat_Dungeon(int iLevel) {
        this.iLevel = iLevel;
        iNumDungeonElements = iLevel * 25;
        iArrDungeonLayout = new int [iDungeonSize][iDungeonSize];
        // Create the matriz with a free space
        createMatrix(iArrDungeonLayout, iDungeonSize);
        // Make edges occupied for security measures
        // (not get out of matrix index)
        initMatrixEdges(iArrDungeonLayout, iDungeonSize);
        // Create the structures inside the dungeon
        generateDungeon(iArrDungeonLayout, iDungeonSize);
        // Initial players position inside the dungeon
        iPosX = 5;
        iPosY = 5;
    }
    
    /**
     * getIPosX
     * 
     * @return an <code> int </code> with the player's x position 
     * inside the dungeon
     */
    int getIPosX() {
        return iPosX;
    }
    
    /**
     * setIPosX
     * 
     * @param iPosX is an <code> int </code> used to change the player's
     * position in the x axis inside the dungeon
     */
    void setIPosX(int iPosX) {
        if(iPosX >= 0 && iPosX < iDungeonSize) {
            this.iPosX = iPosX;
        }
        else {
            this.iPosX = 5;
            this.iPosY = 5;
        }
    }
    
    /**
     * getIPosY
     * 
     * @return an <code> int </code> with the player's y position 
     * inside the dungeon
     */
    int getIPosY() {
        return iPosY;
    }
    
    /**
     * setIPosY
     * 
     * @param iPosY is an <code> int </code> used to change the player's
     * position in the y axis inside the dungeon
     */
    void setIPosY(int iPosY) {
        // Validate that position is inside the matrix
        if(iPosY >= 0 && iPosY < iDungeonSize) {
            this.iPosY = iPosY;
        }
        else {
            this.iPosX = 5;
            this.iPosY = 5;
        }
    }
    
    /**
     * getIDungeonPos
     * 
     * @return an <code> int </code> with the player's structure value
     * according to its current position
     */
    int getIDungeonPos() {
        return iArrDungeonLayout[iPosX][iPosY];
    }
    
    /**
     * createMatrix
     * 
     * Used to create a matrix of size n
     * 
     * @param matrix is the matrix being created of type <code> int [][] </code>
     * @param iSize is the size of the matrix of type <code> int </code>
     */
    private void createMatrix (int [][] matrix, int iSize) {
        // Validate that position is inside the matrix
	for(int iI = 0; iI < iSize; iI ++) {
            for(int iJ = 0; iJ < iSize; iJ ++) {
                matrix[iI][iJ] = FREE;
            }
	}
    }

    /**
     * initMatrixEdges
     * 
     * Give edges the value -1 or occupied
     * 
     * @param matrix is the matrix being created of type <code> int [][] </code>
     * @param iSize is the size of the matrix of type <code> int </code>
     */
    private void initMatrixEdges (int [][] matrix, int iSize) {
        for(int iI = 0; iI < iSize; iI ++) {
            matrix[0][iI] = OCCUPIED;
            matrix[iSize - 1][iI] = OCCUPIED;
            matrix[iI][0] = OCCUPIED;
            matrix[iI][iSize - 1] = OCCUPIED;
        }
    }

    /**
     * createEdgeRooms
     * 
     * If a hall is located near the edge, make a final room connecting to it
     * 
     * @param matrix is the matrix being created of type <code> int [][] </code>
     * @param iSize is the size of the matrix of type <code> int </code> 
     */
    private void createEdgeRooms (int [][] matrix, int iSize) {
        
        // If there is a hall put a room, else make the occupied space free
        for(int iI = 0; iI < iSize; iI ++) {
            if(matrix[1][iI] == HALL_TYPE1) {
                matrix[0][iI] = ROOM_TYPE1;
            }
            else {
                matrix[0][iI] = FREE;
            }

            if(matrix[iSize - 2][iI] == HALL_TYPE1) {
                matrix[iSize - 1][iI] = ROOM_TYPE1;
            }
            else {
                matrix[iSize - 1][iI] = FREE;
            }

            if(matrix[iI][1] == HALL_TYPE1) {
                matrix[iI][0] = ROOM_TYPE1;
            }
            else {
                matrix[iI][0] = FREE;
            }

            if(matrix[iI][iSize - 2] == HALL_TYPE1) {
                matrix[iI][iSize - 1] = ROOM_TYPE1;
            }
            else {
                matrix[iI][iSize - 1] = FREE;
            }
        }
    }

    /**
     * generateDungeon
     * 
     * Main method for the creation of the logical scheme of the dungeon layout
     * 
     * @param matrix is the matrix being created of type <code> int [][] </code>
     * @param iSize is the size of the matrix of type <code> int </code>
     */
    private void generateDungeon (int [][] matrix, int iCantElements) {
        int iRow = 5;
        int iCol = 5;
        int iNewPos;
        boolean bExit = false;
        int iType = 0;
        
        // Create intial room of the dungeon
        matrix[iRow][iCol] = ROOM_TYPE1;

        for(int iI = 0; iI < iCantElements && !bExit; iI ++) {
            // There is a space free to move on
            if(matrix[iRow][iCol + 1] == FREE ||
                    matrix[iRow][iCol - 1] == FREE ||
                    matrix[iRow + 1][iCol] == FREE ||
                    matrix[iRow - 1][iCol] == FREE) {
                
                boolean bFreeSpace = false;
                do {
                    // Choose new structure location
                    iNewPos = (int) Math.floor((Math.random() * 4) + 1);

                    // According to the position, create a room or a hall
                    switch (iNewPos) {
                        case 1:
                            if (matrix[iRow][iCol + 1] == FREE) {
                                bFreeSpace = true;
                                if (iType == 0) {
                                    matrix[iRow][iCol + 1] = ROOM_TYPE1;
                                    iType = 1;
                                } else {
                                    matrix[iRow][iCol + 1] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iCol = iCol + 1;
                            }
                            break;
                        case 2:
                            if (matrix[iRow][iCol - 1] == FREE) {
                                bFreeSpace = true;
                                if (iType == 0) {
                                    matrix[iRow][iCol - 1] = ROOM_TYPE1;
                                    iType = 1;
                                } else {
                                    matrix[iRow][iCol - 1] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iCol = iCol - 1;
                            }
                            break;
                        case 3:
                            if(matrix[iRow + 1][iCol] == FREE) {
                                bFreeSpace = true;
                                if(iType == 0) {
                                    matrix[iRow + 1][iCol] = ROOM_TYPE1;
                                    iType = 1;
                                }
                                else {
                                    matrix[iRow + 1][iCol] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iRow = iRow + 1;
                            }
                            break;
                        case 4:
                            if(matrix[iRow - 1][iCol] == FREE) {
                                bFreeSpace = true;
                                if(iType == 0) {
                                    matrix[iRow - 1][iCol] = ROOM_TYPE1;
                                    iType = 1;
                                }
                                else {
                                    matrix[iRow - 1][iCol] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iRow = iRow - 1;
                            }
                            break;
                    }
                } while(!bFreeSpace);

                iI --;
            }
            else {
                bExit = true;
            }
        }

        // Clean flags used to generate dungeon and make final adjustments
        createEdgeRooms(iArrDungeonLayout, iDungeonSize);
        randomizeDungeon(iArrDungeonLayout, iDungeonSize);
    }

    /**
     * randomizeDungeon
     * 
     * Make the room and hall types random structures
     * 
     * @param matrix is the matrix being created of type <code> int [][] </code>
     * @param iSize is the size of the matrix of type <code> int </code>
     */
    private void randomizeDungeon (int [][] matrix, int iCantElements)
    {
        int iType;

        for (int iI = 0; iI < iCantElements; iI ++) {
            for (int iJ = 0; iJ < iCantElements; iJ ++) {
                iType = (int) Math.floor((Math.random() * 3) + 1);

                if (matrix[iI][iJ] == ROOM_TYPE1) {
                    switch (iType) {
                        case 1:
                            matrix[iI][iJ] = ROOM_TYPE1;
                            break;
                        case 2:
                            matrix[iI][iJ] = ROOM_TYPE2;
                            break;
                        case 3:
                            matrix[iI][iJ] = ROOM_TYPE3;
                            break;
                    }
                } else if (matrix[iI][iJ] == HALL_TYPE1) {
                    // Choose apropiate hall type based on object layout
                    // Not implemented
                }
            }
        }
    }
}
