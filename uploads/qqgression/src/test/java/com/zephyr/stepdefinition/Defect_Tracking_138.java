package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_138 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_138";
	
	boolean[] actual=new boolean[28];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Project page Selection$")
	public void user_is_in_the_Project_page_Selection() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 lp=new LoginPage(driver);
		 dt=new DefectTracking(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
	}
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
	  	Relogin_TPE rl=new Relogin_TPE();
	  	rl.reLogin();
	  	throw e;
	}                                 
	}

	@When("^User Navigate To an External_jira page$")
	public void user_Navigate_To_an_External_jira_page() throws Throwable {
	try
	{
		 ejp=new ExternalJiraPage(driver);
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[1]=ejp.loginToExternalJira(Uname,Pwd);
    }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}                     
	}

	@When("^User navigate to the custom fields page to edit custom field checkbox value$")
	public void user_navigate_to_the_custom_fields_page_to_edit_custom_field_checkbox_value() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Password");
		 String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,53);
		 String configuration=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,52);
		 String oldValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,54);
		 String optionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,52);
		 String newValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,54);
		 actual[2]=ejp.launchJiraAdministration(issueType);
		 actual[3]=ejp.enterAdministratorAccessPassword(Pwd);
		 actual[4]=ejp.navigateToCustomfields();
		 actual[5]=ejp.editCustomFields(customFieldName, configuration);
		 actual[6]=ejp.editCustomValue(oldValue, optionValue, newValue);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                                     
	}

	@Then("^Should be able to edit the custom field checkbox value$")
	public void should_be_able_to_edit_the_custom_field_checkbox_value() throws Throwable {
	try
	   {
		 String defectValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,54);
		 actual[7]=ejp.validateEditedDefectValue(defectValue);
		 actual[8]=ejp.logOutFromExternal_JIRA();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                
	}

	@When("^As a Manager Launch the Defect Admin Page$")
	public void as_a_Manager_Launch_the_Defect_Admin_Page() throws Throwable {
	try
    {	 
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	     driver.navigate().to(zephyr_Url);
	     actual[9]=lp.enterUname(Uname);
	     actual[10]=lp.enterPass(Pass);
	     bp.waitForElement();
	     actual[11]=lp.clickOnLogin();
		 actual[12]=pp.launchAdministration();
		 actual[13]=pp.launchDefectAdmin();
    }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}                   
	}

	@Then("^Should Be able to launch Defect Admin Page$")
	public void should_Be_able_to_launch_Defect_Admin_Page() throws Throwable {
	try
	   {
		 actual[14]=pp.validateDefectAdmin();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;  
		} 	           
	}

	@When("^Clear the Cache of a Online project$")
	public void clear_the_Cache_of_a_Online_project() throws Throwable {
	try
	   {
		 actual[15]=pp.clearCache();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;  
		} 	           
	}

	@Then("^Should Clear The Cache$")
	public void should_Clear_The_Cache() throws Throwable {
	try
	   {
		 actual[16]=dt.validateSuccessMsg();
		 actual[17]=pp.clickOnLogout();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;  
		}             
	}

	@When("^Lead Launch the DefectTracking page$")
	public void lead_Launch_the_DefectTracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
		 actual[18]=pp.selectProject(projectName);
		 actual[19]=pp.selectRelease(releaseName);
		 actual[20]=rp.clickOnDefectTracking();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                                   
	}

	@Then("^Should Be able to Launch DefectTracking page$")
	public void should_Be_able_to_Launch_DefectTracking_page() throws Throwable {
	try
	   {
		 actual[21]=dt.validateDefectTrackingPage();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                          
	}

	@When("^create a defect with edited custom field checkbox value$")
	public void create_a_defect_with_edited_custom_field_checkbox_value() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
           String[] ze_Multiple_Select_Field=new String[2];
      	   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
 
      	   String[] ze_Multi_Version_field=new String[2];
      	   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	   
      	   String[] ze_Multi_User_Picker=new String[2];
      	   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	   
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String zeCheckboxField=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,54);
		    actual[22]=dt.createDefect(project, issuetype);
			actual[23]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[24]=dt.enterDefectCustomFields(fields[0],fields[1],zeCheckboxField,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[25]=dt.saveDefect();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                 
	}

	@Then("^Should be able to create defect with edited custom field checkbox value$")
	public void should_be_able_to_create_defect_with_edited_custom_field_checkbox_value() throws Throwable {
	try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[26]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[27]=dt.updateDefect();
		 bp.waitForElement();
		 
		for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;  
		}            
	}
}
