package org.telegram.tests.screenobjects;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiDevice;
import org.telegram.tests.FindBy;

/**
 * Created by ilya-murzinov on 25.01.14.
 */
public class ContactsWindow {
    private UiObject contactsButton;
    private UiObject searchButton;
    private UiObject menuButton;
    private UiObject searchTextBox;
    private UiObject telegramIcon;
    private UiObject[] menuItems;

    private ContactsWindow() {
        contactsButton = FindBy.resourceIdAndText("android:id/action_bar_title", "Контакты");
        searchButton = FindBy.resourceId("org.telegram.android:id/searchMenu");
        menuButton = FindBy.classNameAndDescription("android.widget.ImageButton", "Ещё");
    }
    private static ContactsWindow instance;
    public static ContactsWindow getInstance() {
        if (instance == null) instance = new ContactsWindow();
        return instance;
    }

    public TelegramMainWindow clickContactsButton() throws UiObjectNotFoundException {
        contactsButton.click();
        return TelegramMainWindow.getInstance();
    }
    public ContactsWindow clickSearchButton() throws UiObjectNotFoundException {
        searchButton.click();
        searchTextBox = FindBy.resourceId("org.telegram.android:id/abs__search_src_text");
        telegramIcon = FindBy.resourceIdAndClassName("android:id/home", "android.widget.ImageView");
        return getInstance();
    }
    public ContactsWindow search(String name) throws UiObjectNotFoundException {
        searchTextBox.setText(name);
        return getInstance();
    }
    public ContactsWindow exitSearch() throws UiObjectNotFoundException {
        telegramIcon.click();
        searchTextBox = null;
        telegramIcon = null;
        return getInstance();
    }
    public ContactsWindow clickMenu() throws UiObjectNotFoundException {
        menuButton.click();
        menuItems = new UiObject[]{
                FindBy.resourceIdAndText("Только из Телеграма", "android:id/title"),
                FindBy.resourceIdAndText("Добавить контакт", "android:id/title"),
                FindBy.resourceIdAndText("Телефонная книга", "android:id/title")
        };

        return getInstance();
    }
    public ContactsWindow exitMenu() {
        UiDevice.getInstance().pressBack();
        menuItems = null;
        return getInstance();
    }
}
