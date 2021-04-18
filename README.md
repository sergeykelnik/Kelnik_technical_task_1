# Kelnik technical task

### Behavior driven Selenium test

By default, tests will run on Chrome. To change that, specify `-Dbrowser="{browser}"` where `{browser}` is `chrome`, `firefox` or `edge`.  
You can specify URL where tests should be executed using `-DbaseUrl="{URL}"` where `{URL}` is path to the site/environment.  
You can also select specific scenarios to execute using `-Dcucumber.options="--tags {@any_tag}"` with e.g. `@regression` tag.  

```bash
mvn clean test
```
or
```bash
mvn clean test -DbaseUrl="https://www.ubs.com/" -Dbrowser="firefox" -Dcucumber.options="--tags @regression"
```
