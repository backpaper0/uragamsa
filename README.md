# uragamsa

## bookmark

```console
docker run -d --name=mysql-bookmark -p 3306:3306 -e MYSQL_DATABASE=bookmark -e MYSQL_USER=bookmark -e MYSQL_PASSWORD=bookmark -e MYSQL_ROOT_PASSWORD=bookmark mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci && docker logs -f mysql-bookmark
```

```console
docker stop mysql-bookmark && docker rm mysql-bookmark
```

## License

Licensed under [The MIT License](https://opensource.org/licenses/MIT)

