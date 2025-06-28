# BD2-EP
Exercício-programa para a matéria de Banco de Dados 2 (2025) para o Bacharelado de Sistemas de Informação 

## Rodar o deploy
Acesse o site "http://15.228.221.36:4200/"

## Iniciar o Back-End (API)
A inicialização da api pode ser feita com o Maven se o banco de dados estiver configurado corretamente.\
Primeiro vá para o diretório `api`:
```
cd api
```
Depois basta inicializar com o Wrapper Maven (permite executar sem ter o Maven instalado):
```
./mvnw spring-boot:run
```
Caso a configuração das propriedades não esteja bem feita, a inicialização acima pode não ter ocorrido com sucesso. Nesse caso, corrija o arquivo `api/src/main/resources/application.properties` de acordo com as configurações do pgAdmin.
- A `url` depende das informações do seu servidor, verifique com botão direito no servidor, vá em Properties e depois na aba Connection. O nome final deverá ser o nome do banco de dados.
- O `username` e `password` são as informações de login do seu banco de dados.

## Iniciar o Front-End
Para o front é necessário que tenha o node instalado. Depois basta entrar no diretório front:
```
cd front
```
Instalar as dependências do node e executar:
```
npm install
npm run start
```

## Docker Compose

Na posta docker-compose, há 2 deploys: 1 usando o nginx e não. Na nuvem, somente conseguimos postar usando nginx.

## Deploy no Docker Hub

Buildar a imagem localmente e pushar para o docker hub:

```
docker build -t dimidimii/dance-school-webapp:vX.X .
docker push dimidimii/dance-school-webapp:vX.X
```

Para o back é a mesma coisa. Alterações do banco são mais complexas.

## Atualizar na AWS

- Conectar na instância
- Atualizar a versão da imagem
- ir para a pasta em que está o docker-compose

```
docker compose down
docker compose up -d
```
