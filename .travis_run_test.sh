#!/bin/bash

adb install app/org.telegram.android-2.apk
adb push bin/TelegramUITests.jar /data/local/tmp
adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests
echo $?
if [[ "FAILURES!!!" =~ "$?" ]]
then
    echo 'One or more tests failed!'
    exit 1;
fi
echo 'All tests passed!'
exit 0;
