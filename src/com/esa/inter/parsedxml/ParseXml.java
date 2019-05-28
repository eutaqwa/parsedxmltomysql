package com.esa.inter.parsedxml;


import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.esa.inter.dao.FamilyBranchedDao;
import com.esa.inter.dao.ParsedXmlDao;
import com.esa.inter.model.FamilyModel;
import com.esa.inter.model.RecordModel;


public class ParseXml {
	public static void main(String[]args){
		try{
			String url = "http://localhost:8080/socketlearning/sample.xml";
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new URL(url).openStream());
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("family");
			RecordModel model =new RecordModel();
			FamilyModel models = new FamilyModel();
			System.out.println("---------------------------------------------XML TO MYSQL DATABASE--------------------------------------------------");
			for (int temp = 0 ; temp < nList.getLength();temp++){
				Node nNode = nList.item(temp);
				if(nNode.getNodeType()==Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					String parent2 = eElement.getElementsByTagName("parent").item(0).getTextContent();
					String child2 = eElement.getElementsByTagName("child").item(0).getTextContent();
					models.setParent(parent2);
					models.setChild(child2);
					
					FamilyBranchedDao.saveFamily(models);
				}
			}
					
					
			NodeList nList2 = doc.getElementsByTagName("record");
			for(int temp2=0;temp2<nList2.getLength();temp2++){
				Node nNode2 = nList2.item(temp2);
				if(nNode2.getNodeType()==Node.ELEMENT_NODE){
					Element eElement2 = (Element) nNode2;
					int recordid = temp2+1;
					String name = eElement2.getElementsByTagName("name").item(0).getTextContent();
					String phone = eElement2.getElementsByTagName("phone").item(0).getTextContent();
					String email = eElement2.getElementsByTagName("email").item(0).getTextContent();
					String city = eElement2.getElementsByTagName("city").item(0).getTextContent();
					String parent = eElement2.getElementsByTagName("parent").item(0).getTextContent();
			
					model.setRecordsid(recordid);
					model.setName(name);
					model.setPhone(phone);
					model.setEmail(email);
					model.setCity(city);
					model.setParent(parent);
							
							
					ParsedXmlDao.saveRecord(model);
				}
			}			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
