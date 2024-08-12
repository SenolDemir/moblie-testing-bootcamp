# Mobile Testing Bootcamp

# Requirements  
Java JDK 11+ installation  
IntelliJ IDEA Installation  
Homebrew installation  
NodeJS installation (required to up and run appium server)  
npm installation
Android Studio (to use android emulator devices)  
Xcode (to use ios simulator devices)

# Appium Setup and Installations
Appium Server  
Appium Inspector

## Appium Drivers
for iOS devices - XCUITest  
for Android devices - UIAutomator2  
```ddt
appium driver install xcuitest
appium driver install uiautomator2
```
### for mobile chrome

### for mobile safari  
appium safari driver should be installed:
```bash
appium driver install safari
```
note:   
It is mandatory to run the ```safaridriver --enable ```
command from the macOS terminal and provide your administrator password before any automated session will be executed.  
and  
you have to enable your Safari Developer options and activate “Automatically Show Web Inspector for JSContexts” for your iOS simulator.


## Appium Plugins

### appium wait plugin  
This is an Appium plugin designed to wait for element to be present.
``` 
appium plugin install --source=npm appium-wait-plugin
```
https://github.com/AppiumTestDistribution/appium-wait-plugin  


### appium device farm  
This is an Appium plugin designed to manage and create driver session on connected android, iOS real devices, emulators and Simulators.  
```
appium plugin install --source=npm appium-device-farm
```  
for setup and usage
https://devicefarm.org/setup/

# Features
to start appium server by automation (to prevent handle it manually) a BeforeTest method generated. Autamation starts and stop appium server before and efter test

## Android
to get package name of app from emulator package viewer apk installed to emulator manually
by using it the details of clock app captured and used in capability setting
it is in test data folder name is: com-csdroid-pkg.apk


## IOS
some additional appium packages added which defining by appium-doctor
app test with external and builtin apps executed.


## Cloud Platforms  
SauceLab and BrowserStack were tried
Saucelab implemented test in manual and autamated.  
But intercation was not well. There was a server based error, so test can not be watched. Element lacating could not be done.

BrowserStack:  
Autmation can not be done. It gives error maybe because of url error.
Manually has done in Appium Insoector and intarction successed.  



### Sources:  
more info about gestures, actions  
https://www.devstringx.com/automate-gestures-using-w3-actions-api-in-appium



