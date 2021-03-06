/**
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.dataprovider.backend.sql;

import javax.sql.DataSource;

import com.sybase.jdbc4.jdbc.SybDataSource;
import org.apache.commons.lang3.StringUtils;
import org.dashbuilder.dataprovider.sql.SQLDataSourceLocator;
import org.dashbuilder.dataset.def.SQLDataSetDef;

public class SybaseTestSettings extends DatabaseTestSettings {

    @Override
    public String getDatabaseType() {
        return SYBASE;
    }

    @Override
    public SQLDataSourceLocator getDataSourceLocator() {
        return new SQLDataSourceLocator() {
            public DataSource lookup(SQLDataSetDef def) throws Exception {
                String server = connectionSettings.getProperty("server");
                String database = connectionSettings.getProperty("database");
                String port = connectionSettings.getProperty("port");
                String user = connectionSettings.getProperty("user");
                String password = connectionSettings.getProperty("password");

                SybDataSource ds = new SybDataSource();
                ds.setServerName(server);
                ds.setDatabaseName(database);
                ds.setPortNumber(Integer.parseInt(port));
                if (!StringUtils.isBlank(user)) {
                    ds.setUser(user);
                }
                if (!StringUtils.isBlank(password)) {
                    ds.setPassword(password);
                }
                return ds;
            }
        };
    }
}
