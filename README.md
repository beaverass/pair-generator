# Как запустить этот проект
# Docker
## 1. Клонируем репозиторий 
>git clone https://github.com/beaverass/pair-generator
## 2. Создаём jar и кладем его в корень проекта рядом с Dockerfile
>mvn clean package
## 3. Создаем Docker Image
>docker build -t pair-generator-app:v1 .
## 4. Запускаем Docker Container
>docker run -it pair-generator-app:v1
## 5. Когда попросят ввести путь к файлу передаём 
>students.txt или studentsInLine.txt (можно настроить в Dockerfile)

# Без Docker
## 1. Клонируем репозиторий
>git clone https://github.com/beaverass/pair-generator
## 2. Создаём jar 
>mvn clean package
## 3. Запускаем jar 
>java -jar C:\pathToJar\random-pair-generator-1.0-SNAPSHOT.jar


