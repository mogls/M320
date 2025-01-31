package Ui;

import java.util.HashMap;
import java.util.Set;

public abstract class UiInteractiveItem<T> {

    private HashMap<String, T> interactiveItemMap = new HashMap<>();

    public void add(String key, T value) {
        this.interactiveItemMap.put(key, value);
    }

    public T get(String key) {
        return this.interactiveItemMap.get(key);
    }

    public Set<String> getKeys() { return this.interactiveItemMap.keySet(); }

}
