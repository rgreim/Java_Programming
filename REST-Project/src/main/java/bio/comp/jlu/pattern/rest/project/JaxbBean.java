/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.rest.project;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rgreim
 */
public class JaxbBean {

    @XmlRootElement
    public class MyJaxbBean {

        public String name;
        public String id;

        public MyJaxbBean() {
        } // JAXB needs this

        public MyJaxbBean(String name, String id) {
            this.name = name;
            this.id = id;
        }
    }
}
