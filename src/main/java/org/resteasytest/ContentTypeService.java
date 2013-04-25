package org.resteasytest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Andrej Galád <agalad@redhat.com>
 */
@Path("/content_type")
public class ContentTypeService {
    
    @GET
    public Person get() {
        
        Person pepa = new Person();
        pepa.setName("pepa");
        return pepa;
    }
}
