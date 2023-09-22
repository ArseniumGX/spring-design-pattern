package edu.arseniumgx.gof.service;

import edu.arseniumgx.gof.interfaces.ICliente;
import edu.arseniumgx.gof.interfaces.IViaCep;
import edu.arseniumgx.gof.model.Cliente;
import edu.arseniumgx.gof.model.Endereco;
import edu.arseniumgx.gof.repository.ClienteRepository;
import edu.arseniumgx.gof.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService implements ICliente {

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private EnderecoRepository enderecoRepository;
  @Autowired
  private IViaCep viaCep;

  @Override
  public Iterable<Cliente> buscarTodos() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente buscarPorId(Long id) {
    return clienteRepository.findById(id).get();
  }

  @Override
  public void inserir(Cliente cliente) {
    preSaveCliente(cliente);
  }

  @Override
  public void atualizar(Long id, Cliente cliente) {
    Optional<Cliente> clienteBanco = clienteRepository.findById(id);
    if (clienteBanco.isPresent()) {
      preSaveCliente(cliente);
    }
  }

  @Override
  public void deletar(Long id) {
    clienteRepository.deleteById(id);
  }

  private void preSaveCliente(Cliente cliente) {
    String cep = cliente.getEndereco().getCep();
    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
      Endereco novoEndereco = viaCep.consultarCep(cep);
      enderecoRepository.save(novoEndereco);
      return novoEndereco;
    });

    cliente.setEndereco(endereco);
    clienteRepository.save(cliente);
  }
}
