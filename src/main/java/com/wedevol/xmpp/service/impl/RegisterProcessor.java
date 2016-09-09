package com.wedevol.xmpp.service.impl;

import com.wedevol.xmpp.bean.CcsInMessage;
import com.wedevol.xmpp.service.PayloadProcessor;

/**
 * Handles a user registration request
 */
public class RegisterProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage msg) {
		// TODO: handle the user registration. Keep in mind that a user name can
		// have more reg IDs associated. The messages IDs should be uniques. 
	}

}