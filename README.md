# API de Skills do projeto Sprintly (Microserviços)

### Para executar com Maven

1) ./mvnw.cmd spring-boot:run

### Para executar com Docker

1) docker build -f Dockerfile -t sprintly-api-skills .
2) docker run -p 8090:8090 sprintly-api-skills

É possível baixar a imagem atualizada também direto via dockerhub através de: 

aguiarbruno/sprintly-api-skills-alpha

E executar o segundo o comando:

docker run -p 8090:8090 sprintly-api-skills-alpha