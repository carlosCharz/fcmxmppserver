package com.wedevol.xmpp.bean;

import java.util.Map;

/**
 * Represents an incoming message from FCM CCS
 */
public class CcsInMessage {

	// Sender registration ID
	private String from;
	// Sender app's package
	private String category;
	// Unique id for this message
	private String messageId;
	// Payload data. A String in JSON format
	private Map<String, String> dataPayload;

	public CcsInMessage(String from, String category, String messageId, Map<String, String> dataPayload) {
		this.from = from;
		this.category = category;
		this.messageId = messageId;
		this.dataPayload = dataPayload;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Map<String, String> getDataPayload() {
		return dataPayload;
	}

	public void setDataPayload(Map<String, String> dataPayload) {
		this.dataPayload = dataPayload;
	}
}