package service;

import executor.AbstractApiClient;
import executor.BaseApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Базовый класс для всех сервисов
 * Содержит константу для логирования и объект apiClient для выполнения HTTP-запросов
 *
 * @see Logger
 * @see BaseApiClient
 */
public class BaseApiService {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractApiClient.class);
    protected BaseApiClient apiClient = new BaseApiClient();
}