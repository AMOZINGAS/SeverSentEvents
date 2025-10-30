Título

Monitoreo de Sensores IoT en Tiempo Real (SSE)

Descripción

Esta versión simula un conjunto de sensores IoT que reportan temperatura y humedad. El servidor (Spring Boot) expone un endpoint SSE (/sse/sensors) que envía lecturas cada 2 segundos. El cliente web se conecta con EventSource, muestra las lecturas en una lista y permite pausar/reanudar.
