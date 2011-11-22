using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Spring.Messaging.Nms.Core;
using Apache.NMS;
using System.Xml.Serialization;
using System.IO;
using System.Runtime.Serialization;
using TestWebService.localhost;

namespace TestWebService
{
    public class MyDtoMessageListener : IMessageListener
    {
        public event EventHandler<MyDtoEventArgs> OnNewMessage;

        public void OnMessage(Apache.NMS.IMessage message)
        {
            try
            {
                var text = (ITextMessage)message;

                MyDto dto = null;
                // with ServiceReference (WCF)
                var serializer = new DataContractSerializer(typeof(MyDto));
                using(var stream = new MemoryStream(Encoding.UTF8.GetBytes(text.Text)))
                {
                    dto = (MyDto)serializer.ReadObject(stream);
                }
                // with WebReference:
                //var serializer = new XmlSerializer(typeof(MyDto));
                //using (var stream = new MemoryStream(Encoding.UTF8.GetBytes(text.Text)))
                //{
                //    dto = (MyDto)serializer.Deserialize(stream);
                //}

                if (OnNewMessage != null)
                    OnNewMessage(this, new MyDtoEventArgs(dto));
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
        }
    }
}
