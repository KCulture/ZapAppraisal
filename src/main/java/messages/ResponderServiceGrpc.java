package messages;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.5.0)", comments = "Source: messages.proto")
public final class ResponderServiceGrpc {

	private ResponderServiceGrpc() {
	}

	public static final String SERVICE_NAME = "user.ResponderService";

	// Static method descriptors that strictly reflect the proto.
	@io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
	public static final io.grpc.MethodDescriptor<Messages.ResponderRequest, Messages.ResponderResponse> METHOD_NOTIFY_RESPONDER = io.grpc.MethodDescriptor
	    .<Messages.ResponderRequest, Messages.ResponderResponse> newBuilder()
	    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
	    .setFullMethodName(
	        generateFullMethodName("user.ResponderService", "NotifyResponder"))
	    .setRequestMarshaller(
	        io.grpc.protobuf.ProtoUtils.marshaller(Messages.ResponderRequest
	            .getDefaultInstance()))// getDefaultInstance()))
	    .setResponseMarshaller(
	        io.grpc.protobuf.ProtoUtils.marshaller(Messages.ResponderResponse
	            .getDefaultInstance())).build();

	/**
	 * Creates a new async stub that supports all call types for the service
	 */
	public static ResponderServiceStub newStub(io.grpc.Channel channel) {
		return new ResponderServiceStub(channel);
	}

	/**
	 * Creates a new blocking-style stub that supports unary and streaming output
	 * calls on the service
	 */
	public static ResponderServiceBlockingStub newBlockingStub(
	    io.grpc.Channel channel) {
		return new ResponderServiceBlockingStub(channel);
	}

	/**
	 * Creates a new ListenableFuture-style stub that supports unary calls on the
	 * service
	 */
	public static ResponderServiceFutureStub newFutureStub(io.grpc.Channel channel) {
		return new ResponderServiceFutureStub(channel);
	}

	/**
   */
	public static abstract class ResponderServiceImplBase implements
	    io.grpc.BindableService {

		/**
     */
		public void notifyResponder(Messages.ResponderRequest request,
		    io.grpc.stub.StreamObserver<Messages.ResponderResponse> responseObserver) {
			asyncUnimplementedUnaryCall(METHOD_NOTIFY_RESPONDER, responseObserver);
		}

		@java.lang.Override
		public final io.grpc.ServerServiceDefinition bindService() {
			return io.grpc.ServerServiceDefinition
			    .builder(getServiceDescriptor())
			    .addMethod(
			        METHOD_NOTIFY_RESPONDER,
			        asyncUnaryCall(new MethodHandlers<Messages.ResponderRequest, Messages.ResponderResponse>(
			            this, METHODID_NOTIFY_RESPONDER))).build();
		}
	}

	/**
   */
	public static final class ResponderServiceStub extends
	    io.grpc.stub.AbstractStub<ResponderServiceStub> {
		private ResponderServiceStub(io.grpc.Channel channel) {
			super(channel);
		}

		private ResponderServiceStub(io.grpc.Channel channel,
		    io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected ResponderServiceStub build(io.grpc.Channel channel,
		    io.grpc.CallOptions callOptions) {
			return new ResponderServiceStub(channel, callOptions);
		}

		/**
     */
		public void notifyResponder(Messages.ResponderRequest request,
		    io.grpc.stub.StreamObserver<Messages.ResponderResponse> responseObserver) {
			asyncUnaryCall(
			    getChannel().newCall(METHOD_NOTIFY_RESPONDER, getCallOptions()),
			    request, responseObserver);
		}
	}

	/**
   */
	public static final class ResponderServiceBlockingStub extends
	    io.grpc.stub.AbstractStub<ResponderServiceBlockingStub> {
		private ResponderServiceBlockingStub(io.grpc.Channel channel) {
			super(channel);
		}

		private ResponderServiceBlockingStub(io.grpc.Channel channel,
		    io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected ResponderServiceBlockingStub build(io.grpc.Channel channel,
		    io.grpc.CallOptions callOptions) {
			return new ResponderServiceBlockingStub(channel, callOptions);
		}

		/**
     */
		public Messages.ResponderResponse notifyResponder(
		    Messages.ResponderRequest request) {
			return blockingUnaryCall(getChannel(), METHOD_NOTIFY_RESPONDER,
			    getCallOptions(), request);
		}
	}

	/**
   */
	public static final class ResponderServiceFutureStub extends
	    io.grpc.stub.AbstractStub<ResponderServiceFutureStub> {
		private ResponderServiceFutureStub(io.grpc.Channel channel) {
			super(channel);
		}

		private ResponderServiceFutureStub(io.grpc.Channel channel,
		    io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected ResponderServiceFutureStub build(io.grpc.Channel channel,
		    io.grpc.CallOptions callOptions) {
			return new ResponderServiceFutureStub(channel, callOptions);
		}

		/**
     */
		public com.google.common.util.concurrent.ListenableFuture<Messages.ResponderResponse> notifyResponder(
		    Messages.ResponderRequest request) {
			return futureUnaryCall(
			    getChannel().newCall(METHOD_NOTIFY_RESPONDER, getCallOptions()),
			    request);
		}
	}

	private static final int METHODID_NOTIFY_RESPONDER = 0;

	private static final class MethodHandlers<Req, Resp> implements
	    io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
	    io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
	    io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
	    io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
		private final ResponderServiceImplBase serviceImpl;
		private final int methodId;

		MethodHandlers(ResponderServiceImplBase serviceImpl, int methodId) {
			this.serviceImpl = serviceImpl;
			this.methodId = methodId;
		}

		@java.lang.Override
		@java.lang.SuppressWarnings("unchecked")
		public void invoke(Req request,
		    io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			case METHODID_NOTIFY_RESPONDER:
				serviceImpl
				    .notifyResponder(
				        (Messages.ResponderRequest) request,
				        (io.grpc.stub.StreamObserver<Messages.ResponderResponse>) responseObserver);
				break;
			default:
				throw new AssertionError();
			}
		}

		@java.lang.Override
		@java.lang.SuppressWarnings("unchecked")
		public io.grpc.stub.StreamObserver<Req> invoke(
		    io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			default:
				throw new AssertionError();
			}
		}
	}

	private static final class ResponderServiceDescriptorSupplier implements
	    io.grpc.protobuf.ProtoFileDescriptorSupplier {
		@java.lang.Override
		public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
			return Messages.getDescriptor();
		}
	}

	private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

	public static io.grpc.ServiceDescriptor getServiceDescriptor() {
		io.grpc.ServiceDescriptor result = serviceDescriptor;
		if (result == null) {
			synchronized (ResponderServiceGrpc.class) {
				result = serviceDescriptor;
				if (result == null) {
					serviceDescriptor = result = io.grpc.ServiceDescriptor
					    .newBuilder(SERVICE_NAME)
					    .setSchemaDescriptor(new ResponderServiceDescriptorSupplier())
					    .addMethod(METHOD_NOTIFY_RESPONDER).build();
				}
			}
		}
		return result;
	}
}
