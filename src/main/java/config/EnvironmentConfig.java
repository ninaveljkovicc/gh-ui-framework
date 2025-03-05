package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:environment.properties")
public interface EnvironmentConfig extends Config {
    @Key("homepage.url")
    String homepageUrl();
}
