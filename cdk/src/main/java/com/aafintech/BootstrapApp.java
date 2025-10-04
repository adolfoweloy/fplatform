package com.aafintech;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import static java.util.Objects.requireNonNull;

public class BootstrapApp {
  public static void main(final String[] args) {
    var app = new App();

    var region = (String) app.getNode().tryGetContext("region");
    requireNonNull(region, "context variable 'region' must not be null");

    var accountId = (String) app.getNode().tryGetContext("accountId");
    requireNonNull(accountId, "context variable 'accountId' must not be null");

    var awsEnvironment = makeEnv(accountId, region);

    var stack = new Stack(app, "FintechBootstrap", StackProps.builder()
      .env(awsEnvironment)
      .build());

    app.synth();
  }

  static Environment makeEnv(String account, String region) {
    return Environment.builder()
      .account(account)
      .region(region)
      .build();
  }

}
