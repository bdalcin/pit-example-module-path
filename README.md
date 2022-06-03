# pit-example-module-path
An example repository to show my problem with pitest and the module path. 

See https://groups.google.com/g/pitusers/c/RGAme6cGJYE

## Repository Structure 
The repository is composed of four maven modules 

1. `parent-pom/`
   - A parent pom that includes the configuration shared by all other modules
      - surefire is configured to run tests on the module path
      - Has a profile called "mutation" that will enable pitest
2. `service/` 
   - Exports a single service interface `operation.Operation`
3. `service-impl/`
   - Contains a single implementation of the `operation.Operation` service called `multiply.Multiply` 
      - Has an accompanying unit test
4. `service-user/`
   - Contains a single `ServiceUser` class that uses `operation.Operation` 
     - Has an accompanying unit test that requires the `multiply.Multiply` service implementation 

## The problem
When running `mvn test` it will pass tests with surefire on the module path. This proves the test suite is green when run on the module path.

When running `mvn -Pmutate test` it will fail during mutation testing of the `service-user` module. This is because the tests fail when pit runs them on the classpath.

## Workaround
To have mutation testing pass, the `service-impl/src/main/resources/META-INF/services/operation.Operation` can have its single entry uncommented so that the service implementation is available on the classpath.