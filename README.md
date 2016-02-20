    # cordova-plugin-bdlocation
    百度定位
    平台:Android
    安装方法：cordova plugin add https://github.com/zhuxianguo/cordova-plugin-bdlocation --save --variable API_KEY="Your_API_KEY"
    Api:navigator.BDLocation.getLocation(succuess,error)
    示例:
    navigator.BDLocation.getLocation(
        function(res){
            document.getElementById('msg').innerText=res;
        },
        function (res) {
            document.getElementById('msg').innerText=res;
        });
    处女作，见谅！
