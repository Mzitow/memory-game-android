package com.wedo.memorygame;

public enum MemoryLevel {
    EASY(8), MEDIUM(18), HARD(24);

    private  final  int numberOfPieces;

    MemoryLevel(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public int getPieces(){
        return numberOfPieces;
    }

    public int getWidh()
    {
        int width = 0;
        switch (numberOfPieces)
        {
            case 8 :
                width = 2;
                break;
            case 18:
                width = 3;
                break;
            case 24:
                width = 4;
                break;
            default:

        }

        return width;
    }

    public int getHeight()
    {

        return  numberOfPieces / getWidh();
    }


}
