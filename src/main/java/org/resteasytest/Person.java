package org.resteasytest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrej Galád <agalad@redhat.com>
 */
@XmlRootElement
public class Person {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
