package common.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:application.properties"})
public interface AppConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("user.number.phone")
    String userNumberPhone();

    @Key("user.number.pass")
    String userNumberPass();

    @Key("user.passport")
    String userPassport();

    @Key("user.passport.pass")
    String userPassportPass();
}