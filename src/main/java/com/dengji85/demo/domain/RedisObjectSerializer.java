package com.dengji85.demo.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object> {

	private Converter<Object, byte[]> serialize = new SerializingConverter();
	private Converter<byte[], Object> deserialize = new DeserializingConverter();
	static final byte[] EMPTY_ARRAY = new byte[0];

	@Override
	public Object deserialize(byte[] arg0) throws SerializationException {
		if (isEmpty(arg0)) {
			return null;
		}

		return deserialize.convert(arg0);
	}

	@Override
	public byte[] serialize(Object arg0) throws SerializationException {
		if (null == arg0) {
			return EMPTY_ARRAY;
		}

		return serialize.convert(arg0);
	}

	private boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}
}
