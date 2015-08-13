# failing-spiral

In order to get the following exception follow these steps:

1. `lein run`
2. `curl http://localhost:8080`
3. Edit the response (`"Fascinating!"`)
4. `curl http://localhost:8080`
5. Check out the error log


```
ERROR http-kit - Encountered unhandled error from spiral httpkit adapapter.
java.lang.Exception: Cyclic load dependency: [ /spock/core ]->/spock/rest->[ /spock/core ], ...
```
