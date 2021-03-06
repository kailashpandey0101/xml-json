package com.imcs.marshallUnmarshall;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import trng.jaxb.*;

public class XmlOperationApp {

	public static void main(String[] args) throws ParseException, DatatypeConfigurationException, JAXBException {
		XmlOperations op = new XmlOperations();
		Address address = new Address();
		address.setStreet("6445 Love Dr");
		address.setCity("Irving");
		address.setState("TX");
		address.setZip(75059);

		PaymentMethod method = new PaymentMethod();
		method.setCardName("VISA");
		method.setCardNumber("7487632437477");
		method.setCardType("CREDITCARD");

		SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = s.parse("01/10/2016");
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(d1);
		XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);

		method.setDateFrom(startDate);

		method.setDateType("GregorianCalender");

		Customer customer = new Customer();
		customer.setCustomerId(10);
		customer.setCustName("Kailash");
		customer.setAddress(address);
		customer.setAnnualSalary(75000f);

		Date d3 = s.parse("06/10/1990");
		GregorianCalendar c3 = new GregorianCalendar();
		c3.setTime(d3);
		XMLGregorianCalendar dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(c3);

		customer.setDateOfBirth(dob);

		customer.getPaymentMethod().add(method);

		System.out.println("Marshalling............");
		op.marshall(customer);

		System.out.println("Unmarshalling...........");
		op.unMarshall();

	}

}
