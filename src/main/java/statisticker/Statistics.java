package statisticker;

import java.util.Collections;
import java.util.List;

public class Statistics {
    public static void main(String[] args) {

    }

    public static Stats getStatistics(List<Float> numbers) {
        Stats stats = new Stats(numbers);
        return stats;
    }

    public static class Stats {

        public Stats(List<Float> numbers) {
            Collections.sort(numbers);
            this.min = getMinValue(numbers);
            this.max = getMaxValue(numbers);
            this.average = getAverageValue(numbers);
        }

        public float average;
        public float min;
        public float max;

        private Float getMinValue(List<Float> numbers) {
            if(numbers.isEmpty())
                return Float.NaN;
            return numbers.get(0);
        }

        private Float getMaxValue(List<Float> numbers) {
            if(numbers.isEmpty())
                return Float.NaN;
            return numbers.get(numbers.size() - 1);
        }

        private Float getAverageValue(List<Float> numbers) {
            if(numbers.isEmpty())
                return Float.NaN;
            Float sum = 0.0f;
            Float avg;
            for (int i = 0; i < numbers.size(); i++)
                sum += numbers.get(i);
            avg = sum / numbers.size();
            return avg;
        }
    }


}
