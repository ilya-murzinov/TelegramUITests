/**
 * Created by ilya-murzinov on 18.12.13.
 */
package org.telegram.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Tests extends UiAutomatorTestCase{

    public void test() throws UiObjectNotFoundException {
        findAndRunApp();
    }

    private void findAndRunApp() throws UiObjectNotFoundException {
        try {
            FindBy.resourceId("com.android.launcher:id/cling_dismiss").click();
        }
        catch (UiObjectNotFoundException ex) {

        }

        FindBy.classNameAndDescription("android.widget.TextView", "Apps").click();

        try {
            FindBy.resourceId("com.android.launcher:id/cling_dismiss").click();
        }
        catch (UiObjectNotFoundException ex) {

        }

        new UiObject(new UiSelector().className("android.widget.TextView").text("Messaging")).click();
    }
}