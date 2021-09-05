$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/MCP/Purchase.feature");
formatter.feature({
  "line": 2,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on the M2 Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "M2LoginStepDefinitions.i_am_on_the_M2_Homepage()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 9,
  "name": "Buy AlertFlow",
  "description": "",
  "id": "title-of-your-feature;buy-alertflow",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I sign in the page by email as \"m2test2@mailinator.com\" and password as \"dmvn@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I add to cart the AlerFlow product",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I see the Add to cart page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I click on Custommize button",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I see Customization area",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I click on Add to Cart",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I see the product added to shopping cart",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I click on Proceed to Checkout",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "\"m2test2@mailinator.com\"",
      "offset": 31
    },
    {
      "val": " \"dmvn@123\"",
      "offset": 71
    }
  ],
  "location": "M2LoginStepDefinitions.I_sign_in_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});