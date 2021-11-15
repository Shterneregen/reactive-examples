Run RabbitMQ in a docker container and expose port 5672

```shell
docker run -d --name sfg-mongo -p 27017:27017 mongo
docker run -d -p 5672:5672 --name sfg-rabbit rabbitmq
```

---
Original repo: https://github.com/springframeworkguru/rabbit-stock-quote-service