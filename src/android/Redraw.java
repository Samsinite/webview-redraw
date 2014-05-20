package com.samsinite.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import java.lang.Exception;
import java.io.StringWriter;
import java.io.PrintWriter;

public class Redraw extends CordovaPlugin {
	private CordovaWebView _webView;
	private CordovaInterface _cordova;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		this._webView = webView;
		this._cordova = cordova;
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
		if (action.equals("redraw")) {
			try {
				this._cordova.getActivity().runOnUiThread(new Runnable() {
					public void run() {
						this._webView.invalidate();
						callbackContext.success("Invalidate was called!");
					}
				});
			}
			catch (Exception e) {
				final StringWriter sw = new StringWriter();
				final PrintWriter pw = new PrintWriter(sw, true);
				e.printStackTrace(pw);
				callbackContext.error(sw.getBuffer().toString());
			}
		}
		else {
			return false;
		}

		return true;
	}

}