package common.config;

import org.aeonbits.owner.ConfigFactory;

public final class AppConfigProvider {

    private static AppConfig config;

    private AppConfigProvider() {
        throw new IllegalStateException("AppConfigProvider shouldn't be instantiated");
    }

    public static AppConfig get() {
        if (config == null) {
            config = ConfigFactory.create(AppConfig.class, System.getProperties());
        }

        return config;
    }
}