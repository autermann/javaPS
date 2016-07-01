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
import java.time.Duration;

import org.n52.iceland.exception.ows.InvalidParameterValueException;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.ogc.ows.OwsCode;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class LiteralDurationType extends AbstractXSDLiteralType<Duration> {

    private static final long serialVersionUID = 6440166378840812023L;

    @Override
    public String getName() {
        return DURATION;
    }

    @Override
    public Duration parse(OwsCode name, String value) throws OwsExceptionReport {
        try {
            return Duration.parse(value);
        } catch (DateTimeException ex) {
            throw new InvalidParameterValueException(name.getValue(), value).causedBy(ex);
        }
    }

    @Override
    public Class<Duration> getPayloadType() {
        return Duration.class;
    }

    @Override
    public String generate(OwsCode name, Duration value) throws OwsExceptionReport {
        return value.toString();
    }

}