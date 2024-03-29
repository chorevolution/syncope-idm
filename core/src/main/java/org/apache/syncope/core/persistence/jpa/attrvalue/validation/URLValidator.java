/*
 * Copyright 2016 The CHOReVOLUTION project
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
package org.apache.syncope.core.persistence.jpa.attrvalue.validation;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.syncope.core.persistence.api.attrvalue.validation.InvalidPlainAttrValueException;
import org.apache.syncope.core.persistence.api.entity.PlainAttrValue;
import org.apache.syncope.core.persistence.api.entity.PlainSchema;

public class URLValidator extends AbstractValidator {

    private static final long serialVersionUID = 792457177290331518L;

    public URLValidator(final PlainSchema schema) {
        super(schema);
    }

    @Override
    protected void doValidate(final PlainAttrValue attrValue) {
        try {
            new URL(attrValue.getStringValue());
        } catch (MalformedURLException e) {
            throw new InvalidPlainAttrValueException("\"" + attrValue.getValue() + "\" is not a valid URL");
        }
    }
}
