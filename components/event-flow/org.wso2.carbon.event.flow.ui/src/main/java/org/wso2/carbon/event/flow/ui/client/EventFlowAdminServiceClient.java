/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.carbon.event.flow.ui.client;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.event.flow.stub.client.EventFlowAdminServiceStub;

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.ResourceBundle;

public class EventFlowAdminServiceClient {

    private static final Log log = LogFactory.getLog(EventFlowAdminServiceClient.class);
    private static final String BUNDLE = "org.wso2.carbon.event.flow.ui.i18n.Resources";
    private ResourceBundle bundle;
    public EventFlowAdminServiceStub stub;

    public EventFlowAdminServiceClient(String cookie,
                                         String backendServerURL,
                                         ConfigurationContext configCtx,
                                         Locale locale) throws AxisFault {
        String serviceURL = backendServerURL + "EventFlowAdminService";
        bundle = ResourceBundle.getBundle(BUNDLE, locale);

        stub = new EventFlowAdminServiceStub(configCtx, serviceURL);
        ServiceClient client = stub._getServiceClient();
        Options option = client.getOptions();
        option.setManageSession(true);
        option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
    }

    public String getEventFlow() throws AxisFault {
        try {
            return stub.getEventFlow();
        } catch (RemoteException e) {
            String msg = bundle.getString("Cannot load event flow");
            handleException(msg, e);
        }
        return null;
    }

    private void handleException(String msg, Exception e) throws AxisFault {
        log.error(msg, e);
        throw new AxisFault(msg, e);
    }
}
