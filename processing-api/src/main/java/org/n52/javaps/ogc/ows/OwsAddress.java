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
package org.n52.javaps.ogc.ows;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.google.common.base.Strings;

/**
 * TODO JavaDoc
 * @author Christian Autermann
 */
public class OwsAddress {

    private final List<String> deliveryPoint;
    private final Optional<String> city;
    private final Optional<String> administrativeArea;
    private final Optional<String> postalCode;
    private final Optional<String> country;
    private final List<String> electronicMailAddress;

    public OwsAddress(List<String> deliveryPoint, String city,
                      String administrativeArea, String postalCode,
                      String country, List<String> electronicMailAddress) {
        this.deliveryPoint
                = deliveryPoint == null ? Collections.emptyList() : deliveryPoint;
        this.city = Optional.ofNullable(Strings.emptyToNull(city));
        this.administrativeArea
                = Optional.ofNullable(Strings.emptyToNull(administrativeArea));
        this.postalCode = Optional.ofNullable(Strings.emptyToNull(postalCode));
        this.country = Optional.ofNullable(Strings.emptyToNull(country));
        this.electronicMailAddress
                = electronicMailAddress == null ? Collections.emptyList()
                : electronicMailAddress;
    }

    public List<String> getDeliveryPoint() {
        return Collections.unmodifiableList(deliveryPoint);
    }

    public Optional<String> getCity() {
        return city;
    }

    public Optional<String> getAdministrativeArea() {
        return administrativeArea;
    }

    public Optional<String> getPostalCode() {
        return postalCode;
    }

    public Optional<String> getCountry() {
        return country;
    }

    public List<String> getElectronicMailAddress() {
        return Collections.unmodifiableList(electronicMailAddress);
    }

}