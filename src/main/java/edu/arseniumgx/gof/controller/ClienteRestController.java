package edu.arseniumgx.gof.controller;

import edu.arseniumgx.gof.model.Cliente;
import edu.arseniumgx.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
  @Autowired
  private ClienteService service;

  @GetMapping
  public ResponseEntity<Iterable<Cliente>> buscarTodos() {
    return ResponseEntity.ok(service.buscarTodos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PostMapping
  public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
    service.inserir(cliente);
    return ResponseEntity.ok(cliente);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
    service.atualizar(id, cliente);
    return ResponseEntity.ok(cliente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
    service.deletar(id);
    return ResponseEntity.ok().build();
  }
}
