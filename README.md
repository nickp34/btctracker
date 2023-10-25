# cointracker

# Requirements
- Java 17
- Maven

# Build
- mvn clean install

# Run
- mvn spring-boot:run

# Design and Assumptions
I made a lot of assumptions and design choices to just showcase a basic framework which we could iterate on. I tried to comment incode where I made them

# ToDos
- Real testing
- Flyway for database migrations
- Would not use autogenerate hibernate or relationships in hibernate/jpa
- Auto swagger documentation
- Proper logging
- Integrate with an Oauth service
- Design a syncing service/queue/lambda that handles the balances and transactions for any coin.
- All the things that come with the SDLC environment variables, development, deployment, monitoring, logging, availablility, etc
- Create a controller advice handling all exceptions in one place
- User and Coin controllers
- Friendly dev experience, possibly VsCode dev container to easily run service
