package Ui;

import java.util.HashMap;

public abstract class UiInteractiveItem<T> {

    private HashMap<String, T> interactiveItemMap = new HashMap<>();

    public void add(String key, T value) {
        this.interactiveItemMap.put(key, value);
    }

    public T get(String key) {
        return this.interactiveItemMap.get(key);
    }

}
