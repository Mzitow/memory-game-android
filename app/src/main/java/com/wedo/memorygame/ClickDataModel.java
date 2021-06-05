package com.wedo.memorygame;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ClickDataModel {



    public int moveNo;
    public int cardId;


    public ClickDataModel() {
    }

    public ClickDataModel( int moveNo, int cardId) {

        this.moveNo = moveNo;
        this.cardId = cardId;

    }
}
