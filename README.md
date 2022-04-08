# Backend 1er Parcial

## Requerimientos
- Openjdk-11-jdk.`sudo apt install default-jdk`
- PostgreSQL para manejo de base de datos:
`sudo apt-get install postgresql postgresql-contrib`
## Instrucciones
1. Crear la base de datos y el usuario en PostgreSQL para el proyecto con los siguientes datos:
  ```
    nombre: tpbackend,
    user: postgres,
    password: postgres
  ```
3. Correr servidor wildfly `./standalone.sh`
4. Configurar settings.xml de maven, en la sección mirrors modificar
```
<mirror>
    <id>maven-default-http-blocker</id>
    <mirrorOf>external:http:*</mirrorOf>
    <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
    <url>http://repository.jboss.org/nexus/content/groups/public/</url>
    <blocked>false</blocked>
</mirror>
```
5. Para IntelliJ seleccinar o descargar JDK: "openjdk-18 Oracle OpenJDK version"
`CRTL+ALT+SHIFT+S`
6. Hacer el deploy `mvn clean install` 
7. Conectar el servidor 
 ```
    ./jbosss-cli.sh
    connect
    deploy ".../prueba.war"
 ```
