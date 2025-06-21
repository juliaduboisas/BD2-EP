package com.danceSchool.api.controller;

import com.danceSchool.api.entity.administrativo.Administrativo;
import com.danceSchool.api.entity.administrativo.AdministrativoRepository;
import com.danceSchool.api.entity.funcionario.DataFuncionario;
import com.danceSchool.api.entity.funcionario.Funcionario;
import com.danceSchool.api.entity.funcionario.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/worker")
public class FuncionarioController {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @PostMapping("/add")
    public void addFuncionario(@RequestBody DataFuncionario dataFuncionario){
        Funcionario funcionario = new Funcionario(dataFuncionario, administrativoRepository);
        funcionarioRepository.save(funcionario);
    }

    @GetMapping()
    public List<DataFuncionario> getAllFuncionarios(){
        return funcionarioRepository.findAll()
                .stream()
                .map(DataFuncionario::new) // DESCOBRIR O QUE DIABOS TÁ DANDO ERRADO AQUI
                .toList();
    }

    @GetMapping("/{cpf}")
    public DataFuncionario getFuncionarioByCpf(@PathVariable String cpf){
        return funcionarioRepository.findById(cpf).map(DataFuncionario::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/by-name/{nome}")
    public List<DataFuncionario> getFuncionarioByNome(@PathVariable String nome){
        return funcionarioRepository.findByNomeContaining(nome)
                .stream()
                .map(DataFuncionario::new)
                .toList();
    }

    @GetMapping("/by-adm/{cpfAdm}")
    public List<DataFuncionario> getFuncionarioByCpfAdm(@PathVariable String cpfAdm){
        Administrativo admin = administrativoRepository.getById(cpfAdm);
        return funcionarioRepository.findByCpfAdm(admin)
                .stream()
                .map(DataFuncionario::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateFuncionario(@RequestBody DataFuncionario dataFuncionario){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(dataFuncionario.cpf());

        if(funcionario.isEmpty()){
            throw new EntityNotFoundException("O funcionario buscado não existe ou não foi encontrado");
        }

        funcionario.get().setNome(dataFuncionario.nome());
        funcionario.get().setGenero(dataFuncionario.genero());
        funcionario.get().setDataAdmissao(dataFuncionario.dataAdmissao());
        funcionario.get().setCargo(dataFuncionario.cargo());
        funcionario.get().setSalario(dataFuncionario.salario());
        funcionario.get().setEmail(dataFuncionario.email());
        funcionario.get().setCep(dataFuncionario.cep());
        funcionario.get().setNumero(dataFuncionario.numero());
        funcionario.get().setComplemento(dataFuncionario.complemento());
        funcionario.get().setCpfAdm(administrativoRepository.getReferenceById(dataFuncionario.cpfAdm()));
        funcionarioRepository.save(funcionario.get());
    }

    @DeleteMapping("/delete/{cpf}")
    public void deleteFuncionarioByCpf(@PathVariable String cpf){
        funcionarioRepository.deleteById(cpf);
    }
}
