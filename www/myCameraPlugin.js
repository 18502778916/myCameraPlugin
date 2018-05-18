var exec = require('cordova/exec');

exports.toCamera = function (success, error) {
    exec(success, error, 'myCameraPlugin', 'toCamera');
};
