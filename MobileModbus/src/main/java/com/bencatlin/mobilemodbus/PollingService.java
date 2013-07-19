package com.bencatlin.mobilemodbus;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

/**
 * Created by Ben Catlin on 7/19/13.
 */
public class PollingService extends Service {


    private boolean mAllowRebind; // indicates whether onRebind should be used
    private BatchRead<String> mCurrentBatch;
    private PollingRunnable mPollingRunnable;
    //private ; //connection data or modbus factory/master
    private boolean mConnected = false;

    private class PollingServiceHandler extends Handler
    {

        public PollingServiceHandler() {
            super();
        }
        @Override
        public void handleMessage(Message msg) {
            // Eventually we need to check what the message is, and respond according.

            // Case statement to check message type, basically we are looking for a "Batch Update"
            //  to update our batch info.

            // Remove this later
            //stopSelf(msg.arg1);
        }
    }



    /*============================================================================================
     *          LifeCycle Methods
     *===========================================================================================*/

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We need to do some logic here to return the interface if someone exists the client app,
        //  but wants to continue polling in the background.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }



    // Not sure if we need this stuff yet????

    /*
    @Override
    public boolean onUnbind(Intent intent) {
        // All clients have unbound with unbindService()
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
    }
    */

    @Override
    public void onDestroy() {
        super.onDestroy();
        // The service is no longer used and is being destroyed
    }

    /*=========================================================
    *            Service-y type stuffs methods
    *==========================================================*/



    /*=========================================================
    *            Setters and Getters
    *========================================================*/

    /**
     * @Method setCurrentBatch
     *
     * Not sure we actually need this?
     *
     * @param batch
     */
    public void setCurrentBatch(BatchRead batch) {
        this.mCurrentBatch = batch;
    }


    private class PollingRunnable implements Runnable {

        @Override
        public void run() {
            // I do stuff at regular intervals

            // This should probably all go somewhere else - and should be done based on
            //  the user selection of modbus connection type.
            IpParameters tcpParameters = new IpParameters();
            tcpParameters.setHost("10.0.0.2");

            ModbusFactory modbusFactory = new ModbusFactory();
            ModbusMaster master = modbusFactory.createTcpMaster(tcpParameters, true);
            // End of parameters that need to be abstracted somewhere better

            if (!mConnected) {
                try {

                    master.init();
                }
                catch (Exception e) {
                    Log.e( getClass().getSimpleName(), e.getMessage() );
                }

                mConnected = true;

            }

            while (mConnected) {
                try {

                    // Dummy data
                    if (mCurrentBatch == null) {
                        mCurrentBatch = new BatchRead<String>();
                    }

                    mCurrentBatch.addLocator("40000 sb -1968",
                            BaseLocator.holdingRegister(1, 40000, DataType.TWO_BYTE_INT_SIGNED));

                    BatchResults<String> results = master.send(mCurrentBatch);

                }
                catch (Exception e) {
                    Log.e( getClass().getSimpleName(), e.getMessage() );

                    mConnected = false;
                }
            }





        }
    }

}
