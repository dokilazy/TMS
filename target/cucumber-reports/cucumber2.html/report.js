$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Settings/emailSetup.feature");
formatter.feature({
  "line": 1,
  "name": "Update Email server information",
  "description": "",
  "id": "update-email-server-information",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Fill the mail server infomation and check connection with message as \u003cmessageContent\u003e",
  "description": "",
  "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I enter host as \u003chostname\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I enter email password as \"Tms_test@123\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I enter port as \"587\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter SSL Trust as \"mail.davnos.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter user as \"tms_test@davnos.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I click Save",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I should see success saving popup having text as \"System has been updated successfully.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I click on Check Connection button",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should see a popup having text as \u003cmessageContent\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e;",
  "rows": [
    {
      "cells": [
        "hostname",
        "messageContent"
      ],
      "line": 24,
      "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e;;1"
    },
    {
      "cells": [
        "mail.davnos.commm",
        "Unable to connect this Mail server"
      ],
      "line": 25,
      "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e;;2"
    },
    {
      "cells": [
        "mail.davnos.com",
        "Mail server has been NOT connected successfully."
      ],
      "line": 26,
      "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2406528200,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on the Settings page of TMS",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I go to the system page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I see the system page",
  "keyword": "Then "
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_am_on_the_Setting_page()"
});
formatter.result({
  "duration": 2416709600,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#username\"}\n  (Session info: chrome\u003d92.0.4515.159)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027DESKTOP-0JT4R6G\u0027, ip: \u0027192.168.1.92\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 92.0.4515.159, chrome: {chromedriverVersion: 91.0.4472.19 (1bf021f248676..., userDataDir: C:\\Users\\PC\\AppData\\Local\\T...}, goog:chromeOptions: {debuggerAddress: localhost:51510}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 5539420f7ae17c3ae4ed61ed75489b04\n*** Element info: {Using\u003did, value\u003dusername}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy21.sendKeys(Unknown Source)\r\n\tat com.tms.pageObjects.TMSLoginPage.enterUserName(TMSLoginPage.java:33)\r\n\tat com.tms.stepdefinitions.SettingsPageStepDefinitions.i_am_on_the_Setting_page(SettingsPageStepDefinitions.java:33)\r\n\tat ✽.Given I am on the Settings page of TMS(src/test/resources/features/Settings/emailSetup.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_go_to_the_system_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_see_the_system_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 25,
  "name": "Fill the mail server infomation and check connection with message as Unable to connect this Mail server",
  "description": "",
  "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I enter host as mail.davnos.commm",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I enter email password as \"Tms_test@123\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I enter port as \"587\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter SSL Trust as \"mail.davnos.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter user as \"tms_test@davnos.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I click Save",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I should see success saving popup having text as \"System has been updated successfully.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I click on Check Connection button",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should see a popup having text as Unable to connect this Mail server",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "mail.davnos.commm",
      "offset": 16
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_host(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Tms_test@123",
      "offset": 27
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "587",
      "offset": 17
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_port(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "mail.davnos.com",
      "offset": 22
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_SSLTrust(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "tms_test@davnos.com",
      "offset": 17
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_user(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_click_Save()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "System has been updated successfully.",
      "offset": 50
    }
  ],
  "location": "SettingsPageStepDefinitions.Success_message_display_with_fixed_msg(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_click_on_Check_Connection_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Unable to connect this Mail server",
      "offset": 36
    }
  ],
  "location": "SettingsPageStepDefinitions.Success_message_display(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1540500700,
  "status": "passed"
});
formatter.before({
  "duration": 1188436900,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on the Settings page of TMS",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I go to the system page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I see the system page",
  "keyword": "Then "
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_am_on_the_Setting_page()"
});
formatter.result({
  "duration": 6944804600,
  "error_message": "org.openqa.selenium.WebDriverException: java.net.ConnectException: Failed to connect to localhost/0:0:0:0:0:0:0:1:36489\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027DESKTOP-0JT4R6G\u0027, ip: \u0027192.168.1.92\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:92)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:277)\r\n\tat com.tms.stepdefinitions.SettingsPageStepDefinitions.i_am_on_the_Setting_page(SettingsPageStepDefinitions.java:39)\r\n\tat ✽.Given I am on the Settings page of TMS(src/test/resources/features/Settings/emailSetup.feature:6)\r\nCaused by: java.net.ConnectException: Failed to connect to localhost/0:0:0:0:0:0:0:1:36489\r\n\tat okhttp3.internal.connection.RealConnection.connectSocket(RealConnection.java:247)\r\n\tat okhttp3.internal.connection.RealConnection.connect(RealConnection.java:165)\r\n\tat okhttp3.internal.connection.StreamAllocation.findConnection(StreamAllocation.java:257)\r\n\tat okhttp3.internal.connection.StreamAllocation.findHealthyConnection(StreamAllocation.java:135)\r\n\tat okhttp3.internal.connection.StreamAllocation.newStream(StreamAllocation.java:114)\r\n\tat okhttp3.internal.connection.ConnectInterceptor.intercept(ConnectInterceptor.java:42)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\r\n\tat okhttp3.internal.cache.CacheInterceptor.intercept(CacheInterceptor.java:93)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\r\n\tat okhttp3.internal.http.BridgeInterceptor.intercept(BridgeInterceptor.java:93)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\r\n\tat okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(RetryAndFollowUpInterceptor.java:126)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\r\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\r\n\tat okhttp3.RealCall.getResponseWithInterceptorChain(RealCall.java:200)\r\n\tat okhttp3.RealCall.execute(RealCall.java:77)\r\n\tat org.openqa.selenium.remote.internal.OkHttpClient.execute(OkHttpClient.java:103)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:155)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:277)\r\n\tat com.tms.stepdefinitions.SettingsPageStepDefinitions.i_am_on_the_Setting_page(SettingsPageStepDefinitions.java:39)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.runBackground(CucumberScenario.java:59)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:42)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.tms.testRunner.TestRunnerParallel.feature(TestRunnerParallel.java:36)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:86)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:643)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:820)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1128)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\r\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\r\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\r\n\tat java.lang.Thread.run(Thread.java:748)\r\nCaused by: java.net.ConnectException: Connection refused: connect\r\n\tat java.net.DualStackPlainSocketImpl.waitForConnect(Native Method)\r\n\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:85)\r\n\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\r\n\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\r\n\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\r\n\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\r\n\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\r\n\tat java.net.Socket.connect(Socket.java:606)\r\n\tat okhttp3.internal.platform.Platform.connectSocket(Platform.java:129)\r\n\tat okhttp3.internal.connection.RealConnection.connectSocket(RealConnection.java:245)\r\n\t... 54 more\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_go_to_the_system_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_see_the_system_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 26,
  "name": "Fill the mail server infomation and check connection with message as Mail server has been NOT connected successfully.",
  "description": "",
  "id": "update-email-server-information;fill-the-mail-server-infomation-and-check-connection-with-message-as-\u003cmessagecontent\u003e;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I enter host as mail.davnos.com",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I enter email password as \"Tms_test@123\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I enter port as \"587\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I enter SSL Trust as \"mail.davnos.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enter user as \"tms_test@davnos.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I click Save",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I should see success saving popup having text as \"System has been updated successfully.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I click on Check Connection button",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should see a popup having text as Mail server has been NOT connected successfully.",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "mail.davnos.com",
      "offset": 16
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_host(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Tms_test@123",
      "offset": 27
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "587",
      "offset": 17
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_port(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "mail.davnos.com",
      "offset": 22
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_SSLTrust(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "tms_test@davnos.com",
      "offset": 17
    }
  ],
  "location": "SettingsPageStepDefinitions.i_enter_user(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_click_Save()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "System has been updated successfully.",
      "offset": 50
    }
  ],
  "location": "SettingsPageStepDefinitions.Success_message_display_with_fixed_msg(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsPageStepDefinitions.i_click_on_Check_Connection_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Mail server has been NOT connected successfully.",
      "offset": 36
    }
  ],
  "location": "SettingsPageStepDefinitions.Success_message_display(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 4319890900,
  "status": "passed"
});
});