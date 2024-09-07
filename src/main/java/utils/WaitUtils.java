package utils;

import org.awaitility.Awaitility;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Component
public class WaitUtils {
    public void waitUntilElementIsVisible(Callable<Boolean> condition){
        Awaitility.await().timeout(5, TimeUnit.SECONDS)
                .pollInterval(5, TimeUnit.MILLISECONDS)
                .until(condition);
    }
}
