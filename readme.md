🌦️ API de Previsão do Tempo

API simples para consultar previsões do tempo usando a HG Weather API, salvar previsões no banco de dados H2 e gerenciar registros via endpoints REST.

📌 Tecnologias Utilizadas

    Java 17
    Spring Boot 3
    Spring Web
    Spring Data JPA
    Banco de Dados H2
    Maven

🚀 Como Rodar a API 

    git clone https://github.com/seu-usuario/weather-api.git
    cd weather-api

Endpoints Disponíveis

    Método	Endpoint	Descrição
    GET	/weather/current?city={city}	Obtém previsão atual de uma cidade
    GET	/weather/forecast?city={city}	Obtém previsão dos próximos dias
    POST	/weather/save	Salva uma previsão no banco
    GET	/weather/all	Lista todas as previsões salvas
    GET	/weather/{id}	Busca uma previsão pelo ID
    PUT	/weather/{id}	Atualiza uma previsão
    DELETE	/weather/{id}	Remove uma previsão
    GET	/weather/history?city={city}	Lista previsões salvas para uma cidade
