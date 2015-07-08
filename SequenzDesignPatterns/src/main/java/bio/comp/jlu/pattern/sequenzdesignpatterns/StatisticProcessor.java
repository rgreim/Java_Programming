/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.sequenzdesignpatterns;

/**
 * A class that inherits from AbstractSequenceProcessor and calculates various
 * statistics. Statistics include Min, Max, Mean and Total length of input
 * string.
 *
 * @author rgreim
 *
 */
public class StatisticProcessor extends AbstractSequenceProcessor {
    private int total;
    private int min;
    private int max;
    private int mean;
    private int count;
    
    public StatisticProcessor() {
        this.count = 0;
        this.mean = 0;
        this.max = 0;
        this.total = 0;
        this.min = Integer.MAX_VALUE;
    }

    public void processStatistics() {
}

public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getTotal() {
        return total;
    }

    public int getMean() {
        return mean;
    }

    @Override
        public void process(String str) {
        int strLength = str.length();
        count++;
        total += strLength;
        min = Math.min(strLength, min);
        max = Math.max(strLength, max);
        mean = total / count;
    }

}
