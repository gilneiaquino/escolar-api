# Define a imagem base
FROM openjdk:11

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o diretório de trabalho
COPY escolar.jar app.jar

# Expõe a porta na qual a aplicação está ouvindo (se aplicável)
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner é iniciado
CMD ["java", "-jar", "app.jar"]
