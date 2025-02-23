/*
 *  Copyright (c) 2015 WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.ballerinalang.stdlib.auth.ldap;

import org.ballerinalang.stdlib.auth.ldap.utils.LdapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * A class that encapsulates SSLContext configuration.
 *
 * @since 0.983.0
 */
class SslTrustConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SslTrustConfig.class);

    private File trustStore;
    private String trustStorePass;
    private String sslProtocol = LdapConstants.TLS;
    private String tlsStoreType = LdapConstants.PKCS_STORE_TYPE;
    private File clientTrustCertificates;

    public File getTrustStore() {
        return trustStore;
    }

    public void setTrustStoreFile(File trustStore) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Using truststore '{}'", trustStore);
        }
        this.trustStore = trustStore;
    }

    public String getTrustStorePass() {
        return trustStorePass;
    }

    public void setTrustStorePass(String trustStorePass) {
        this.trustStorePass = trustStorePass;
    }

    public void setSSLProtocol(String sslProtocol) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Set SSL protocol '{}'", sslProtocol);
        }
        this.sslProtocol = sslProtocol;
    }

    public String getSSLProtocol() {
        return sslProtocol;
    }

    public String getTLSStoreType() {
        return tlsStoreType;
    }

    public void setTLSStoreType(String tlsStoreType) {
        this.tlsStoreType = tlsStoreType;
    }

    public File getClientTrustCertificates() {
        return clientTrustCertificates;
    }

    public void setClientTrustCertificates(File clientTrustCertificates) {
        this.clientTrustCertificates = clientTrustCertificates;
    }

    public void setClientTrustCertificates(String clientTrustCertificates) {
        setClientTrustCertificates(new File(LdapUtils.substituteVariables(clientTrustCertificates)));
    }
}
