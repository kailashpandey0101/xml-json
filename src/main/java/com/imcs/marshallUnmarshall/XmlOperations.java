package com.imcs.marshallUnmarshall;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import trng.jaxb.*;

public class XmlOperations {
	public void marshall(Customer customer) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Marshaller marshall = context.createMarshaller();
		marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		File file = new File("CustomerXml.xml");
		marshall.marshal(customer, System.out);
		marshall.marshal(customer, file);
	}

	public void unMarshall() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Unmarshaller unMarshall = context.createUnmarshaller();
		File file = new File("CustomerXml.xml");
		Customer customer = (Customer) unMarshall.unmarshal(file);
		System.out.println(customer);
	}
}
