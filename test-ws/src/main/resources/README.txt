WebService with REST interface
This WebService is using multidimentional arrays: JAXB generates a different XSD than AEGIS
because of a well known bug, .Net is not able to parse the JAXB format 
See bug: http://connect.microsoft.com/VisualStudio/feedback/details/471297
See workarounds: http://webservices20.blogspot.com/2010/02/net-wcf-bug-cannot-convert-type-to.html

The WebService is available at the URL:
http://localhost:8080/test-ws/services/WS?wsdl

You can test it in your browser with the REST URL:
http://localhost:8080/test-ws/services/REST/v1/test

When you call the service, it sends a XML message to a JMS queue (ActiveMQ)
The XML is generated with AEGIS, so the format is the same as the WebService