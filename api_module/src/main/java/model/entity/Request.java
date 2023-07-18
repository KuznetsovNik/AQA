package model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Модель запроса
 */
@Getter
@Builder(builderMethodName = "add")
public class Request {
    @NonNull
    private final HttpMethod method;
    @Builder.Default
    private final String endpoint = "";
    @Builder.Default
    private final ReqHeaders<?, ?> headers = new ReqHeaders<>();
    @Builder.Default
    private final ReqParams<?, ?> params = new ReqParams<>();
    @Builder.Default
    private final Object body = "";
}