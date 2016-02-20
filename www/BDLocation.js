var exec = require('cordova/exec');

module.exports={
    getLocation : function(success, error) {
        exec(success, error, "BDLocation", "getLocation",[]);
    }
};