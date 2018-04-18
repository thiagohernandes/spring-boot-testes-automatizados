package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.domain.Funcionario;
import com.br.repository.FuncionarioRepository;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@ResponseBody
	@PostMapping("/")
	public Funcionario novo(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@ResponseBody
	@GetMapping("/todos")
	public List<Funcionario> todos() {
		return funcionarioRepository.findAll();
	}
	
	@ResponseBody
	@GetMapping(value="/{id}")
	public Funcionario getFuncionario(@PathVariable("id") Integer id) {
		return funcionarioRepository.findOne(id);
	}
	
	@PutMapping(value="/{id}")
	public void putFuncionario(@PathVariable("id") Integer id, 
						@RequestBody Funcionario funcionario) throws java.text.ParseException {
		funcionarioRepository.saveAndFlush(funcionario);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteFuncionario(@PathVariable("id") Integer id) {
		funcionarioRepository.delete(id);
	}

}
