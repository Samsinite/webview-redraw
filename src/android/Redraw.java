package com.samsinite.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import java.lang.Exception;
import java.io.StringWriter;
import java.io.PrintWriter;
import org.apache.cordova.LOG;
import java.lang.Long;

public class Redraw extends CordovaPlugin {
	private static final String LOG_TAG = "Redraw";

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		LOG.d(LOG_TAG, "initiaizing android Redraw plugin...");
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
		LOG.d(LOG_TAG, "executing android Redraw plugin...");

		if (action.equals("redraw")) {
			try {
				// 300ms was the sweet spot it seems, but allow it to be overridden
				long delay = 300;
				if(args.length() == 1) {
				  delay = args.getLong(0);
				}

				LOG.d(LOG_TAG, "triggering delayed redraw at " + Long.toString(delay) + "...");
				// Post a request for a redraw on the UI thread, with the specified delay
				this.webView.postInvalidateDelayed(delay);
				LOG.d(LOG_TAG, "delay scheduled...");
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