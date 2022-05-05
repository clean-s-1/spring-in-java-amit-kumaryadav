package statisticker;

import statisticker.alerts.EmailAlert;
import statisticker.alerts.IAlerter;
import statisticker.alerts.LEDAlert;

import java.util.List;

public class StatsChecker {
    public float maxThreshold;
    public IAlerter[] iAlerters;

    StatsChecker(float maxThreshold, IAlerter[] iAlerters) {
        this.maxThreshold = maxThreshold;
        this.iAlerters = iAlerters;
    }

    public void checkAndAlert(List<Float> numbers) {
        for (float number : numbers) {
            if (this.maxThreshold > number) {
                for (IAlerter iAlerter : iAlerters) {
                    if (iAlerter instanceof EmailAlert) {
                        ((EmailAlert) iAlerter).emailSent = true;
                    }
                    if (iAlerter instanceof LEDAlert) {
                        ((LEDAlert) iAlerter).ledGlows = true;
                    }
                }
                 break;
            }
        }
    }
}
