# algaworks_cap01

## Start MySQL from docker

## Option 1

Docker from mysql/mysql-server

### Start container

```bash
docker run -p 3307:3306 --name my_mysql -e "MYSQL_ROOT_PASSWORD=root" -d mysql/mysql-server:8.0
```
### Iterate with container via bash

```bash
docker exec -it my_mysql /bin/bash
```

#### Bash commands

```bash
uname -a
```

```bash
mysql -V
```

#### MySQL configurations

```bash
bash-4.4# mysql -u root -p -A

Enter password:
```

```bash
mysql> SELECT user, host FROM mysql.user;
```

```bash
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| healthchecker    | localhost |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| root             | localhost |
+------------------+-----------+
5 rows in set (0.00 sec)
```
### Host access to user root

```bash
mysql> UPDATE mysql.user SET host='%' WHERE user='root';
```

```bash
mysql> flush privileges;
```

### Exit mysql and container
```bash
mysql> exit
Bye
bash-4.4# exit
exit
```

### Test connection/access mysql from localhost

```bash
docker ps
```

```bash
mysql -u root -p -P3307 -h 127.0.0.1
```

## Option 2
Docker from mysql

### Start container
```bash
docker run -p 3308:3306 --name mysql_8.0.34 -e "MYSQL_ROOT_PASSWORD=root" -d mysql:8.0.34
```

```bash
docker exec -it mysql_8.0.34 /bin/bash
```

```bash
mysql -u root -p -A
```
