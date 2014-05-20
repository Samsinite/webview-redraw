package com.samsinite.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.apache.commons.lang.exception.ExceptionUtils;
import java.lang.Exception;

public class Redraw extends CordovaPlugin {
	private CordovaWebView _webView;
	private CordovaInterface _cordova;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		_webView = webView;
		_cordova = cordova;
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
		if (action.equals("redraw")) {
			try {
				_cordova.getActivity().runOnUiThread(new Runnable() {
					public void run() {
						_webView.invalidate();
						callbackContext.success("Invalidate was called!");
					}
				});
			}
			catch (Exception e) {
				callbackContext.error(ExceptionUtils.getStackTrace(e));
			}
		}
		else {
			return false;
		}

		return true;
	}

}