/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.sequenzdesignpatterns;

/**
 * Interface that defines a function to update data for observers.
 * @author rgreim
 */
public interface Observer {
    public void update(SequenceProcessor seqPro);
}
