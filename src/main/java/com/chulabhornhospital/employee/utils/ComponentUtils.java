package com.chulabhornhospital.employee.utils;

import java.awt.*;

public class ComponentUtils {

    interface Action {
        void execute(Component component);
    }

    private static void traverse(Container container, Action action) {
        for (Component component : container.getComponents()) {
            action.execute(component);
            if (component instanceof Container) {
                traverse((Container) component, action);
            }
        }
    }

    public static void disableAll(Container container) {
        traverse(container, (c) -> c.setEnabled(false));
    }

    public static void enableAll(Container container) {
        traverse(container, (c) -> c.setEnabled(true));
    }

    public static void hideAll(Container container) {
        traverse(container, (c) -> c.setVisible(false));
    }

    public static void showAll(Container container) {
        traverse(container, (c) -> c.setVisible(true));
    }

}
