/*zxg.2016.01.22*/
package org.apache.cordova.bdlocation;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Poi;

import org.apache.cordova.CallbackContext;

public class BDLocationHelper{
    private CallbackContext callbackContext=null;
	private LocationClient locationClient = null;
    public BDLocationHelper(Context context,CallbackContext callbackContext){
        this.callbackContext=callbackContext;
        locationClient = new LocationClient(context);
        locationClient.registerLocationListener(new LocationListener() );
        locationClient.setLocOption(this.getOption());
        locationClient.start();
    }
    private LocationClientOption getOption(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd09ll");
        int span=1000;
        option.setScanSpan(span);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(true);
        option.setIgnoreKillProcess(false);
        option.SetIgnoreCacheException(false);
        option.setEnableSimulateGps(false);
        return option;
    }
	private class LocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            String success="",message="",type="";
            if (location.getLocType() == BDLocation.TypeGpsLocation){
                success="true";
                type="GpsLocation";
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){
                success="true";
                type="OffLineLocation";
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {
                success="true";
                type="OffLineLocation";
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                success="false";
                message="ServerError";
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                success="false";
                message="NetWorkException";
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                success="false";
                message="CriteriaException";
            }
            if(success.equals("true")){
                callbackContext.success("{success:'true',type:'"+type+"',latitude:'"+location.getLatitude()+"',lontitude:'"+location.getLongitude()+"'}");
            }else{
                callbackContext.error("{success:'false',message:'" + message + "'}");
            }
            locationClient.stop();
        }
	}
}