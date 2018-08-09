# XMPP Connection Server for FCM

This is a sample java project to showcase the Firebase Cloud Messaging (FCM) XMPP Connection Server. This project is a very simple standalone server that I developed as a base of a larger project. It is an application server that we must implement in our environment. This server sends data to a client app via the FCM CCS Server using the XMPP protocol.
 
For more information must read the following documentation: 
 
* [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging/): There you will see introduction to FCM.
* [FCM Server](https://firebase.google.com/docs/cloud-messaging/server): There you will see the technical requirements for this application server.
* [FCM XMPP Connection Server](https://firebase.google.com/docs/cloud-messaging/xmpp-server-ref): There you will see the syntax of upstream messages and downstream messages.
* [About FCM Messages](https://firebase.google.com/docs/cloud-messaging/concept-options): There you will see the structure of thetype of messages.
* [Send Messages](https://firebase.google.com/docs/cloud-messaging/send-message): There you will see how to send messages to FCM CSS.

_**ADDITIONAL USEFUL LINKS**_

* [Upgrade Smack library from 3.x to 4.x + Connection Draining Impl.](https://github.com/carlosCharz/fcmxmppserverv2): This project uses the latest version at this time of the Smack library (4.3.0). There you will see what the new changes are. Basically, it is the same application. I just changed the library dependencies and the needed updates to make it work. I added the connection draining implementation and a troubleshooting section if you are dealing with any known issue.
* [FCM Connection Draining solution explanation](https://youtu.be/6AQCnNWPksg): This video explains how I handle the FCM Connection Draining message.

## How it works?

 * First, you set up a java server which connects to FCM using XMPP protocol.
 * Then, from a device you send an upstream message to FCM who then sends that upstream to your server (FCM XMPP Connection Server).
 * Then, within that server you handle that upstream message to send a downstream message to the targeted device(s) through FCM. (You can handle in the way you want. Here I provide 3 action types: register, message and echo).
 * Finally, on the device side you handle those downstream messages being received to give a push notification. (This part need to be developed in the android or iOS device)

## Architecture

1. **Downstream Messages:** server-to-device through FCM
![Downstream Message](http://corporacionkristalia.com/fcm-sources/downstream.png)

2. **Upstream Messages:** device-to-server through FCM
![Upstream Message](http://corporacionkristalia.com/fcm-sources/upstream.png)


## Libraries used

 * [Smack](http://www.igniterealtime.org/projects/smack/)
 * [Json-simple](https://code.google.com/archive/p/json-simple/)
 
## How to start the server
The magic is done in the `com.wedevol.xmpp.server` package. The `CcsClient.java` class manages the connection and the message processing.

The entry point class is `com.wedevol.xmpp.EntryPoint.java` that contains a main method which takes three arguments:

1. The FCM project sender ID
2. The FCM server key
3. A registration id to send a test message

If you start it that way, the GUI of the Smack library is used to show incoming and outgoing messages.

Of course, you also can use CcsClient from within any other project. 
In that case you first have to call `prepareClient()` and pass it the FCM project sender ID and the FCM server key as arguments. The third argument decides whether the GUI should be shown or not. In production servers you have to set this to false.

For this sample all incoming messages must follow a certain format. That is, they must contain at least an action key with a supported value. This action key determines which PayloadProcessor to create. The implementations of PayloadProcessor (EchoProcessor, MessageProcessor and RegisterProcessor) finally handle the incoming messages and perform the appropriate actions.

## Credentials
To run this project you need a FCM project sender ID and a FCM server key. You can create the firebase project and get the credentials on the [Create new project page of Firebase's documentation](https://console.firebase.google.com/).

Those are passed into the CcsClient by either calling the prepareClient() method or by providing those as arguments to the EntryPoint main method.

## Related definitions

 * **XMPP**: eXtensible Messaging and Presence Protocol (XMPP). It is a protocol based on Extensible Markup Language (XML) that was originally designed for instant messaging (IM) and online presence detection. XMPP is a protocol for streaming XML elements in order to exchange messages and presence information in close to real time.
 * **Jabber**: Jabber.org is the original IM service based on XMPP and one of the key nodes on the XMPP network.
 * **Smack**: It is an Open Source XMPP (Jabber) client library for instant messaging and presence. A pure Java library, it can be embedded into your applications to create anything from a full XMPP client to simple XMPP integrations such as sending notification messages and presence-enabling devices.
 * **CCS**: Cloud Connection Server. Some of the benefits of CCS include: 1. The asynchronous nature of XMPP allows you to send more messages with fewer resources. 2. Communication is bidirectional—not only can your server send messages to the device, but the device can send messages back to your server. 3. The device can send messages back using the same connection used for receiving, thereby improving battery life.
 * **FCM**: Firebase Cloud Messaging (FCM) is a cross-platform messaging solution that lets you reliably deliver messages at no cost. Using FCM, you can notify a client app that new email or other data is available to sync. You can send notification messages to drive user reengagement and retention. For use cases such as instant messaging, a message can transfer a payload of up to 4KB to a client app.
 * **FCM Connection Server Protocols**: Currently FCM provides two connection server protocols: HTTP and XMPP. XMPP messaging differs from HTTP messaging in the following ways: 1. Upstream/Downstream messages. 2. Messaging (synchronous - HTPP or asynchronous - XMPP).
 * **Upstream Messaging**: device-to-cloud. Send acknowledgments, chats, and other messages from devices back to your server over GCM’s reliable and battery-efficient connection channel.
 * **Downstream Messaging**: cloud-to-device. For purposes such as alerting users, chat messaging or kicking off background processing before the user opens the client app, GCM provides a reliable and battery-efficient connection between your server and devices.

## About me
I am Carlos Becerra - MSc. Softwware & Systems.  But to tell you the truth, I'd prefer to be a passionate developer. You can contact me via:

* [Google+](https://plus.google.com/+CarlosBecerraRodr%C3%ADguez)
* [Twitter](https://twitter.com/CarlosBecerraRo)

## Thanks
* The project was based on what Wolfram Rittmeyer and Whisper Systems have done in their projects [gcm server](https://github.com/writtmeyer/gcm_server) and [push server] (https://github.com/WhisperSystems/PushServer/blob/master/src/main/java/org/whispersystems/pushserver/senders/XmppGCMSender.java) respectively. Somehow I refactorized the code, make it clearer, update the libraries and add some functionality.
* The images for the Architecture explanation were taken from: [google cloud messaging] (https://developer.xamarin.com/guides/cross-platform/application_fundamentals/notifications/android/google-cloud-messaging/). It provides a really good explanation about the topic. Just keep in mind that since now GCM changed its name to FCM.

_**Any improvement or comment about the project is always welcome! As well as others shared their code publicly I want to share mine! Thanks!**_

## License
```javas
Copyright 2016 Carlos Becerra

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
