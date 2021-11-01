// Importando o React
import React from "react";
// Importando os components necessários da lib react-materialize
import { Navbar, NavItem, Row} from 'react-materialize';


const Header = () => (
  <Row>  
   <Navbar className="red lighten-4">

<NavItem href='/'>Home</NavItem>
<NavItem href='/'>Sobre Nós</NavItem>
<NavItem href='/'>Contato</NavItem>
<NavItem href='/client'>Cadastre-se</NavItem>
<NavItem href='/'>Login</NavItem>
<NavItem href='/'>🍨 Bolas de Neve 🍨</NavItem>
    </Navbar>
  </Row>
);

export default Header;