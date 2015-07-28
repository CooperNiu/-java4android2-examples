package app15;
import java.util.HashMap;
import java.util.Map;
public class MapDemo1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String value1 = map.get("key1");
    }
}