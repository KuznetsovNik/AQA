package model.entity;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

/**
 * Модель параметров для параметризированных запросов
 */
@Getter
public class ReqPathParams<K, V> {
    private final Map<String, Object> params = new HashMap<>();

    public ReqPathParams<K, V> add(String key, Object value) {
        params.put(key, value);
        return this;
    }
}