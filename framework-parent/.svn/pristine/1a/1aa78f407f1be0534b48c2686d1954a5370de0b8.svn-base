package com.tendcloud.adt.testcases.non_keywords.unit;

import static framework.base.Validate.*;

import org.testng.annotations.Test;

import test.base.TestGroups;



/** 
*@description TODO 
*@author James Guo
**/

public class TestTestNGListener {

	@Test(groups={TestGroups.UNIT})
	public void test1() {
		validateContains("abc", "bc", "abc包含bc,测试应通过。。");
		validateEquals("abcde", "abcde", "测试应通过。。");
		validateBetween(13, 5, 20, "13在最大和最小值之间");
		validateNotEquals(20, 18, "期望与实际值不符合。");
	}
}
