package org.telegram.tests.screenobjects;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import org.telegram.tests.FindBy;

/**
 * Created by ilya-murzinov on 26.01.14.
 */
public class NewGroupWindow {
    private UiObject newGroupButton;
    private UiObject findContactTextBox;
    private UiObject doneButton;
    private UiObject addContactCheckBox;


    private NewGroupWindow() {
        newGroupButton = FindBy.text("Новая группа, Перейти вверх");
        findContactTextBox = FindBy.resourceIdAndClassName("org.telegram.android:id/inputEdit", "android.widget.EditText");
        doneButton = FindBy.resourceId("org.telegram.android:id/doneButton");
        addContactCheckBox = FindBy.resourceId("org.telegram.android:id/contactSelected");
    }

    private static NewGroupWindow instance;
    public static NewGroupWindow getInstance() {
        if (instance == null) instance = new NewGroupWindow();
        return instance;
    }

    public NewGroupWindow addContact(String name) throws UiObjectNotFoundException {
        findContactTextBox.setText(name);
        return getInstance();
    }
    public NewGroupWindow clickDoneButton() throws UiObjectNotFoundException {
        doneButton.click();
        return getInstance();
    }
}
