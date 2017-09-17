package com.github.KCulture.ZapAppraisal;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBeans {

	// @Bean(name = "mongodExecutable")
	// public MongodExecutable getMongoExecutable() {
	// MongodExecutable mongoExe = null;
	// try {
	// MongodStarter.getDefaultInstance().prepare(
	// new MongodConfigBuilder().version(Version.Main.PRODUCTION)
	// .net(new Net("localhost", 12345, Network.localhostIsIPv6()))
	// .build());
	// } catch (Exception e) {
	// } finally {
	// if (mongoExe != null)
	// mongoExe.stop();
	// }
	// return mongoExe;
	// }
	//
	// @Bean(name = "mongodProcess")
	// public MongodProcess getMongoProcess() {
	// MongodProcess mongoProcess = null;
	// try {
	// mongoProcess = getMongoExecutable().start();
	// } catch (Exception e) {
	// } finally {
	// if (mongoProcess != null)
	// mongoProcess.stop();
	// }
	// return mongoProcess;
	// }
	//
	// @Bean(name = "mongoClient")
	// public MongoClient getMongoClient() {
	// return new MongoClient("localhost", 12345);
	// }

}
