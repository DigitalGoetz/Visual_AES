
package aes.utility;

import java.util.Date;
import java.util.Random;

public class RandomGenerator {
    
    private Random random;
    
    private RandomGenerator() {
        random = new Random(new Date().getTime());
    }
    
    public static RandomGenerator getInstance() {
        return INSTANCE;
    }
    
    private static final RandomGenerator INSTANCE = new RandomGenerator();
    
    
    public int getByte(){
        return random.nextInt(256);
    }
}
