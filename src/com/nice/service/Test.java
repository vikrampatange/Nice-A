package com.nice.service;

import java.sql.Timestamp;
import java.util.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(new Timestamp(System.currentTimeMillis()));
		
		ControlCenterService controlCenterService=new ControlCenterService();
		int logincount  =controlCenterService.getLoginAttackCount();
		int sqlcount =controlCenterService.getSqlAttackCount();
		int scriptcount = controlCenterService.getScriptAttackCount();
		
		//System.out.println(logincount==0  && sqlcount==0 && scriptcount==0 );
		
		System.out.println(controlCenterService.isOneOfTheZombie());
	}

}
