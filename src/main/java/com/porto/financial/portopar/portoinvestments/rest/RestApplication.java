package com.porto.financial.portopar.portoinvestments.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.porto.financial.portopar.portoinvestments.providers.ThrowableMapper;
import com.porto.financial.portopar.portoinvestments.resource.PersonResource;
import com.porto.financial.portopar.portoinvestments.resource.ZipPostalResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {

    Set<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(JacksonJsonProvider.class);
    classes.add(PersonResource.class);
    classes.add(ZipPostalResource.class);
    classes.add(ThrowableMapper.class);

    return classes;
  }
}
