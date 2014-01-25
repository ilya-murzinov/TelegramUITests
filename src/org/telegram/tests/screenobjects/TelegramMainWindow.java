package org.telegram.tests.screenobjects;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

/**
 * Created by ilya on 25.01.14.
 */
public class TelegramMainWindow {
    private UiObject telegramIcon;
    private UiObject telegramText;
    private UiObject searchButton;
    private UiObject writeToContactButton;
    private UiObject menuButton;
    private UiObject dialogListLayout;

    //Automatically performs smoke test
    private TelegramMainWindow() {
        telegramIcon = new UiObject(new UiSelector().resourceId("android:id/home")
                .className("android.widget.ImageView"));
        telegramText = new UiObject(new UiSelector().resourceId("android:id/action_bar_title")
                .text("Telegram"));
        searchButton = new UiObject(new UiSelector().resourceId("org.telegram.android:id/searchMenu"));
        writeToContactButton = new UiObject(new UiSelector().resourceId("org.telegram.android:id/writeToContact"));
        menuButton = new UiObject(new UiSelector().className("android.widget.ImageButton").description("Ещё"));
        dialogListLayout = new UiObject(new UiSelector().resourceId("org.telegram.android:id/dialogsList"));
    }

    private static TelegramMainWindow instance;
    public static TelegramMainWindow getInstance() {
        if (instance == null) instance = new TelegramMainWindow();
        return instance;
    }

    public SearchWindow clickSearchButton() throws UiObjectNotFoundException {
        searchButton.click();
        return SearchWindow.getInstance();
    }
    public WriteToContactWindow clickWriteToContactButton() throws UiObjectNotFoundException {
        writeToContactButton.click();
        return WriteToContactWindow.getInstance();
    }
}
