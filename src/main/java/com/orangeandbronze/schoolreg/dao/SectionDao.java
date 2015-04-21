package com.orangeandbronze.schoolreg.dao;

import java.util.Collection;

import com.orangeandbronze.schoolreg.domain.Section;

public interface SectionDao {

	public Section findById(String sectionNumber);

	public Collection<Section> findAll() ;
	
}
