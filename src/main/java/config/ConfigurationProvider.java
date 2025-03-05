package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationProvider {
    private static final EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
    private static final RunConfiguration runConfiguration = ConfigFactory.create(RunConfiguration.class);

    public static EnvironmentConfig getEnvironmentConfig(){
        return environmentConfig;
    }

    public static RunConfiguration getRunConfiguration(){
        return runConfiguration;
    }
}
