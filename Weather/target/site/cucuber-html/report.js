$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/demo/weather/Login.feature");
formatter.feature({
  "name": "Logging into openweatherMap",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Logging into openweatherMap",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "I open \u003cBrowser\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to LoginURL",
  "keyword": "And "
});
formatter.step({
  "name": "I click on signin_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I login inside application",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Username",
        "thevarselvakumar@gmail.com"
      ]
    },
    {
      "cells": [
        "Password",
        "Winter123!"
      ]
    }
  ]
});
formatter.step({
  "name": "login should be \u003cResult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Browser",
        "Result"
      ]
    },
    {
      "cells": [
        "Mozilla",
        "success"
      ]
    },
    {
      "cells": [
        "chrome",
        "success"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Logging into openweatherMap",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open Mozilla",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to LoginURL",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on signin_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login inside application",
  "rows": [
    {
      "cells": [
        "Username",
        "thevarselvakumar@gmail.com"
      ]
    },
    {
      "cells": [
        "Password",
        "Winter123!"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationStep.login(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be success",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationStep.validateLogin(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Logging into openweatherMap",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to LoginURL",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on signin_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login inside application",
  "rows": [
    {
      "cells": [
        "Username",
        "thevarselvakumar@gmail.com"
      ]
    },
    {
      "cells": [
        "Password",
        "Winter123!"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationStep.login(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be success",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationStep.validateLogin(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});