#!/bin/sh

#adb push bin/TelegramUITests.jar /data/local/tmp
a=$(adb shell uiautomator runtest TelegramUITests.jar -e class org.telegram.tests.Tests | grep 'FAILURES!!!')
if [ "${a}"=='' ]; then
    exit 0;
fi
exit 1;