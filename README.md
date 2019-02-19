I'm not using kubernates or docker-compose, so I have to run the containers a particular order.

I have the IP addresses hardcoded and not using service discovery magic (That is the next step!). 
This is POC and I'm only concern about is showing off the JavaEE functionality in TomEE.

To start:
(git clone, but if you are running you probably already cloned this project.)

$> cd server/
$> ./build.sh && ./run.sh && ./shell.sh

[you can check the ip address using ifconfig - it should be 172.17.0.2]

Open up a new terminal window:

$> cd activemq
$> ./build.sh && ./run.sh && ./shell.sh

[ip address should be 172.17.0.3]

Open up a new terminal window:

$> cd database
$> ./build.sh && ./run.sh && ./shell.sh

#Now you need to create the databae called test:
$> echo "drop schema test; create schema test;" | mysql -uroot -p
[Password root]

[ip adress should be 172.17.0.4]

**You might have to redploy server since the database wasn't created. 
$> docker stop $(docker ps -a -q | grep tomee-server)
$> ./run.sh && ./shell.sh

Open up a new terminal window:

$> cd client
$> ./build.sh && ./run.sh && ./shell.sh

[we dont care about the ip address for this container]

Endpoints:

server endpoint:
http://localhost:8080/web/jms 

cURL:
curl -v http://localhost:9090/web/hello
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 9090 (#0)
> GET /web/hello HTTP/1.1
> Host: localhost:9090
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 202
< Content-Length: 0
< Date: Tue, 19 Feb 2019 19:15:53 GMT
< Server: Apache TomEE
<
* Connection #0 to host localhost left intact

activemq UI application:

http://localhost:8161/
username: admin
password: admin

client endpoint:
http://localhost:9090/web/hello

cURL:
curl -v http://localhost:8080/web/jms
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /web/jms HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 200
< Content-Length: 0
< Date: Tue, 19 Feb 2019 19:16:39 GMT
< Server: Apache TomEE
<
* Connection #0 to host localhost left intact

After hitting the client endpoint you should see the following in the client's log:
19-Feb-2019 19:05:06.479 INFO [http-nio-8080-exec-1] org.apache.openejb.client.EventLogger.log RemoteInitialContextCreated{providerUri=http://172.17.0.2:8080/tomee/ejb}

That is correct Remote EJB invocation done over HTTP and not CORBA/IIOP! /mindblown


**If for whatever reason the ip address dont match you can manually configure everything in the tomee.xml files.
There is one in client/ and server/

After everything is deployed and running:

If you really want to test JMS do the following command:
$> watch -n 1 'curl http://localhost:8080/web/jms'

View the consumers of the Topic:
http://localhost:8161/admin/topicSubscribers.jsp?JMSDestination=MyTopic

View the consumer of the Queue:
http://localhost:8161/admin/queueConsumers.jsp?JMSDestination=MyQueue

Isn't it nice to have a nice UI for observing the Broker!

View the database count (ensure data is getting inserted into the Database via JPA);
Now on the database container run the following commands:

$> echo "select count(*) from FOO;" | mysql -uroot -p test

You should see the count go up when you run the curl http://localhost:8080/web/jms

Congradulations, you have JavaEE system deployed on multiple TomEE instances.

Now Lets move this to the cloud.

