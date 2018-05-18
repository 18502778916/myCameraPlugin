package com.jinan.mycamera;

import android.content.Intent;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

import static android.app.Activity.RESULT_OK;

/**
 * This class echoes a string called from JavaScript.
 */
public class myCameraPlugin extends CordovaPlugin {
    
    private CallbackContext callbackContext;
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext){
        if (action.equals("toCamera")) {
            this.callbackContext = callbackContext;
            this.coolMethod(callbackContext);
            return true;
        }
        return false;
    }
    
    private void coolMethod(CallbackContext callbackContext) {
        try {
            Intent intent = new Intent(this.cordova.getActivity(), TCamera.class);
            this.cordova.startActivityForResult((CordovaPlugin) this, intent, 0x001);
        } catch (Exception e) {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0x001:
                    String str = data.getStringExtra("result");
                    PluginResult mPlugin = new PluginResult(PluginResult.Status.OK,
                                                            str);
                    mPlugin.setKeepCallback(true);
                    callbackContext.sendPluginResult(mPlugin);
                    break;
            }
        }else {
            Toast.makeText(cordova.getActivity(), "拍照取消", Toast.LENGTH_SHORT).show();
        }
    }
}
