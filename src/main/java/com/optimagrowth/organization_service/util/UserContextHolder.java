package com.optimagrowth.organization_service.util;

import org.springframework.util.Assert;

public class UserContextHolder {
  private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

  public static UserContext getContext() {
    UserContext context = userContext.get();

    if (context == null) {
      context = createEmptyContext();
      userContext.set(context);
    }
    return userContext.get();
  }

  public static void SetContext(UserContext context) {
    Assert.notNull(context, "Only non-null UserContext instances are permitted");
    userContext.set(context);
  }

  public static UserContext createEmptyContext() {
    return new UserContext();
  }
}
