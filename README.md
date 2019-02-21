
<b>This project is used to reproduce the queue stuck if one of the Queue consumer is taking longer time to process any message</b>
<br/><br/><br/><br/>
<b>Follow below steps to reproduce this scenario</b>
<ol>
	<li>Clone this repo</li>
	<li>Build using <i>mvn clean install</i> command</li>
	<li>
		Add following code in <B>standalone-full.xml</B> under &lt;jms-destinations&gt; tag <br/>
    <pre>
    &lt;jms-queue name="queue/ATFQueue"&gt;
      &lt;entry name="java:/queue/ATFQueue"/&gt;
      &lt;entry name="java:jboss/exported/queue/ATFQueue"/&gt;
    &lt;/jms-queue&gt;
    </pre>
  </li>
	<li>Deploy war in wildfly 9.0.2</li>
	<li>Hit following url 
		<br/>
		<B>URL Parameters</B>
		<ul>
			<li><B>count</b> : This is used to send N messages</li>
			<li><B>queue</B> : This is the queue name</li>
			<li><B>sleep</B> : Running time in seconds for consumer</li>
			<li><B>sendToBd</B> : If true then send message to next queue once ATF queue complete</li>
			<li><B>name</B> : name used in log</li>
		</ul>
		<br/>
		<a href="http://172.26.122.51:8080/jms/rest/v1?count=1&queue=atf&sleep=100&sendToBd=false&name=3MinuteOf1Req">http://172.26.122.51:8080/jms/rest/v1?count=1&queue=atf&sleep=100&sendToBd=false&name=3MinuteOf1Req</a>
		<br/><br/>
		Above url send 1 message to <b>queue/ATFQueue</b> and consumer will run for 100 second and print name as 3MinuteOf1Req in log, So this will use 1 consumer 
		<br/><br/>
	</li>
	<li>Now, browse following url<BR/>
		<a href="http://172.26.122.51:8080/jms/rest/v1?count=19&queue=atf&sleep=40&sendToBd=false&name=1MinuteOf19Req">http://172.26.122.51:8080/jms/rest/v1?count=19&queue=atf&sleep=40&sendToBd=false&name=1MinuteOf19Req</a>
		<br/><br/>Above url send 19 message to <b>queue/ATFQueue</b> and each consumer will run for 40 second and print name as 1MinuteOf19Req in log, So this will use 19 consumer, <br/>
		here overall all consumers are busy<br/><br/>
	</li>
	<li>Now, browse following url <br/>
		<a href="http://172.26.122.51:8080/jms/rest/v1?count=1&queue=atf&sleep=10&sendToBd=false&name=**1MinuteOf1Req**">http://172.26.122.51:8080/jms/rest/v1?count=1&queue=atf&sleep=10&sendToBd=false&name=**1MinuteOf1Req**</a>
		<br/><br/>Above url send 1 message to <b>queue/ATFQueue</b> But this will not delivered to consumer as all are busy, <br/>
		But, after completion of above 19 consumers this will still stay in queue and not delivered to any of consumer which are just free for this <B>1MinuteOf19Req</b>
		<br/>
		here, at this point all consumers are busy<br/>
		<span style="color:#ff0000">Note : This message will only be delivered once consumer of <B>3MinuteOf1Req</B> is free</span>
	</li>
</ol>
