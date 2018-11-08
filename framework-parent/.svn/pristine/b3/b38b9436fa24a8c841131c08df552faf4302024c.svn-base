package com.tendcloud.adt.testcases.non_keywords.unit;

import static framework.base.Verify.*;

import java.util.Map;

import org.testng.annotations.Test;

import framework.base.dataparser.properties.PropertiesParser;
import test.base.TestGroups;

public class TestPropParser {

	@Test(groups = TestGroups.UNIT)
	public void testGetProp() {
		PropertiesParser parser = new PropertiesParser("test-data/properties_test_data/smallApp.properties");

		String appName = parser.getPropParam("appName");
		verifyEquals(appName, "ADT-AUTO-TEST-SMALLAPP-01", "email adress..");
		
		String emailAddr = parser.getPropParam("emailAddr");
		verifyEquals(emailAddr, "haisuper@163.com", "the same...");
		
	}

	@Test(groups = TestGroups.UNIT)
	public void testGetPropsMap() {
		PropertiesParser parser = new PropertiesParser("test-data/properties_test_data/smallApp.properties");

		Map<String, String> dataMap = parser.getPropDatMap();
		verifyEquals(dataMap.keySet().size(), 4, "proptes items equals 4");
	}

}
