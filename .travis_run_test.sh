#!/bin/sh

adb push bin/TelegramUITests.jar /data/local/tmp
if adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests | grep 'FAILURES!!!'==''; then
    exit 0;
fi
echo 'One or more tests failed!'
exit 1;