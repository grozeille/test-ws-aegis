package org.grozeille;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
@Path("/v1")
@Produces({ "text/xml", "text/plain" })
public interface MyService {

	@WebMethod
	@GET
	@Path("/test")
	public MyDto test();
}
