/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.sequenzdesignpatterns;

/**
 * Class that implements Observer and updates data for observers via console.
 *
 * @author rgreim
 */
public class Viewer implements Observer {

    @Override
    public void update(SequenceProcessor seqPro) {
        if (seqPro instanceof CountProcessor) {
            ((CountProcessor) seqPro).getCount();
        }
        if (seqPro instanceof StatisticProcessor) {
            ((StatisticProcessor) seqPro).getTotal();
        }

    }
}
