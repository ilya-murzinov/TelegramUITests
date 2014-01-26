/**
 * Created by ilya-murzinov on 18.12.13.
 */
package org.telegram.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import org.telegram.tests.screenobjects.TelegramMainWindow;

public class Tests extends UiAutomatorTestCase{

    public void test() throws UiObjectNotFoundException {
        findAndRunApp();

        TelegramMainWindow.getInstance()
                .clickSearchButton()
                .clickTelegramIcon()
                .clickWriteToContactButton()
                .clickSearchButton()
                .search("123")
                .exitSearch()
                .clickMenu()
                .exitMenu()
                .clickContactsButton()
                .clickMenuButton()
                .exitMenu()
                .selectContactsMenuItem()
                .clickContactsButton();
    }

    private void findAndRunApp() throws UiObjectNotFoundException {
        UiObject settingsApp = new UiObject(new UiSelector()
                .className("android.widget.TextView").text("Телеграм"));
        settingsApp.clickAndWaitForNewWindow();
    }
}