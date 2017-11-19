package com.wedevol.xmpp.server;

import org.jivesoftware.smack.packet.DefaultPacketExtension;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

import com.wedevol.xmpp.util.Util;

/**
 * XMPP Packet Extension for FCM Cloud Connection Server
 */
public class FcmPacketExtension extends DefaultPacketExtension {

	private String json;

	public FcmPacketExtension(String json) {
		super(Util.FCM_ELEMENT_NAME, Util.FCM_NAMESPACE);
		this.json = json;
	}

	public String getJson() {
		return json;
	}

	@Override
	public String toXML() {
		// TODO: Do we need to scape the json? StringUtils.escapeForXML(json)
		return String.format("<%s xmlns=\"%s\">%s</%s>", Util.FCM_ELEMENT_NAME, Util.FCM_NAMESPACE, json,
				Util.FCM_ELEMENT_NAME);
	}

	public Packet toPacket() {
		Message message = new Message();
		message.addExtension(this);
		return message;
	}
}
