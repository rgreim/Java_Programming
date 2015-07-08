package bio.comp.jlu.pattern.sequenzdesignpatterns;

import bio.comp.jlu.sequence.SequenceGenerator;
import json_export_import.GSON_Observer;
import parserpackage.*;

/**
 * Starting point of program that processes sequences.
 *
 * @author rgreim
 */
public class Main {

    public static void main(String[] args) {
        final SequenceGenerator sg = new SequenceGenerator(100);
        final CountProcessor countProcessor = new CountProcessor();
        final StatisticProcessor statisticProcessor = new StatisticProcessor();
        final GSON_Observer gsonOb = new GSON_Observer();
        Observer view = new Observer() {

            @Override
            public void update(SequenceProcessor seqPro) {
                System.out.println(String.format("Count: %d\tTotal length: %d\tmin Length: %d\tmax Length: %d\tmean Length: %d",
                                                 countProcessor.getCount(),
                                                 statisticProcessor.getTotal(),
                                                 statisticProcessor.getMin(),
                                                 statisticProcessor.getMax(),
                                                 statisticProcessor.getMean()));
            }
        };
        
        countProcessor.addObserver(view);
        statisticProcessor.addObserver(view);

        for (String str : sg) {
            countProcessor.processSequence(str);
            statisticProcessor.processSequence(str);
            gsonOb.write(str);
        }
        gsonOb.read();
        Parser parserfastq = new ParserFastq();
        //parserfastq.parse(args[0]);
        ParserFasta parserfasta = new ParserFasta();
        //parserfastq.parse(args[0]);

    }
}
