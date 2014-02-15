#!/bin/sh

adb push bin/TelegramUITests.jar /data/local/temp
adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests