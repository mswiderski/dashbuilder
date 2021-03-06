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
package org.dashbuilder.dataprovider.sql.model;

import java.sql.Connection;

import org.dashbuilder.dataprovider.sql.JDBCUtils;
import org.dashbuilder.dataprovider.sql.dialect.Dialect;

public class SQLStatement<T extends SQLStatement> {

    protected Connection connection;
    protected Dialect dialect;

    protected Table table = null;

    public SQLStatement(Connection connection, Dialect dialect) {
        this.connection = connection;
        this.dialect = dialect;
    }

    public T table(Table table) {
        this.table = fix(table);
        return (T) this;
    }

    public Connection getConnection() {
        return connection;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public Table getTable() {
        return table;
    }

    protected Table fix(Table table) {
        String name = fix(table.getName());
        table.setName(name);
        return table;
    }

    protected Column fix(Column column) {
        // Fix column name to match DB case settings
        String name = fix(column.getName());
        column.setName(name);
        return column;
    }

    protected String fix(String id) {
        return JDBCUtils.fixCase(connection, id);
    }
}
