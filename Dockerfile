FROM maven:3-openjdk-17

# Set the working directory
WORKDIR /app

# Copy the jar file to the working directory
COPY . .

# Run the jar file
ENV DATABASE_URL=${DATABASE_URL}
ENV DATABASE_USERNAME=${DATABASE_USERNAME}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}


RUN mvn install
CMD mvn spring-boot:run
EXPOSE 8080