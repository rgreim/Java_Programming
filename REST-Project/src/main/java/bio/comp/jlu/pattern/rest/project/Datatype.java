/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.rest.project;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author rgreim
 */
public class Datatype {

    private final String id;
    private final String name;

    @JsonCreator
    public Datatype(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() {
        return id;
    }

//    public void setID(String upId) {
//        this.id = upId;
//    }
    public String getName() {
        return name;
    }

//    public void setName(String upName) {
//        this.name = upName;
//    }
}
