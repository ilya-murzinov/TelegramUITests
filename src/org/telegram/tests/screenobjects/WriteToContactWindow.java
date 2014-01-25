package org.telegram.tests.screenobjects;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

/**
 * Created by ilya on 25.01.14.
 */
public class WriteToContactWindow {
    private UiObject contactsButton;
    private UiObject searchButton;
    private UiObject menuButton;
    private UiObject searchTextBox;
    private UiObject telegramIcon;

    private WriteToContactWindow() {
        contactsButton = new UiObject(new UiSelector().resourceId("android:id/action_bar_title")
                .text("Contacts"));
        searchButton = new UiObject(new UiSelector().resourceId("org.telegram.android:id/searchMenu"));
        menuButton = new UiObject(new UiSelector().className("android.widget.ImageButton").description("Ещё"));
    }
    private static WriteToContactWindow instance;
    public static WriteToContactWindow getInstance() {
        if (instance == null) instance = new WriteToContactWindow();
        return instance;
    }

    public TelegramMainWindow clickContactsButton() throws UiObjectNotFoundException {
        contactsButton.click();
        return TelegramMainWindow.getInstance();
    }
    public WriteToContactWindow clickSearchButton() throws UiObjectNotFoundException {
        searchButton.click();
        searchTextBox = new UiObject(new UiSelector().resourceId("org.telegram.android:id/abs__search_src_text"));
        telegramIcon = new UiObject(new UiSelector().resourceId("android:id/home")
                .className("android.widget.ImageView"));
        return getInstance();
    }
    public WriteToContactWindow search(String name) throws UiObjectNotFoundException {
        searchTextBox.setText(name);
        return getInstance();
    }
    public WriteToContactWindow exitSearch() throws UiObjectNotFoundException {
        telegramIcon.click();
        searchTextBox = null;
        telegramIcon = null;
        return getInstance();
    }
    public WriteToContactWindow clickMenu() throws UiObjectNotFoundException {
        menuButton.click();
        return getInstance();
    }
}
