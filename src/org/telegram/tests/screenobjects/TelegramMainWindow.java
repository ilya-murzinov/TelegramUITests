package org.telegram.tests.screenobjects;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import org.telegram.tests.FindBy;

/**
 * Created by ilya-murzinov on 25.01.14.
 */
public class TelegramMainWindow {
    private UiObject telegramIcon;
    private UiObject telegramText;
    private UiObject searchButton;
    private UiObject writeToContactButton;
    private UiObject menuButton;
    private UiObject[] menuItems;
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
    public ContactsWindow clickWriteToContactButton() throws UiObjectNotFoundException {
        writeToContactButton.click();
        return ContactsWindow.getInstance();
    }
    public TelegramMainWindow clickMenuButton() throws UiObjectNotFoundException {
        menuButton.click();
        menuItems = new UiObject[]{
                FindBy.resourceIdAndText("android:id/title", "Новая группа"),
                FindBy.resourceIdAndText("android:id/title", "Новый секретный чат"),
                FindBy.resourceIdAndText("android:id/title", "Контакты"),
                FindBy.resourceIdAndText("android:id/title", "Внешний вид"),
                FindBy.resourceIdAndText("android:id/title", "Настройки")
        };
        return getInstance();
    }
    public ContactsWindow selectContactsMenuItem() throws UiObjectNotFoundException {
        clickMenuButton();
        menuItems[2].click();
        return ContactsWindow.getInstance();
    }
    public NewGroupWindow selectNewGroupMenuItem() throws UiObjectNotFoundException {
        clickMenuButton();
        menuItems[0].click();
        return NewGroupWindow.getInstance();
    }
    public TelegramMainWindow exitMenu() {
        UiDevice.getInstance().pressBack();
        menuItems = null;
        return getInstance();
    }
}
