package nl.lunatech.emile.utilities.service;

import org.springframework.stereotype.Service;

import nl.lunatech.emile.utilities.domain.BsnCheckReturn;

public interface BsnService {

	public BsnCheckReturn check(String bsn) ;
    
}
