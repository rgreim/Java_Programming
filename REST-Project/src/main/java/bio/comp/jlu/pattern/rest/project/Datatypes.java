package bio.comp.jlu.pattern.rest.project;

import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rgreim
 */
public class Datatypes {

    private final List<Datatype> datatype;

     @JsonCreator
    public Datatypes(@JsonProperty("datatype") List<Datatype> datatype)
    {
      this.datatype = Collections.unmodifiableList(datatype);
    }
    
    public List<Datatype> getDatatype() {
        return datatype;
    }

}
