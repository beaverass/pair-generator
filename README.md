# Как запустить этот проект
# Docker 
## 1. Клонируем репозиторий 
>git clone https://github.com/beaverass/pair-generator
## 2. Создаём jar
>mvn clean package
## 3. Создаем Docker Image
>docker build -t pair-generator-app:v1 .
## 4. Запускаем Docker Container
>docker run -it pair-generator-app:v1
## 5. Когда попросят ввести путь к файлу передаём 
>students.txt или studentsInLine.txt (можно настроить в Dockerfile)
## P.S Запустится даже на микроволновке
# Без Docker
## 1. Клонируем репозиторий
>git clone https://github.com/beaverass/pair-generator
## 2. Создаём jar 
>mvn clean package
## 3. Запускаем jar 
>java -jar C:\pathToJar\random-pair-generator-1.0-SNAPSHOT.jar
## 4. Проверяем версию Java в pom.xml(должна совпадать с вашей)
>```xml
> <maven.compiler.source>16</maven.compiler.source>   
> <maven.compiler.target>16</maven.compiler.target>
> и тут 
> <source>16</source> 
> <target>16</target>
>```

## P.S Запустится должен, ~~но за кодировку я не отвечаю~~


