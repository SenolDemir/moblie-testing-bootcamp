# Mobile Testing Bootcamp

Installation

## Appium Plugins

appium-wait-plugin
This is an Appium plugin designed to wait for element to be present.
``` 
appium plugin install --source=npm appium-wait-plugin
```
appium-device-farm 
This is an Appium plugin designed to manage and create driver session on connected android, iOS real devices, emulators and Simulators.  
``` appium plugin install --source=npm appium-device-farm ```  
for setup and usage
https://devicefarm.org/setup/


to get package name of app from emulator package viewer apk installed to emulator manually
by using it the details of clock app captured and used in capability setting
it is in test data folder name is: com-csdroid-pkg.apk


ios: for IOS Devices
some additional appium packages added which defining by appium-doctor
app test with external and builtin apps executed.

on Cloud Platforms  
SauceLab and BrowserStack were tried
Saucelab implemented test in manual and autamated.  
But intercation was not well. There was a server based error, so test can not be watched. Element lacating could not be done.

BrowserStack:  
Autmation can not be done. It gives error maybe because of url error.
Manually has done in Appium Insoector and intarction successed.  



### Sources:  
more info about gestures, actions  
https://www.devstringx.com/automate-gestures-using-w3-actions-api-in-appium



