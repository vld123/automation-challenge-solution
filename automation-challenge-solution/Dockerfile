FROM openjdk:17

WORKDIR /app

COPY . .

RUN mkdir "/usr/share/serenity"
RUN mkdir "/usr/share/serenity/report"
RUN ./gradlew build -x test

# Run the Gradle tests
CMD ["./gradlew", "test"]
