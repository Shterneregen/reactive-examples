Run MongoDB in a docker container and expose port 27017

```shell
docker run -d --name sfg-mongo -p 27017:27017 mongo
```

---
Original repo: https://github.com/springframeworkguru/mongo-stock-quote-service