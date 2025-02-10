import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    private static class TimeValue {
        int timestamp;
        String value;

        public TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimeValue> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new TimeValue(timestamp, value));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<TimeValue> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + ((r - l) / 2);
            TimeValue midPair = list.get(m);

            if (midPair.timestamp < timestamp) {
                res = midPair.value;
                l = m + 1;
            }
            else if (midPair.timestamp > timestamp) {
                r = m - 1;
            }
            else {
                return midPair.value;
            }
        }

        return res;
    }
}
