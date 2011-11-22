using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Apache.NMS.ActiveMQ;
using Spring.Messaging.Nms.Core;
using Apache.NMS.ActiveMQ.Commands;
using Spring.Messaging.Nms.Listener;
using System.Threading;

namespace TestWebService
{
    class Program
    {
        static void Main(string[] args)
        {
            var activeMQConnection = new ConnectionFactory("tcp://localhost:61616");
            //var nmsTemplate = new NmsTemplate(activeMQConnection);
            //nmsTemplate.DefaultDestination = new ActiveMQQueue("mathias");

            var myDtoListener = new MyDtoMessageListener();
            myDtoListener.OnNewMessage += new EventHandler<MyDtoEventArgs>(myDtoListener_OnNewMessage);

            var listener = new SimpleMessageListenerContainer();
            listener.ConnectionFactory = activeMQConnection;
            listener.Destination = new ActiveMQQueue("mathias");
            listener.MessageListener = myDtoListener;
            listener.Initialize();

            // WCF (.Net 3)
            var client = new localhost.MyServiceClient();
            // .Net 2
            //localhost.MyServiceImplService client = new localhost.MyServiceImplService();
            var result = client.test();
            Console.WriteLine(String.Join(" - ", result.data2d[0].ToArray()));

            Console.WriteLine("Press a key to exit");
            Console.ReadKey(true);
        }

        static void myDtoListener_OnNewMessage(object sender, MyDtoEventArgs e)
        {
            Console.WriteLine("New message: {0}", String.Join(" - ", e.MyDto.data2d[0].ToArray()));
        }
    }
}
