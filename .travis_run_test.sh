#!/bin/sh

adb install app/org.telegram.android-2.apk
adb push bin/TelegramUITests.jar /data/local/tmp
a=$(adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests | grep 'FAILURES!!!')
if [ -z ${a} ]; then
    echo 'All tests passed!'
    exit 0;
fi
echo 'One or more tests failed!'
exit 1;