# pit-example-module-path
An example repository to show the problem with pitest and the module path. 

See https://groups.google.com/g/pitusers/c/RGAme6cGJYE

## Repo Structure 
The repo is composed of four modules 
- `parent-pom/`
  - A parent pom that includes the shared configuration 
    - surefire is configured to run tests on the module path
  - A profile called "mutation" that will execute tests with pitest
  - All other modules reference this parent pom
- `service/` 
  - Exports a single service interface `operation.Operation`
- `service-impl/`
  - Implements the `operation.Operation` service with a `multiply.Multiply` 
- `service-user/`
  - Contains a single `ServiceUser` class that uses `operation.Operation`. 
  - Contains a test that requires the `multiply.Multiply` service implementation 

## The problem
When running `mvn test` it will pass tests with surefire on the module path. This proves the test suite is green when run on the module path.

When running `mvn -Pmutate test` it will fail during mutation testing of the `service-user` module as it does not consider the suite to be green. This is because the tests do not pass when run on the classpath.

## Workaround
To have mutation testing pass, the `service-impl/src/main/resources/META-INF/services/operation.Operation` can have its single entry uncommented