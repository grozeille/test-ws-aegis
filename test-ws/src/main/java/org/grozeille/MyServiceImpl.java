package org.grozeille;

import org.springframework.jms.core.JmsTemplate;

public class MyServiceImpl implements MyService {

	private JmsTemplate jmsTemplate;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public MyDto test() {
		MyDto dto = new MyDto();
		dto.setDatas(new String[]{"a","b","c"});
		dto.setOtherData("mathias");
		dto.setData2d(new String[][]{ { "a", "b"}, { "1", "2"}});
//		dto.setData2d(Arrays.asList(new Items(Arrays.asList("a","b")), new Items(Arrays.asList("1","2"))));
		
		jmsTemplate.convertAndSend(dto);
		
		return dto;
	}

}
