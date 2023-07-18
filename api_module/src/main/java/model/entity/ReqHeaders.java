package model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Модель заголовков запроса
 */
@Getter
@NoArgsConstructor
public class ReqHeaders<K, V> {

    private final Map<String, Object> headers = new HashMap<>();

    public ReqHeaders(String key, Object value) {
        headers.put(key, value);
    }

    public ReqHeaders<K, V> add(String key, Object value) {
        headers.put(key, value);
        return this;
    }

    public ReqHeaders<K, V> delete() {
        headers.clear();
        return this;
    }

    public ReqHeaders<K, V> removeKey(String key) {
        headers.remove(key);
        return this;
    }
}