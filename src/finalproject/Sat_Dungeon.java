package finalproject;

/**
 *
 * @author Marco Antonio Peyrot
 */
public class Sat_Dungeon {
    final int iDungeonSize = 12;
    private int iLevel;
    private int iNumDungeonElements;
    private int iArrDungeonLayout [][];
    private int iPosX;
    private int iPosY;
    
    final int OCCUPIED = -1;
    final int FREE = 0;
    final int ROOM_TYPE1 = 1;
    final int ROOM_TYPE2 = 2;
    final int ROOM_TYPE3 = 3;
    final int HALL_TYPE1 = 4;
    final int HALL_TYPE2 = 5;
    final int HALL_TYPE3 = 6;
    
    Sat_Dungeon(int iLevel) {
        this.iLevel = iLevel;
        iNumDungeonElements = iLevel * 25;
        iArrDungeonLayout = new int [iDungeonSize][iDungeonSize];
        createMatrix(iArrDungeonLayout, iDungeonSize);
        initMatrixEdges(iArrDungeonLayout, iDungeonSize);
        generateDungeon(iArrDungeonLayout, iDungeonSize);
        iPosX = 5;
        iPosY = 5;
    }
    
    int getIPosX() {
        return iPosX;
    }
    
    void setIPosX(int iPosX) {
        if(iPosX >= 0 && iPosX < iDungeonSize) {
            this.iPosX = iPosX;
        }
        else {
            this.iPosX = 5;
            this.iPosY = 5;
        }
    }
    
    int getIPosY() {
        return iPosY;
    }
    
    void setIPosY(int iPosY) {
        if(iPosY >= 0 && iPosY < iDungeonSize) {
            this.iPosY = iPosY;
        }
        else {
            this.iPosX = 5;
            this.iPosY = 5;
        }
    }
    
    int getIDungeonPos() {
        return iArrDungeonLayout[iPosX][iPosY];
    }
    
    // Used to create a matrix of size n
    private void createMatrix (int [][] matrix, int iSize)
    {
	for(int iI = 0; iI < iSize; iI++)
	{
            for(int iJ = 0; iJ < iSize; iJ++)
            {
                    matrix[iI][iJ] = FREE;
            }
	}
    }

    // Give edges the value -1
    private void initMatrixEdges (int [][] matrix, int iSize)
    {
            for(int iI = 0; iI < iSize; iI++)
            {
                    matrix[0][iI] = OCCUPIED;
                    matrix[iSize - 1][iI] = OCCUPIED;
                    matrix[iI][0] = OCCUPIED;
                    matrix[iI][iSize - 1] = OCCUPIED;
            }
    }

    private void createEdgeRooms (int [][] matrix, int iSize)
    {
        for(int iI = 0; iI < iSize; iI++)
        {
            if(matrix[1][iI] == HALL_TYPE1)
            {
                    matrix[0][iI] = ROOM_TYPE1;
            }
            else
            {
                    matrix[0][iI] = FREE;
            }

            if(matrix[iSize - 2][iI] == HALL_TYPE1)
            {
                    matrix[iSize - 1][iI] = ROOM_TYPE1;
            }
            else
            {
                    matrix[iSize - 1][iI] = FREE;
            }

            if(matrix[iI][1] == HALL_TYPE1)
            {
                    matrix[iI][0] = ROOM_TYPE1;
            }
            else
            {
                    matrix[iI][0] = FREE;
            }

            if(matrix[iI][iSize - 2] == HALL_TYPE1)
            {
                    matrix[iI][iSize - 1] = ROOM_TYPE1;
            }
            else
            {
                    matrix[iI][iSize - 1] = FREE;
            }
        }
    }

    // Generate Dungeon Layout
    private void generateDungeon (int [][] matrix, int iCantElements)
    {
        int iRow = 5;
        int iCol = 5;
        int iNewPos;
        boolean bExit = false;
        int iType = 0;
        
        matrix[iRow][iCol] = ROOM_TYPE1;

        for(int iI = 0; iI < iCantElements && !bExit; iI++)
        {
            if(matrix[iRow][iCol + 1] == FREE ||
                    matrix[iRow][iCol - 1] == FREE ||
                    matrix[iRow + 1][iCol] == FREE ||
                    matrix[iRow - 1][iCol] == FREE)
            {
                boolean bFreeSpace = false;
                do
                {
                    iNewPos = (int) Math.floor((Math.random() * 4) + 1);

                    switch(iNewPos)
                    {
                        case 1:
                            if(matrix[iRow][iCol + 1] == FREE)
                            {
                                bFreeSpace = true;
                                if(iType == 0)
                                {
                                    matrix[iRow][iCol + 1] = ROOM_TYPE1;
                                    iType = 1;
                                }
                                else
                                {
                                    matrix[iRow][iCol + 1] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iCol = iCol + 1;
                            }
                            break;
                        case 2:
                            if(matrix[iRow][iCol - 1] == FREE)
                            {
                                bFreeSpace = true;
                                if(iType == 0)
                                {
                                        matrix[iRow][iCol - 1] = ROOM_TYPE1;
                                        iType = 1;
                                }
                                else
                                {
                                        matrix[iRow][iCol - 1] = HALL_TYPE1;
                                        iType = 0;
                                }

                                iCol = iCol - 1;
                            }
                            break;
                        case 3:
                            if(matrix[iRow + 1][iCol] == FREE)
                            {
                                bFreeSpace = true;
                                if(iType == 0)
                                {
                                    matrix[iRow + 1][iCol] = ROOM_TYPE1;
                                    iType = 1;
                                }
                                else
                                {
                                    matrix[iRow + 1][iCol] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iRow = iRow + 1;
                            }
                            break;
                        case 4:
                            if(matrix[iRow - 1][iCol] == FREE)
                            {
                                bFreeSpace = true;
                                if(iType == 0)
                                {
                                    matrix[iRow - 1][iCol] = ROOM_TYPE1;
                                    iType = 1;
                                }
                                else
                                {
                                    matrix[iRow - 1][iCol] = HALL_TYPE1;
                                    iType = 0;
                                }

                                iRow = iRow - 1;
                            }
                            break;
                    }
                } while(!bFreeSpace);

                iI--;
            }
            else
            {
                bExit = true;
            }
        }

        createEdgeRooms(iArrDungeonLayout, iDungeonSize);
        randomizeDungeon(iArrDungeonLayout, iDungeonSize);
    }

    private void randomizeDungeon (int [][] matrix, int iCantElements)
    {
	int iType;

	for(int iI = 0; iI < iCantElements; iI++)
	{
            for(int iJ = 0; iJ < iCantElements; iJ++)
            {
                iType = (int) Math.floor((Math.random() * 3) + 1);

                if(matrix[iI][iJ] == ROOM_TYPE1)
                {
                    switch(iType)
                    {
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
                }
                else if(matrix[iI][iJ] == HALL_TYPE1)
			{
                            // Choose apropiate hall type based on object layout
			}
		}
	}
    }
}
