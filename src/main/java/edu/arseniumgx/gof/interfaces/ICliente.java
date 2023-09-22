package edu.arseniumgx.gof.interfaces;

import edu.arseniumgx.gof.model.Cliente;

public interface ICliente {
  Iterable<Cliente> buscarTodos();
  Cliente buscarPorId(Long id);
  void inserir(Cliente cliente);
  void atualizar(Long id, Cliente cliente);
  void deletar(Long id);
}
