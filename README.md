# Web2-DS140-N4
 	
## Equipe composta por: 
- GRR20221126 - Eduardo Vinicius Frohlich - eduardofrohlich121@gmail.com
- GRR20221101 - Gabriel Felipe Batista dos Santos - gfbsant@gmail.com
- GRR20221107 - Gustavo Antonio Padilha - gustavopadilha@ufpr.br
- GRR20221083 - Gustavo Iassyl Nielsen Alves - gustavo.nielsen@ufpr.br
- GRR20221117 - Gustavo Jahnz - gustavojahnz@gmail.com
- GRR20185215 - Ingrity Valeska Cardoso Rodrigues - ingrity_valeska@hotmail.com

## Passo a passo para execução do PROTOTIPO:
- Recomenda-se que seja utilizado o **Visual Studio Code** e a extensão disponível no marketplace do VS Code chamada **Live Server**, a qual permite a visualização da página ao vivo no navegador, com atualização em tempo real.

![Live Server](https://iili.io/JdqaIMx.png)
>Clone o projeto utilizando o comando:
~~~javascript
git clone https://github.com/eduardofrohlich/web2-DS140-N4.git
~~~
 A pasta gerada após o clone é a `web2-DS140-N4-main`, e dentro dela contém as pastas
- /FrontAngular: destinada para o desenvolvimento das páginas utilizando o framework Angular;
- /prototipo: reserva as pastas que contém os arquivos web do protótipo da Lavanderia, com as páginas iniciais, de cliente e de funcionário;
- /server: pasta que reserva o backend da Lavanderia, com Spring;

### Tela inicial do projeto:
>Para realizar a execução correta do projeto acesse a pasta do projeto com:
~~~html
cd web2-DS140-N4
~~~
>Em seguida, abra a pasta no VS Code executando:
~~~javascript
code .
~~~

A primeira página do projeto se localiza em `prototipo/home/tela_inicial/inicio.html`. Nela contém a tela inicial, com os botões de autocadastro e login, e é a partir dela que as demais páginas serão acessadas.

#### Login
>Login do **cliente**:
~~~html
email: cliente@email.com
senha: cliente
~~~

>Login do **funcionário**:
~~~html
email: admin@email.com
senha: admin
~~~


## Passo a passo para execução do SERVER:
Primeiramente, crie um banco no [PostgreSQL](https://www.postgresql.org/) utilizando o sql disponível em「Database/SQL.txt」, em seguida, abra a pasta「server」no [Spring Tool Suite](https://spring.io/tools) e navegue até src/main/resources.

![Passo 1](/Database/img/Spring_tutorial_1.PNG)

Abra o arquivo「application.properties」e em:

* spring.datasource.url= : Altere「Nome_Do_Banco」pelo nome que você deu para o banco

* spring.datasource.username= : Altere「Username_Do_Banco」pelo seu username do banco

* spring.datasource.password= : Altere「Senha_Do_Banco」pela sua senha do banco

![Passo 2](/Database/img/Spring_tutorial_2.PNG)

Por fim, clique com o botão direito em「server」, selecione「Run As」e clique em「Spring Boot App」

![Passo 3](/Database/img/Spring_tutorial_3.png)

Se todos os passos foram seguidos corretamente, a seguinte mensagem será exibida confirmando a inicialização do servidor:

![Passo 4](/Database/img/Spring_tutorial_4.png)

# Diagrama Relacional

![Diagrama Relacional](/Database/img/DR.PNG)