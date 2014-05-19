package com.samsinite.redraw;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class Redraw extends CordovaPlugin {
	private CordovaWebView _webView;
	private CordovaInterface _cordova;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		_webView = webView;
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		if (action.equals("redraw")) {
			_cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					_webView.invalidate();
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