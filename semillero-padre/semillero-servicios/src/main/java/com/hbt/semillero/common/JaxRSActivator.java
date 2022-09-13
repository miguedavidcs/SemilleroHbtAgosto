package com.hbt.semillero.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.hbt.semillero.rest.GestionarComicRest;
import com.hbt.semillero.rest.SemilleroJPQLRest;

@ApplicationPath("/rest")
public class JaxRSActivator extends Application {
	@Override
	   public Set<Class<?>> getClasses() {
	      Set<Class<?>> classes = new HashSet<>();
	      classes.add(SemilleroJPQLRest.class);
	      classes.add(GestionarComicRest.class);
	    //  classes.add(Gestionar.class);
	      return classes;
	}

}
