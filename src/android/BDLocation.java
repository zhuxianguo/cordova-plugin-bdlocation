/*zxg.2016.01.22*/
package org.apache.cordova.bdlocation;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;

public class BDLocation extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)throws JSONException {
        if (action.equals("getLocation")) {
            new BDLocationHelper(this.webView.getContext(),callbackContext);
            return true;
        }
        return false;
    }
}