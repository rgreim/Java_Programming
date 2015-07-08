/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.comp.jlu.pattern.rest.project;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.util.List;

/**
 *
 * @author rgreim
 */
public class MiriamRestClient {

    public static void main(String[] args) {

        // initialisation
        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://www.ebi.ac.uk/miriamws/main/rest/").build());

        // GET queries
        System.out.println("GET (XML):\n" + service.path("datatypes").accept(MediaType.APPLICATION_XML).get(String.class));
        List<Datatype> datatype = service.path("datatypes").accept(MediaType.APPLICATION_JSON).get(Datatypes.class).getDatatype();

        for (Datatype datatype1 : datatype) {
            System.out.print(datatype1.getID() + " ");
            System.out.println(datatype1.getName());
        }
    }
}
