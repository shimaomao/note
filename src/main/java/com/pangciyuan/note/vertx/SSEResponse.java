package com.pangciyuan.note.vertx;

import io.vertx.core.http.HttpServerResponse;

public class SSEResponse {
	private static HttpServerResponse httpServerResponse = null;

	public static HttpServerResponse getResponse() {
		return httpServerResponse;
	}

	public static void setResponse(HttpServerResponse response) {
		httpServerResponse = response;
	}

}
