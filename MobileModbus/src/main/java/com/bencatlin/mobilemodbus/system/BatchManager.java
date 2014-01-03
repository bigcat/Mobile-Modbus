package com.bencatlin.mobilemodbus.system;

/**
 * Created by ben on 11/17/13.
 */
public class BatchManager {

    private static BatchManager mInstance = new BatchManager();

    private BatchManager () {

    }

    public static BatchManager getInstance() {


        return mInstance;
    }


}
