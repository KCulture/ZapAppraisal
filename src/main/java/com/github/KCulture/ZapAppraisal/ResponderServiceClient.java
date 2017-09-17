package com.github.KCulture.ZapAppraisal;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import messages.Messages;
import messages.ResponderServiceGrpc;

public class ResponderServiceClient {

	/**
	 * @param args
	 * @throws SSLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws Exception {
		ManagedChannel mChannel = NettyChannelBuilder
		    .forAddress("localhost", 9000)
		    .sslContext(
		        GrpcSslContexts.forClient().trustManager(new File("cert.pem"))
		            .build()).build();
		ResponderServiceGrpc.ResponderServiceBlockingStub blockClient = ResponderServiceGrpc
		    .newBlockingStub(mChannel);
		ResponderServiceClient.getResponderResponse(blockClient);
		Thread.sleep(500);
		System.out.println("Good Night");
		mChannel.shutdown();
		mChannel.awaitTermination(1, TimeUnit.SECONDS);

	}

	private static void getResponderResponse(
	    ResponderServiceGrpc.ResponderServiceBlockingStub blockingClient) {
		blockingClient.notifyResponder(Messages.ResponderRequest
		    .newBuilder()
		    .addResponder(
		        0,
		        Messages.Responder.newBuilder().setFirstName("a")
		        .setLastname("b")
		        .setEmail("c@d.com")
		        .addAnswers("something")
		        .addQuestions("next"))
		        .build());

	}
}
