package com.lamin.organization.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamin.organization.event.source.SimpleSourceBean;
import com.lamin.organization.models.Organization;
import com.lamin.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository orgRepository;
    
    @Autowired
    SimpleSourceBean simpleSourceBean;

    public Optional<Organization> getOrg(String organizationId) {

        return orgRepository.findById(organizationId);
    }

    public void saveOrg(Organization org){

        org.setId( UUID.randomUUID().toString());
        orgRepository.save(org);
        simpleSourceBean.publishOrgChange("SAVE", org.getId()); 
    }

    public void updateOrg(Organization org){

        orgRepository.save(org);
        simpleSourceBean.publishOrgChange("UPDATE", org.getId()); 
    }

    public void deleteOrg(Organization org){

        orgRepository.deleteById( org.getId());
        simpleSourceBean.publishOrgChange("DELETE", org.getId()); 
    }

	public Iterable<Organization> getAll() {

		return orgRepository.findAll();		
	}
}