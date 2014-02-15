#!/bin/sh

adb push bin/TelegramUITests.jar /data/local/tmp
adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests