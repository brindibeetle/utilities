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
			return new BsnCheckReturn(2, "Length < 8");
		if (bsn1.length() > 9)
			return new BsnCheckReturn(2, "Length > 9");
		if (bsn1.length() == 8)
			bsn1 = "0" + bsn1;

		Integer bsn2 = Integer.valueOf(bsn1);
		if (bsn2 == 0)
			return new BsnCheckReturn(3, "Not numeric");
		if (bsn2 < 10000000)
			return new BsnCheckReturn(3, "Too small");

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
	}

}
