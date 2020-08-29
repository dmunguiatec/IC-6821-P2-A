# Segundo Proyecto Programado #

## Documentación técnica ##

### Herramientas ###

La manera más recomendada de manejar el software necesario para trabajar este proyecto es a través de docker,
sin embargo el uso de docker puede hacer un alto de recursos en su máquina; por esta razón también se provee como 
alternativa instalar y ejecutar el software necesario manualmente. 

**Se presupone que estará trabajando en un ambiente linux**.

#### Instalación de docker ####

Para que docker funcione correctamente debe ser instalado desde las fuentes oficiales. La guía de instalación se encuentra en el siguiente enlace: https://docs.docker.com/install/linux/docker-ce/ubuntu/

Deben seguir las instrucciones bajo las secciones **Install Docker CE / Install using the repository**. Por favor leer las instrucciones de la guía, no deberían simplemente copiar los comandos sin saber qué hacen o para qué deben ser ejecutados.

Una vez finalizado este proceso deben proceder a configurar su usuario para que pueda utilizar el comando `docker` sin necesidad de `sudo` siguiendo las instrucciones en la sección **Manage Docker as a non-root user** en la guía que se encuentra en este enlace: https://docs.docker.com/install/linux/linux-postinstall/ . Para que los cambios al usuario tomen efecto debe reiniciar su computadora. Este paso es absolutamente necesario, si ejecutan `docker` con `sudo` el ambiente de desarrollo no va a funcionar.

Finalmente instalar docker compose siguiendo las instrucciones disponibles en https://docs.docker.com/compose/install/.

#### Instalación manual ####

Instalar SDKMAN! https://sdkman.io/install

Instalar Java 11

```bash
sdk install java
```

### Construir y ejecutar ###

#### Con docker ####
 
Para construir la aplicación utilice el comando:

```bash
docker-compose run build
```

Para ejecutar la aplicación utilice el comando:

```bash
docker-compose run --service-ports app
```

#### Manualmente ####

Para construir la aplicación utilice el comando:

```bash
./gradlew clean build
```

Para ejecutar la aplicación utilice el comando:

```bash
./gradlew bootRun
```
