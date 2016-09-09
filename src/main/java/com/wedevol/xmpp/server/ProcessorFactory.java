package com.wedevol.xmpp.server;

import com.wedevol.xmpp.service.PayloadProcessor;
import com.wedevol.xmpp.service.impl.EchoProcessor;
import com.wedevol.xmpp.service.impl.MessageProcessor;
import com.wedevol.xmpp.service.impl.RegisterProcessor;
import com.wedevol.xmpp.util.Util;

/**
 * Manages the creation of different payload processors based on the desired
 * action
 */

public class ProcessorFactory {

	public static PayloadProcessor getProcessor(String action) {
		if (action == null) {
			throw new IllegalStateException("ProcessorFactory: Action must not be null");
		}
		if (action.equals(Util.BACKEND_ACTION_REGISTER)) {
			return new RegisterProcessor();
		} else if (action.equals(Util.BACKEND_ACTION_ECHO)) {
			return new EchoProcessor();
		} else if (action.equals(Util.BACKEND_ACTION_MESSAGE)) {
			return new MessageProcessor();
		}
		throw new IllegalStateException("ProcessorFactory: Action " + action + " is unknown");
	}
}