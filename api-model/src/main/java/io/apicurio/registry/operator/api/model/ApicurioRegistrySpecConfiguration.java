/*
 * Copyright 2022 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.operator.api.model;

import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

@Buildable(
        editableEnabled = false,
        builderPackage = Constants.FABRIC8_KUBERNETES_API
)
@EqualsAndHashCode
public class ApicurioRegistrySpecConfiguration {
    private String persistence;
    private ApicurioRegistrySpecConfigurationSql sql;
    private ApicurioRegistrySpecConfigurationKafkasql kafkasql;
    private ApicurioRegistrySpecConfigurationUI ui;
    private String logLevel;
    private ApicurioRegistrySpecConfigurationKafkaSecurity security;

    public String getPersistence() {
        return persistence;
    }

    public void setPersistence(String persistence) {
        this.persistence = persistence;
    }

    public ApicurioRegistrySpecConfigurationSql getSql() {
        return sql;
    }

    public void setSql(ApicurioRegistrySpecConfigurationSql sql) {
        this.sql = sql;
    }

    public ApicurioRegistrySpecConfigurationKafkasql getKafkasql() {
        return kafkasql;
    }

    public void setKafkasql(ApicurioRegistrySpecConfigurationKafkasql kafkasql) {
        this.kafkasql = kafkasql;
    }

    public ApicurioRegistrySpecConfigurationUI getUi() {
        return ui;
    }

    public void setUi(ApicurioRegistrySpecConfigurationUI ui) {
        this.ui = ui;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public ApicurioRegistrySpecConfigurationKafkaSecurity getSecurity() {
        return security;
    }

    public void setSecurity(ApicurioRegistrySpecConfigurationKafkaSecurity security) {
        this.security = security;
    }
}