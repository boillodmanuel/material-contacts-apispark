/**
 * Copyright 2010-2014 Restlet S.A.S. All rights reserved.
 * 
 * Restlet and APISpark are registered trademarks of Restlet S.A.S.
 */

package com.restlet.utils;

import java.io.IOException;

import javax.xml.namespace.QName;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;

public class CustomXmlSerializerProvider extends XmlSerializerProvider {

    private String _rootName;
    private String _itemName;

    public CustomXmlSerializerProvider(String rootName, String itemName) {
        super(new XmlRootNameLookup());
        this._rootName = rootName;
        this._itemName = itemName;
    }

    public CustomXmlSerializerProvider(CustomXmlSerializerProvider src, SerializationConfig config, SerializerFactory f) {
        super(src, config, f);
        _rootName = src._rootName;
        _itemName = src._itemName;
    }

    @Override
    public DefaultSerializerProvider createInstance(SerializationConfig config, SerializerFactory jsf) {
        return new CustomXmlSerializerProvider(this, config, jsf);
    }

    @Override
    protected QName _rootNameFromConfig() {
        return new QName(_rootName);
    }

    @Override
    protected void _startRootArray(ToXmlGenerator xgen, QName rootName) throws IOException, JsonProcessingException {
        xgen.writeStartObject();
        // Could repeat root name, but what's the point? How to customize?
        xgen.writeFieldName(_itemName);
    }
}
