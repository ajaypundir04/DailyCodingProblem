package tutorials.coding.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class MapUtils {

    public static <K, V> Map<K, V> of(K key, V value) {
        return toMap(
                Entry.of(key, value)
        );
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        return toMap(
                Entry.of(k1, v1),
                Entry.of(k2, v2)
        );
    }

    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return Entry.of(key, value);
    }

    public static <K, V> Map<K, V> ofEntries(Map.Entry<K, V>... entries) {
        return toMap(entries);
    }

    private static <K, V> Map<K, V> toMap(Map.Entry<K, V>... entries) {
        Map<K, V> map = new HashMap<>();
        Arrays.stream(entries).forEach(e -> map.put(e.getKey(), e.getValue()));
        return map;
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        static <K1, V1> Entry<K1, V1> of(K1 k, V1 v) {
            return new Entry<>(k, v);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return getValue();
        }
    }
}
