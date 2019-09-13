package nl.lunatech.emile.utilities.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CodeValue {

	@Id
	private String code;
	private String value;

	public CodeValue() {
		super();
	}

	public CodeValue(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CodeValue [code=" + code + ", value=" + value + "]";
	}

}
