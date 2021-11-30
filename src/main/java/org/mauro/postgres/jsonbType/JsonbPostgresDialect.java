package org.mauro.postgres.jsonbType;

import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

public class JsonbPostgresDialect extends PostgreSQL94Dialect {

    public JsonbPostgresDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
