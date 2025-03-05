package htmlelements.utils;

import java.util.UUID;

public class RandomUtils {
    public static String generateRandomEmail(String domain){
        return "testuser+" + UUID.randomUUID().toString().substring(0, 8) + "@" + domain;
    }
}
