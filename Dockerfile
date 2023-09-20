FROM openjdk:17-oracle

WORKDIR /app

COPY random-pair-generator-1.0-SNAPSHOT.jar /app/random-pair-generator.jar
COPY students.txt /app/students.txt
COPY studentsInLine.txt /app/studentsInLine.txt

# Команда для запуска JAR-файла
CMD ["java", "-jar", "random-pair-generator.jar"]
