package nl.lunatech.emile.utilities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.lunatech.emile.utilities.domain.BsnCheckReturn;
import nl.lunatech.emile.utilities.service.BsnService;

@RestController
@RequestMapping("/BSN")
public class BsnController {
	
	@Autowired
	private final BsnService bsnService;
	
    public BsnController(BsnService bsnService) {
    	super();
		this.bsnService = bsnService;
    }

	@GetMapping("/check")
    public BsnCheckReturn check(@RequestParam(value = "bsn", defaultValue = "12") String bsn) {
        return bsnService.check(bsn);
    }
}
