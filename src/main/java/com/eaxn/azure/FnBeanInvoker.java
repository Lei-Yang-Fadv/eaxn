package com.eaxn.azure;

import org.springframework.cloud.function.adapter.azure.HttpFunctionInvoker;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

public class FnBeanInvoker extends HttpFunctionInvoker<String> {

    @FunctionName("caseNotificationController")
    public void caseNotification(@HttpTrigger(name = "req", methods = {
            HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "eax-notifications/case") HttpRequestMessage<String> request,
            ExecutionContext context) {
        handleRequest(request, context);
    }

    @FunctionName("cdcNotificationController")
    public void cdcNotification(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "eax-notifications/cdc") HttpRequestMessage<String> request,
            ExecutionContext context) {
        handleRequest(request, context);
    }
}
