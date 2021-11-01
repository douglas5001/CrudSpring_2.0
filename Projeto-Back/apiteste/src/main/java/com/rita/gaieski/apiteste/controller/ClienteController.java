package com.rita.gaieski.apiteste.controller;


import com.rita.gaieski.apiteste.model.ClienteEntity;
import com.rita.gaieski.apiteste.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class  ClienteController {  //classe controladora

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> findAll (){  // get
        return new ResponseEntity<List<ClienteEntity>>(
                (List<ClienteEntity>) this.clienteRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);//error 404
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable ("id") long id) {
        if(this.clienteRepository.findById(id).isPresent()){
            return new ResponseEntity<ClienteEntity>(
                    this.clienteRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<ClienteEntity>(HttpStatus.NOT_FOUND);
    }

    // criando o método para salvar...enviando um novo objeto - criando um novo
    @PostMapping
    public ResponseEntity<ClienteEntity> save (@RequestBody ClienteEntity clienteEntity) {
        System.out.println("CHEGOU NA API " + clienteEntity);

        return new ResponseEntity<ClienteEntity> (
                this.clienteRepository.save(clienteEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }

    // criando o método para atualizar...vai analisar se existe e depois salvar
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> update (@PathVariable("id") long id,
                                                        @RequestBody ClienteEntity clienteEntity) throws Exception {

        if(id == 0 || !this.clienteRepository.existsById(id)){
            throw  new Exception("Código não encontrado ou inexistente!");

        }
        return new ResponseEntity<ClienteEntity>(
                this.clienteRepository.save(clienteEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    // criando o método para deletar...

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> delete (@PathVariable("id") long id ){
        this.clienteRepository.deleteById(id);
        return new ResponseEntity<ClienteEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}// fim da classe


// HTTP - POST, GET, PUT, DELETE
// /CLIENTES CADASTRAR - ENVIAR OS DADOS.... POST
// /CLIENTES  CONSULTAR - CONSULTAR OS DADOS ....GET
