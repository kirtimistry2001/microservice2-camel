package ca.kirti.microservice2camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiverRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// Receive message from the ActiveMQ queue
		/* ' here ' my-activemq-queue' is the queue name that we have used 
		in class ActiveMQSenderRouter of sender project(microservice1-camel/) in
		https://www.youtube.com/watch?v=eh9C0GyxtHE&ab_channel=in28minutesCloud%2CDevOpsandMicroservices
		*/
		from("activemq:my-activemq-queue")
		// just print the received message in a log (but you can to either process or transformation on received message)
		.to("log:received-message from-activeMQ"); 
		// onstartup it receive all pending message and then it received message as message put in ActiveMQ
	}

}
