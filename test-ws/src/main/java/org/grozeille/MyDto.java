package org.grozeille;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MyDto implements Serializable {
	private String[] datas;
	
	private String otherData; 
	
//	private List<Items> data2d;
//
//	@XmlElement(nillable=false)
//	public List<Items> getData2d() {
//		return data2d;
//	}
//	
//	public void setData2d(List<Items> data2d) {
//		this.data2d = data2d;
//	}
	
	private String[][] data2d;

	@XmlElement
	public String[][] getData2d() {
		return data2d;
	}

	public void setData2d(String[][] data2d) {
		this.data2d = data2d;
	}

	@XmlElement
	public String getOtherData() {
		return otherData;
	}

	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}

	@XmlElement
	public String[] getDatas() {
		return datas;
	}

	public void setDatas(String[] datas) {
		this.datas = datas;
	}
}
