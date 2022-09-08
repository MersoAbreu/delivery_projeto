# Projeto delivery
### Bem vindo👋

<h3>Tecnologias utilizadas neste projeto</h3>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="40" height="40" /><spam>Java</spam> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="40" height="40" /><spam>git Hub</spam><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"  width="40" height="40"/><spam>SpringBoot</spam><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/firebase/firebase-plain.svg" width="40" height="40" /><spam>Firebird</spam>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg"  width="40" height="40" /><spam>MySQL</spam>

<h4>Ferramentas de desenvolvimento</h4>
<ul>
<li>Eclipse ou Dev Tools Suite (IDE)</li>
<li>Java Versão 8)</li>
<li>JPA e Hibernate</li>
<li>Postman ou Insomnia (Persistencia de dados JSON)</li>
<li>Maven</li>
</ul>


<h4>Configuração de ambiente</h4>
<p>Ao clonar o projeto, abra sua IDE de escolha e importe o projeto conforme imagem (click no link)</p>
![image](https://user-images.githubusercontent.com/34317980/189182500-87dd328a-8431-46e3-94c2-3247b0368cc3.png)

<p>O maven irá importar as dependencias, e deixar o ambiente configurado, as configurações de banco de dados se encontram no aplication.properties</p>

<h4>Configuração de banco de dados</h4>
<p>Voce pode escolher entre os seguintes bancos de dados para a aplicação, MYSQL ou Firebird</p>
<p>Ambas necessitam que seja criado o schema delivery, que é o schema descrito no aplication.properties</p>
<p>A senha necessita ser alterada no appplication.properties de acordo com a senha do seu banco de dados local</p>


<h4>Start no Projeto</h4>
<p>Apos todos os procedimentos seguidos, em sua IDE start o projeto, ao startar todas as tuplas do banco de dados serão criadas automaticamente./p>
 
 
<h4>Swagger</h4>

<p>Para visualizar as API, o swagger esta habilitado basta clicar neste link para que ele seja apresentado</p>
<a href="http://localhost:8080/delivery/swagger-ui.html">Swagger</a>


 
<h4>API's </h4>
<p>O projeto consiste de 3 APIs, sendo elas:</p>
<ul>
 <li>
  <h5>cliente-controller</h5>
   <ul>
      <h7>Metodos HTTP</h7>
       <li>Get --> /clientes</li>
       <li>Post --> /clientes</li>
       <li>Get --> /clientes/{id} </li>
       <li>Put --> /clientes/{id} </li>
        <li>Delete --> /clientes/{id} </li>
  </ul>
 </li>
  <li>
  <h5>entrega-controller</h5>
   <ul>
       <h7>Metodos HTTP</h7>
       <li>Get --> /entregas</li>
       <li>Post --> /entregas</li>
       <li>Get --> /entregas/{id} </li>
       <li>Put --> /entregas/{id} </li>
       <li>Delete --> /entregas/{id} </li>
  </ul>
 </li>
  <li>
  <h5>pedido-controller</h5>
   <ul>
       <h7>Metodos HTTP</h7>
       <li>Get --> /pedidos</li>
       <li>Post --> /pedidos</li>
       <li>Get --> /pedidos/{id} </li>
       <li>Put --> /pedidos/{id} </li>
       <li>Delete --> /pedidos/{id} </li>
  </ul>
 </li>
</ul>

<h4>Arquivos insominia</h4>
<p> Para facilitar dentro da pasta assets existe um arquivo com os JSON's pré definido para cada chamada via Postman ou Insomnia
