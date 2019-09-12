package nl.lunatech.emile.utilities.implementation;

import org.springframework.stereotype.Service;

import nl.lunatech.emile.utilities.domain.BsnCheckReturn;
import nl.lunatech.emile.utilities.service.BsnService;

@Service
public class BsnServiceImplementation implements BsnService {

	@Override
	public BsnCheckReturn check(String bsn) {
		
		String bsn1 = bsn.trim();

		if (bsn1.length() < 8)
			return new BsnCheckReturn(2, "Lengte < 8");
		if (bsn1.length() == 8)
			bsn1 = "0" + bsn1;

		int checksum = 0;
		int checkproduct = 10;
		for (char i : bsn1.toCharArray()) {
			checkproduct --;
			if (checkproduct == 1) checkproduct = -1;
			checksum += (i - '0') * checkproduct; 
		}
		if ((checksum % 11) == 0)
			return new BsnCheckReturn(0, "Looks okay");
		else
			return new BsnCheckReturn(1, "Nope");
		//		(9 × A) + (8 × B) + (7 × C) + (6 × D) + (5 × E) + (4 × F) + (3 × G) + (2 × H) + (-1 × I) is divisable by 11
	}

}
