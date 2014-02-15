#!/bin/sh

adb push bin/TelegramUITests.jar /data/local/tmp
adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests | grep 'FAILURES!!!' &> /dev/null
if [$? != 0]; then
    exit 0
fi