import { http } from '../api'

/*
  Aqui estão todos os métodos/rotas que existem na classe cliente.controller.java
*/

export default {

  findAll: () => {
    return http.get('clientes');
  },

  save: (cliente) => {
    return http.post('clientes', cliente);
  },

  findById: (cliente) => {
    return http.get('clientes/${cliente.id}', {data: cliente});
  },

  delete: (cliente) => {
    return http.delete('clientes/${cliente.id}',{data: cliente});
  },

  update: (cliente) => {
    return http.put ('clientes', cliente);
  },
}
