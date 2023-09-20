package org.beaverass.app.util;

import java.security.SecureRandom;

public class RandomIntGenerator {
    private final static SecureRandom secureRandom = new SecureRandom();

    public static int generate(int bound, int min){
        return secureRandom.nextInt(bound) + min;
    }

}
