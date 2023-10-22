# Java_Projekt
Projekt z przedmiotu Zaawansowane programowanie w Javie


## Baza danych


### MySQL


```bash
MySQL: docker run --name java-mysql -p 8082:3306 -e MYSQL_ROOT_PASSWORD=qwerty -e MYSQL_DATABASE=javaprojekt -h 127.0.0.1 -d mysql

phpMyAdmin:
docker pull phpmyadmin/phpmyadmin:latest
docker run --name java-phpmyadmin -d --link java-mysql:db -p 8081:80 phpmyadmin/phpmyadmin
```
    
