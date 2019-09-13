package nl.lunatech.emile.utilities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.lunatech.emile.utilities.domain.CodeValue;
import nl.lunatech.emile.utilities.repository.CodeValueRepository;

@RestController
@RequestMapping("/CodeValue")
public class CodeValueController {

	@Autowired
	CodeValueRepository repository;
	
	@PostMapping("/save")
	public String save(@RequestBody CodeValue codevalue) {
		repository.save(codevalue);
		return "codevalue " + codevalue + " is saved.";
	}
	@GetMapping("/retrieve1")
	public CodeValue findByCode(@RequestParam(value="code", defaultValue="nn") String code) {
		return repository.findByCode(code);
	}
	@GetMapping("/retrieveContaining")
	public List<CodeValue> findByCodeContaining(@RequestParam(value="code", defaultValue="nn") String code) {
		return repository.findByCodeContaining(code);
	}
	@GetMapping("/retrieveAll")
	public List<CodeValue> findAll() {
		return repository.findAll();
	}
}
