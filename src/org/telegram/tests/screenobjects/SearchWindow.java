package org.telegram.tests.screenobjects;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

/**
 * Created by ilya-murzinov on 25.01.14.
 */
public class SearchWindow {
    private UiObject telegramIcon;

    private SearchWindow() {
        telegramIcon = new UiObject(new UiSelector().resourceId("android:id/home")
                .className("android.widget.ImageView").packageName("org.telegram.android"));
    }
    private static SearchWindow instance;
    public static SearchWindow getInstance() {
        if (instance == null) instance = new SearchWindow();
        return instance;
    }

    public TelegramMainWindow clickTelegramIcon() throws UiObjectNotFoundException {
        telegramIcon.click();
        return TelegramMainWindow.getInstance();
    }
}