/*
 * Copyright 2016 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.javaps.io.literal.xsd;

import java.time.DateTimeException;
import java.time.Year;

import org.n52.iceland.exception.ows.InvalidParameterValueException;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.ogc.ows.OwsCode;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class LiteralYearType extends AbstractXSDLiteralType<Year> {

    private static final long serialVersionUID = 8715919707255499902L;

    @Override
    public String getName() {
        return G_YEAR;
    }

    @Override
    public Year parse(OwsCode name, String value) throws OwsExceptionReport {
        try {
            return Year.parse(value);
        } catch (DateTimeException ex) {
            throw new InvalidParameterValueException(name.getValue(), value).causedBy(ex);
        }
    }

    @Override
    public Class<Year> getPayloadType() {
        return Year.class;
    }

    @Override
    public String generate(OwsCode name, Year value) throws OwsExceptionReport {
        return value.toString();
    }

}