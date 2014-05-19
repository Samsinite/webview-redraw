package com.samsinite.redraw;

import org.apache.cordova;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class SplashScreen extends CordovaPlugin {

	@override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		if (action.equals("redraw")) {
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					this.webView.invalidate();
				}
			});
		}
		else {
			return false;
		}

		callbackContext.success();
		return true;
	}

}