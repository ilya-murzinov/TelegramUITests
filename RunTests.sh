adb push ./bin/TelegramUITests.jar /data/local/tmp/
adb shell uiautomator runtest /data/local/tmp/TelegramUITests.jar -c org.telegram.tests.Tests
