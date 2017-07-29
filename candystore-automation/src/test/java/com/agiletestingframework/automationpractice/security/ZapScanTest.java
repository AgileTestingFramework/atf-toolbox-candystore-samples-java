/*
 * Copyright (c) 2014 ContinuumSecurity www.continuumsecurity.net
 *
 * The contents of this file are subject to the GNU Affero General Public
 * License version 3 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.gnu.org/licenses/agpl-3.0.txt
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * The Initial Developer of the Original Code is ContinuumSecurity.
 * Portions created by ContinuumSecurity are Copyright (C)
 * ContinuumSecurity SLNE. All Rights Reserved.
 *
 * Contributor(s): Stephen de Vries
 */

package com.agiletestingframework.automationpractice.security;

import net.continuumsecurity.proxy.ScanningProxy;
import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.Alert;

import com.agiletestingframework.toolbox.ATFHandler;
import com.agiletestingframework.toolbox.managers.ConfigurationManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Modified continuumsecurity/zap-webdriver example to fit our framework examples
 * @author srufle
 *
 */
public class ZapScanTest {
    private static final Logger log = LoggerFactory.getLogger(ZapScanTest.class);

    public final static String INDEX = "http://automationpractice.com/index.php";
    private final static String MEDIUM = "MEDIUM";
    private final static String HIGH = "HIGH";
    private ScanningProxy zapScanner;
    private Spider zapSpider;
    private final static String[] policyNames = { "directory-browsing", "cross-site-scripting", "sql-injection", "path-traversal",
            "remote-file-inclusion", "server-side-include", "script-active-scan-rules", "server-side-code-injection", "external-redirect",
            "crlf-injection" };
    private int currentScanID;


    @BeforeClass
    public void setup() {
        String zapHost = ConfigurationManager.getInstance().getZapProxyHost();
        Integer zapPort = ConfigurationManager.getInstance().getZapProxyPort();
        String zapApiKey = ConfigurationManager.getInstance().getZapApiKey();
        zapScanner = new ZAProxyScanner(zapHost, zapPort, zapApiKey);
        zapScanner.clear(); // Start a new session
        zapSpider = (Spider) zapScanner;
        log.info("Created client to ZAP API");
    }

    @AfterClass
    public void ClassTeardown() {
        ATFHandler.getInstance().teardown();
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethodSetup() {
        ATFHandler.getInstance().getWebAutomation().getWebDriver().get(INDEX);
    }

    @Test
    public void testSecurityVulnerabilitiesBeforeLogin() {

        log.info("Spidering...");
        spiderWithZap();
        log.info("Spider done.");

        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanWithZap();

        List<Alert> alerts = filterAlerts(zapScanner.getAlerts());
        logAlerts(alerts);
        assertThat(alerts.size()).isEqualTo(0);
    }

    private void logAlerts(List<Alert> alerts) {
        for (Alert alert : alerts) {
            log.info("Alert: " + alert.getName() + " at URL: " + alert.getUrl() + " Parameter: " + alert.getParam() + " CWE ID: " + alert.getCweId());
        }
    }

    /*
     * Remove false positives, filter based on risk and reliability
     */
    private List<Alert> filterAlerts(List<Alert> alerts) {
        List<Alert> filtered = new ArrayList<Alert>();
        for (Alert alert : alerts) {
            if (alert.getRisk().equals(Alert.Risk.High) && alert.getConfidence() != Alert.Confidence.Low)
                filtered.add(alert);
        }
        return filtered;
    }

    public void setAlertAndAttackStrength() {
        for (String policyName : policyNames) {
            String ids = enableZapPolicy(policyName);
            for (String id : ids.split(",")) {
                zapScanner.setScannerAlertThreshold(id, MEDIUM);
                zapScanner.setScannerAttackStrength(id, HIGH);
            }
        }
    }

    private void scanWithZap() {
        log.info("Scanning...");
        zapScanner.scan(INDEX);
        currentScanID = zapScanner.getLastScannerScanId();
        int complete = 0;
        while (complete < 100) {
            complete = zapScanner.getScanProgress(currentScanID);
            log.info("Scan is " + complete + "% complete.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Scanning done.");
    }

    private String enableZapPolicy(String policyName) {
        String scannerIds = null;
        switch (policyName.toLowerCase()) {
        case "directory-browsing":
            scannerIds = "0";
            break;
        case "cross-site-scripting":
            scannerIds = "40012,40014,40016,40017";
            break;
        case "sql-injection":
            scannerIds = "40018";
            break;
        case "path-traversal":
            scannerIds = "6";
            break;
        case "remote-file-inclusion":
            scannerIds = "7";
            break;
        case "server-side-include":
            scannerIds = "40009";
            break;
        case "script-active-scan-rules":
            scannerIds = "50000";
            break;
        case "server-side-code-injection":
            scannerIds = "90019";
            break;
        case "remote-os-command-injection":
            scannerIds = "90020";
            break;
        case "external-redirect":
            scannerIds = "20019";
            break;
        case "crlf-injection":
            scannerIds = "40003";
            break;
        case "source-code-disclosure":
            scannerIds = "42,10045,20017";
            break;
        case "shell-shock":
            scannerIds = "10048";
            break;
        case "remote-code-execution":
            scannerIds = "20018";
            break;
        case "ldap-injection":
            scannerIds = "40015";
            break;
        case "xpath-injection":
            scannerIds = "90021";
            break;
        case "xml-external-entity":
            scannerIds = "90023";
            break;
        case "padding-oracle":
            scannerIds = "90024";
            break;
        case "el-injection":
            scannerIds = "90025";
            break;
        case "insecure-http-methods":
            scannerIds = "90028";
            break;
        case "parameter-pollution":
            scannerIds = "20014";
            break;
        default:
            throw new RuntimeException("No policy found for: " + policyName);
        }
        zapScanner.setEnableScanners(scannerIds, true);
        return scannerIds;
    }


    private void spiderWithZap() {
        zapSpider.setThreadCount(5);
        zapSpider.setMaxDepth(1);
        zapSpider.setPostForms(false);
        zapSpider.spider(INDEX);
        int spiderID = zapSpider.getLastSpiderScanId();
        int complete = 0;
        while (complete < 100) {
            complete = zapSpider.getSpiderProgress(spiderID);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (String url : zapSpider.getSpiderResults(spiderID)) {
            log.info("Found URL: " + url);
        }
    }
}
