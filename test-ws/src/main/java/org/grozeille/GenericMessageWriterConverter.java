package org.grozeille;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyWriter;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class GenericMessageWriterConverter implements MessageConverter {

	private MessageBodyWriter writer;
	
	public void setWriter(MessageBodyWriter writer) {
		this.writer = writer;
	}
	
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		TextMessage text = session.createTextMessage();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			writer.writeTo(object, object.getClass(), null, null, MediaType.TEXT_XML_TYPE, null, bos);
		} catch (WebApplicationException e) {
			throw new MessageConversionException("", e);
		} catch (IOException e) {
			throw new MessageConversionException("", e);
		}
		byte[] bytes = bos.toByteArray();
		
		text.setText(new String(bytes));
		
		return text;
	}

	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		throw new UnsupportedOperationException();
	}

}
