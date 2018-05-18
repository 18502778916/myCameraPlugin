# myCameraPlugin
带取景框相机插件（Android版）

使用第三方相机库
https://github.com/zhouzhuo810/CameraCardCropDemo
me.zhouzhuo810.cameracardcrop:camera-card-crop:1.0.2

开发工程下执行以下命令导入本插件：

$ ionic cordova plugin add https://github.com/18502778916/myCameraPlugin.git

已安装插件查看：

$ionic cordova plugin list

执行以下命令删本插件：

$ionic cordova plugin rm cordova.plugin.myCameraPlugin

## JS调用说明

cordova.plugins.myCameraPlugin.toCamera(
result=>alert(result),
error=>alert("失败")
);

## 备注

使用cordova插件时。请先↓

declare let cordova: any;
