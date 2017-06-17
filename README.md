# target
target assignment

Spring boot service which call asynchronously to pricing service (DynamoDB database) and info service (target api) 
and when got result from both of them merge and produces output.

In a complex world, rxjava is a better way, thus using spring-webflux it provide option for same integration.

To run project:
gradle clean bootRun
you need aws login from cli, dynamodb table preexsisting.
