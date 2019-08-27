module.exports = {
  acquire: function () {
    return new Promise(function(resolve, reject){
      cordova.exec(resolve, reject, "WiFiLock", "acquire", null);
    });
  },
  isHeld: function(){
    return new Promise(function(resolve, reject){
      cordova.exec(resolve, reject, "WiFiLock", "isHeld", null);
    });
  },
  release: function(){
    return new Promise(function(resolve, reject){
      cordova.exec(resolve, reject, "WiFiLock", "release", null);
    });
  }
};