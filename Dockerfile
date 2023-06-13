# Define a imagem base para o build
FROM azul/zulu-openjdk:17 as builder

# Instala o Maven para realizar o build
RUN apt update -y && apt install -y maven

# Define uma variável de ambiente para o diretório do projeto
ENV APP_DIR=/opt/assertiva

# Define o diretório de trabalho
WORKDIR ${APP_DIR}

# Copia o projeto para o diretório de trabalho
COPY . ${APP_DIR}

# Builda o projeto com o perfil de desenvolvimento
RUN mvn package -Dmaven.repo.local=$BUILD_CACHE_PATH -DskipTests -P development

# Define uma nova imagem para o runtime da aplicação
FROM azul/zulu-openjdk:17

# Define o diretório de trabalho para a aplicação
WORKDIR /app

# Copia o arquivo JAR gerado pelo build para o diretório da aplicação
COPY --from=builder /opt/assertiva/target/*.jar /app/assertiva.jar

# Define as variáveis de ambiente para o modo de depuração
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n"

EXPOSE 8080
EXPOSE 5005

ENTRYPOINT [ "java" , "-jar" , "/app/assertiva.jar" ]