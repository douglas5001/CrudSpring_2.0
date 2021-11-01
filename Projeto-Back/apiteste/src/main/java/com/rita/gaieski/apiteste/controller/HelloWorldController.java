package com.rita.gaieski.apiteste.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*Classe Controladora  */


@RestController
public class HelloWorldController {

    //métodos - rotas

    @GetMapping("/")
    public ResponseEntity index(){
        return new ResponseEntity<>(
                "Olá Seja Bem vindo!", HttpStatus.ACCEPTED); //200 Ok
    }
}
