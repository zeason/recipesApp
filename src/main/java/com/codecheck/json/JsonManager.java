package com.codecheck.json;

import java.lang.reflect.Type;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonManager {
	private static final GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	private static Gson gson = gsonBuilder.create();
	private static Gson gsonSerializeNulls = gsonBuilder.serializeNulls().create();

	public static String toJson(Object src) {
		return gson.toJson(src);
	}

	public static String toSerializeNullsJson(Object src) {
		return gsonSerializeNulls.toJson(src);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static <T> T fromJson(String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}
}
