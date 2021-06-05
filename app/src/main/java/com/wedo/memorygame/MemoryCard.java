package com.wedo.memorygame;

public class MemoryCard {

    private Integer identifier;
    private boolean isFaceUp = false;
    private boolean isMatched = false;

    public MemoryCard() {
    }

    public MemoryCard(int identifier) {
        this.identifier = identifier;
    }

    public MemoryCard(int identifier, boolean isFaceUp, boolean isMatched) {
        this.identifier = identifier;
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
}
