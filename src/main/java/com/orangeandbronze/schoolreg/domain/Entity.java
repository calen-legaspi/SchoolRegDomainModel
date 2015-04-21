package com.orangeandbronze.schoolreg.domain;

/**
 * This implements the 
 * <a href="http://martinfowler.com/eaaCatalog/layerSupertype.html">
 * Layer Supertype
 * </a> pattern for all entities in this domain model. Contains the
 * private key that maps each entity to a database row.
 * 
 * Notice that it's private and final! This means it has to be set by
 * Reflection! This is how Hibernate does it. Implement the JDBC DAOs to set and
 * get this field by Reflection.
 **/
public abstract class Entity {	

	/** Should be set by reflection. Default to zero. **/
	protected final long primaryKey = 0;

}
