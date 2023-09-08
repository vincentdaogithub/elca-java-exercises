/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.configuration;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class UpperCaseNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        Identifier defaultIdentifier =  super.toPhysicalTableName(logicalName, context);
        return Identifier.toIdentifier(defaultIdentifier.getText().toUpperCase(), defaultIdentifier.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment context) {
        Identifier defaultIdentifier =  super.toPhysicalColumnName(logicalName, context);
        return Identifier.toIdentifier(defaultIdentifier.getText().toUpperCase(), defaultIdentifier.isQuoted());
    }
}
