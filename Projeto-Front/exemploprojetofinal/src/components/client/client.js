// Importando o React
import React, { useEffect, useState } from "react";
import Cliente from "../../services/cliente";
// Importando os components necessários da lib react-materialize
import { Row, Col, Card, Input, Button } from 'react-materialize';

/* componente para  cadastrar e  buscar cliente*/

export default function Client() {
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [email, setEmail] = useState('');
  const [clientes, setClientes] = useState([]);
  
  useEffect(() => {
    buscar()
  });

  function handleNomeChange(evt) {
    setNome(evt.target.value);
  }

  function handleCpfChange(evt) {
    setCpf(evt.target.value);
  }

  function handleEmailChange(evt) {
    setEmail(evt.target.value);
  }

  function clearFields() {
    setNome('');
    setCpf('');
    setEmail('');
  }

  async function cadastrar() {
    let client = {
      nome: nome,
      cpf: cpf,
      email: email
    }

    const response = await Cliente.save(client);

    if (response.status === 201) {
      alert('Cadastrado com sucesso !')
      clearFields();
    } else {
      alert('Erro ao cadastrar...')
    }
  }

  async function buscar() {
    const response = await Cliente.findAll();
    setClientes(response.data);
  }

  return (
    <>
      <Row>
        <Col>
          <h5>Preencha o seu cadastro:</h5>
          <Card>
            <Row>
                <Input 
                  placeholder="Winter Balls da Silva" 
                  type="text" 
                  label="Nome"
                  s={12}
                  value={nome}
                  onChange={handleNomeChange} /> 
                <Input
                  placeholder="ballswinter@gmail.com"
                  type="email"
                  label="Email"
                  s={12}
                  value={email}
                  onChange={handleEmailChange} />
                <Input
                  placeholder="xxx-xxx-xxx/xx"
                  type="text"
                  label="Cpf"
                  s={12}
                  value={cpf}
                  onChange={handleCpfChange} />
              <Col s={12} m={12}>
              <Button waves='light' className="right pink lighten-4">CADASTRE-SE</Button>
              <Button waves='light' className="right pink lighten-4">LIMPAR</Button>
              </Col>
            </Row>
          </Card>
          <Card>
            <Row>
              <thead>
                <tr>
                  <td>código</td>
                  <td>nome</td>
                  <td>email</td>
                  <td>cpf</td>
                </tr>
              </thead>
              <tbody>
              { clientes.length > 0
                ? 
                (
                  clientes.map((cliente) =>
                    <tr key={cliente.id}>
                      <td>{cliente.id}</td>
                      <td>{cliente.nome}</td>
                      <td>{cliente.email}</td>
                      <td>{cliente.cpf}</td>
                    </tr>
                  )
                ) 
                : (
                  <div>Não tem nenhum cliente</div>
                )
              }
              </tbody>
            </Row>
          </Card>
        </Col>
      </Row>   
    </>
  );
}


