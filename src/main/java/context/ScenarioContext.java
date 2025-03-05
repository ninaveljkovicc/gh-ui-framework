package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private static Map<String, Object> contextData;

    private ScenarioContext() {
    }

    static {
        contextData = new HashMap<>();
    }

    public static synchronized ScenarioContext getInstance(){
        if(instance == null){
            instance = new ScenarioContext();
        }
        return instance;
    }

    public <T> T get(String key, Class<T> clazz){
        Object value = contextData.get(key);
        if(value != null && clazz.isInstance(value)){
            return clazz.cast(value);
        }
        return null;
    }

    public void put(String key, Object value){
        contextData.put(key, value);
    }

    public void remove(String key) {
        contextData.remove(key);
    }

    public void removeAll() {
        contextData.clear();
    }
}
