package com.test;

/**
 * Abstract factory class which creates a singleton ObjectFactory dynamically based on factory name.
 * @author Angelo Huang
 *
 */
public class ObjectFactorySelector<K, V> {
	private static ObjectFactory objectFactorySingle = null;	
	
	public static ObjectFactory getObjectFactory(String FACTORY_NAME){
		try {
			if (objectFactorySingle == null) {
				Class klassFactory = Class.forName(FACTORY_NAME);
				objectFactorySingle = (ObjectFactory)klassFactory.newInstance();				
			}
			
		} catch (ClassNotFoundException cnf) {
			throw new RuntimeException("Failed to create the ObjectFactory: " + cnf.getMessage());
		} catch (IllegalAccessException iae) {
			throw new RuntimeException("Failed to create the ObjectFactory: " + iae.getMessage());
		} catch (InstantiationException ie) {
			throw new RuntimeException("Failed to create the ObjectFactory: " + ie.getMessage());
		}
		
		return objectFactorySingle;		
	}
	
}