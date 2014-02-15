/**
 * Created by ilya-murzinov on 18.12.13.
 */
package org.telegram.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Tests extends UiAutomatorTestCase{

    public void test() throws UiObjectNotFoundException {
        findAndRunApp();
    }

    private void findAndRunApp() throws UiObjectNotFoundException {
        // Go to main screen
        getUiDevice().pressHome();
        // Find menu button
        UiObject allAppsButton = new UiObject(new UiSelector()
                .description("Apps"));
        // Click on menu button and wait new window
        allAppsButton.clickAndWaitForNewWindow();
        // Find App tab
        UiObject appsTab = new UiObject(new UiSelector()
                .text("Apps"));
        // Click on app tab
        appsTab.click();
        // Find scroll object (menu scroll)
        UiScrollable appViews = new UiScrollable(new UiSelector()
                .scrollable(true));
        // Set the swiping mode to horizontal (the default is vertical)
        appViews.setAsHorizontalList();
        // Find Messaging application
        UiObject settingsApp = appViews.getChildByText(new UiSelector()
                .className("android.widget.TextView"), "Messaging");
        // Open Messaging application
        settingsApp.clickAndWaitForNewWindow();

        // Validate that the package name is the expected one
        UiObject settingsValidation = new UiObject(new UiSelector()
                .packageName("com.android.mms"));
    }
}