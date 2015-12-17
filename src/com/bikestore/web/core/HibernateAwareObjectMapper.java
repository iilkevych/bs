package com.bikestore.web.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1928033184535678974L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}