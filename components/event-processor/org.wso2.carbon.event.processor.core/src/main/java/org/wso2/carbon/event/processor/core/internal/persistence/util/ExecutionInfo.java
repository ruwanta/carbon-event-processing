/*
 *   Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 * /
 */

package org.wso2.carbon.event.processor.core.internal.persistence.util;


/**
 * Contain all the configuration details to execute db actions
 */
public class ExecutionInfo {

    private String preparedInsertStatement;
    private String preparedCreateTableStatement;
    private String preparedTableExistenceCheckStatement;
    private String preparedSelectStatement;
    private String preparedSelectLastStatement;

    private boolean tableExist = false;

    public String getPreparedInsertStatement() {
        return preparedInsertStatement;
    }

    public void setPreparedInsertStatement(String insertStatementPrefix) {
        this.preparedInsertStatement = insertStatementPrefix;
    }


    public String getPreparedCreateTableStatement() {
        return preparedCreateTableStatement;
    }

    public void setPreparedCreateTableStatement(String preparedCreateTableStatement) {
        this.preparedCreateTableStatement = preparedCreateTableStatement;
    }

    public String getPreparedTableExistenceCheckStatement() {
        return preparedTableExistenceCheckStatement;
    }

    public void setPreparedTableExistenceCheckStatement(String preparedTableExistenceCheckStatement) {
        this.preparedTableExistenceCheckStatement = preparedTableExistenceCheckStatement;
    }

    public String getPreparedSelectStatement() {
        return preparedSelectStatement;
    }

    public void setPreparedSelectStatement(String preparedSelectStatement) {
        this.preparedSelectStatement = preparedSelectStatement;
    }

    public String getPreparedSelectLastStatement() {
        return preparedSelectLastStatement;
    }

    public void setPreparedSelectLastStatement(String preparedSelectLastStatement) {
        this.preparedSelectLastStatement = preparedSelectLastStatement;
    }

    public boolean isTableExist() {
        return tableExist;
    }

    public void setTableExist(boolean tableExist) {
        this.tableExist = tableExist;
    }
}
