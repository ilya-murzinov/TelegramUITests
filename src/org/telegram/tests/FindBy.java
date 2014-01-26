package org.telegram.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;

/**
 * Created by ilya on 26.01.14.
 */
public class FindBy {
    public static UiObject resourceId(String id) {
        return new UiObject(new UiSelector().resourceId(id));
    }
    public static UiObject text(String text) {
        return new UiObject(new UiSelector().text(text));
    }
    public static UiObject className(String className) {
        return new UiObject(new UiSelector().className(className));
    }
    public static UiObject classNameAndDescription(String className, String desc) {
        return new UiObject(new UiSelector().className(className).description(desc));
    }
    public static UiObject resourceIdAndText(String id, String text) {
        return new UiObject(new UiSelector().resourceId(id).text(text));
    }
    public static UiObject resourceIdAndClassName(String id, String className) {
        return new UiObject(new UiSelector().resourceId(id).className(className));
    }
}
