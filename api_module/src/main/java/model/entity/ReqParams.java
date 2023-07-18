package model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Модель параметров запроса
 */
@Getter
@NoArgsConstructor
public class ReqParams<K, V> {

    private final Map<String, Object> params = new HashMap<>();

    public ReqParams(String key, Object value) {
        params.put(key, value);
    }

    public ReqParams<K, V> add(String key, Object value) {
        params.put(key, value);
        return this;
    }
}