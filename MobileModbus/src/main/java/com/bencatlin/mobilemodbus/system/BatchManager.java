package com.bencatlin.mobilemodbus.system;

/*************************************************
 *
 *
 *
 *************************************************/
public class BatchManager {

    private static BatchManager mInstance = new BatchManager();

    private BatchManager () {

    }

    public static BatchManager getInstance() {


        return mInstance;
    }


}
