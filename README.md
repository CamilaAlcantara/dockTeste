<h1> Análise de Credito - Camila Alcantara </h1>

 ## Tecnologias Usadas: 
  
<table>
  <tr>
   <td>Projeto</td>
   <td>Linguagem</td>
   <td>Spring Boot</td>
   <td>IDE</td>
   <td>Banco de Dados</td>
   <td>Server Port</td>
   <td>Nome da Base de Dados</td>
   <td>User da Base de Dados</td>
   <td>Senha da Base de Dados</td>
  </tr>
   <tr>
   <td>Maven Project</td>
   <td>Java 8</td>
   <td>2.5.5</td>
   <td>IntelliJ IDEA</td>
   <td>Postgres</td>
   <td>2609</td>
   <td>dock</td>
   <td>postgres</td>
   <td>dock</td>
  </tr>
</table>

  <h3> Outras </h3>
  
  1) Lombok
  2) Data JPA
  3) Para realizar os teste de get, post, pull e delete, foi utilizado o Postman para fazer as chamadas.

  
  
 ## Urls utilizadas para testar a API: 
 
  1) LISTAR:
   <table>
       <tr>
        <td>Método</td>
        <td>Url</td>
       </tr>
        <tr>
        <td>GET</td>
        <td>http://localhost:8888/personProposal/listar</td>
       </tr>
     </table>
        
  2) INCLUIR:

  <table>
       <tr>
        <td>Método</td>
        <td>Url</td>
       </tr>
        <tr>
        <td>POST</td>
        <td>http://localhost:8888/personProposal/incluir</td>
       </tr>
     </table>
     <h4>JSON utilizado para incluir</h4>


         
             {
              "address": "Rua numero 20",
              "document": "12345678980",
              "name": "Carlos",
              "lastname": "Gonçalves",
              "phone": "997843278"
             }
         
  
  3) ALTERAR:
  
     <table>
        <tr>
         <td>Método</td>
         <td>Url</td>
        </tr>
         <tr>
         <td>POST</td>
         <td>http://localhost:8888/personProposal/alterar</td>
        </tr>
      </table>

      <h4>JSON utilizado para alterar perfil que aprova crédito </h4>

           
              {
                "id": 1,
               "name": "Carlos",
               "lastname": "Gonçalves",
               "document": "12345678910",
               "dateRequest": "2021-10-11",
               "updateStatusRequest": "2021-10-11",
               "phone": "997843278",
               "address": "Rua numero 20",
               "status": "DISAPPROVED"
               }
           


   4) ALTERAR:

   <table>
      <tr>
       <td>Método</td>
       <td>Url</td>
      </tr>
       <tr>
       <td>POST</td>
       <td>http://localhost:8888/personProposal/alterarSolicitacao</td>
      </tr>
    </table>
    <h4>JSON utilizado para alterar perfil que solicita crédito </h4>
      
          {
            "id": 1,
            "address": "Rua numero 20",
            "document": "12345678980",
            "name": "Carlos",
            "lastname": "Gonçalves",
            "phone": "997843278"
           }
       
      
  5) DELETAR:

     <table>
         <tr>
          <td>Método</td>
          <td>Url</td>
         </tr>
         <tr>
          <td>DELETE</td>
          <td>http://localhost:8888/personProposal/delete</td>
         </tr>
       </table>
         
        <h4>JSON utilizado para deletar</h4>

            {
                "id": 1,
                "name": "Carlos",
                "lastname": "Gonçalves",
                "document": "12345678910",
                "dateRequest": "2021-10-11",
                "updateStatusRequest": "2021-10-11",
                "phone": "997843278",
                "address": "Rua numero 20",
                "status": "DISAPPROVED"
            }    
       
  6) Buscar por Status:

     <table>
         <tr>
          <td>Método</td>
          <td>Url</td>
         </tr>
         <tr>
          <td>DELETE</td>
          <td>http://localhost:8888/personProposal/buscarPorStatus/</td>
         </tr>
       </table>
         
            EXEMPLO :
            http://localhost:8888/personProposal/buscarPorStatus/1
            
       <h4>ENUM</h4>
            
            {
                APPROVED = 0
                DISAPPOVED = 1
                REVIEW = 2
            }     

  
   ## Fontes para contato: 
  
<text> Em caso de dúvida para utilizar ou configurar a Api pode estar entrando em contato por e-mail e pelo whastapp, que assim que possível eu esclareço as dúvidas.
</text>
  
   <h4>Dados</h4>
  
  ```
     E-mail: camilamariana19@gmail.com
     Whatsapp: (33) 99917-4111
     
  ```

