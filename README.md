# cordova-plugin-android-wifi-lock
Allows an application to keep the Wi-Fi radio awake. Normally the Wi-Fi radio may turn off when the user has not used the device in a while. Acquiring a WifiLock will keep the radio on until the lock is released. Multiple applications may hold WifiLocks, and the radio will only be allowed to turn off when no WifiLocks are held in any application.

### Supported Platforms

- Android

## Installation

    cordova plugin add cordova-plugin-android-wifi-lock --save

### Methods

- `WiFiLock.acquire() <Promise>` Locks the Wi-Fi radio on until release() is called.
- `WiFiLock.isHeld() <Promise>` Checks whether this WifiLock is currently held.
- `WiFiLock.release() <Promise>` Unlocks the Wi-Fi radio, allowing it to turn off when the device is idle.

