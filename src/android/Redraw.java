package com.samsinite.redraw;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class SplashScreen extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("redraw")) {
            this.webView.invalidate();
        }
        else {
            return false;
        }

        callbackContext.success();
        return true;
    }

}