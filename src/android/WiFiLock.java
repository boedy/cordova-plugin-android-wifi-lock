package org.apache.cordova.plugin;

import android.content.Context;
import android.net.wifi.WifiManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;


public class WiFiLock extends CordovaPlugin {

    private WifiManager wifiManager;

    private WifiManager.WifiLock lock;


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Context context = this.cordova.getActivity().getApplicationContext();

        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) {

        switch (action) {
            case "acquire":
                this.acquire();
                callbackContext.success();
                break;
            case "isHeld":
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.isHeld()));
                break;
            case "release":
                this.release();
                callbackContext.success();
                break;
            default:
                return false;
        }
        return true;
    }

    private void acquire() {
        if (this.lock == null) {
            this.lock = wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, "CordovaPluginAndroidWifiLock");
            this.lock.acquire();
        }
    }

    private boolean isHeld() {
        if (this.lock != null) {
            return this.lock.isHeld();
        }
        return false;
    }

    private void release() {
        if (this.lock != null) {
            this.lock.release();
            this.lock = null;
        }
    }
}
