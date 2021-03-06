package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_255 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_255";
	
	boolean[] actual=new boolean[34];
	SoftAssert soft=new SoftAssert();
	public String defectID;
	String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
	String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
	String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
	String ze_Checkbox_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,63);
	String ze_Checkbox_Uppercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,63);
	String ze_Checkbox_Lowercase=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,63);
	 private String[] ze_Multiple_Select_Field=new String[2];
	  {
	   ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	  }
	   private String[] ze_Multi_Version_field=new String[2];
	   {
	   ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	   private String[] ze_Multi_User_Picker=new String[2];
	   {
	   ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	
	@Given("^User is in the External_Jira page$")
	public void user_is_in_the_External_Jira_page() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 lp=new LoginPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 dt=new DefectTracking(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
		 
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"JIRA_URL");
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Username");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[1]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^User navigate to the custom fields page$")
	public void user_navigate_to_the_custom_fields_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Password");
		 String[] fieldValue=new String[1]; 
		 fieldValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,58);
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.launchJiraAdministration(issueType);
		 actual[3]=ejp.enterAdministratorAccessPassword(jiraPwd);
		 actual[4]=ejp.navigateToCustomfields();
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

	@When("^User create a custom field of type Checkbox$")
	public void user_create_a_custom_field_of_type_Checkbox() throws Throwable {
	try
	   {
		 String fieldType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,55);
		 String field=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,56);
		 String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,53);
		 String configuration=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,52);
		 String customDescription=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,53);
		 String[] fieldValue=new String[1]; 
		 fieldValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,58);
		 boolean res=ejp.checkAvailableCustomFields(customFieldName);
		 if(res==false)
		 {
		 ejp.clickOnAddCustomFieldSymbol();
		 ejp.addCustomFields(fieldType,field,customFieldName,customDescription,fieldValue);
		 }
		 actual[5]=ejp.editCustomFieldValue(customFieldName,configuration);
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

	@When("^Add a list of values number,Uppercase,lowercase,alphanumeric,special char,international char and very long character$")
	public void add_a_list_of_values_number_Uppercase_lowercase_alphanumeric_special_char_international_char_and_very_long_character() throws Throwable {
	try
	   {
		 ejp.editOptions.click();
		 String[] optionValue=new String[7];
		 for(int i=0;i<=optionValue.length-1;i++)
		 {
		 optionValue[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",i+1,63); 
		 boolean res1=ejp.checkAvailableCustomFieldOptions(optionValue[i]);
		 if(res1==false)
		 {
			ejp.addOptionInCustomField(optionValue[i]) ;	
		 }
		 }
		 actual[6]=ejp.logOutFromExternal_JIRA();
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

	@When("^launch Defect Tracking page$")
	public void launch_Defect_Tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	     driver.navigate().to(zephyr_Url);
	     lp.enterUname(lead_Uname);
	     lp.enterPass(lead_Pass);
	     lp.clickOnLogin();
		 actual[7]=pp.selectProject(projectName);
		 actual[8]=pp.selectRelease(releaseName);
		 actual[9]=rp.clickOnDefectTracking();
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

	@When("^create a defect with custom field of type Checkbox$")
	public void create_a_defect_with_custom_field_of_type_Checkbox() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
		    actual[10]=dt.createDefect(project, issuetype);
			actual[11]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[12]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox_Number,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
		    actual[13]=dt.saveDefect();
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

	@Then("^Should be able to create defect with checkbox$")
	public void should_be_able_to_create_defect_with_checkbox() throws Throwable {
	try
	  {
		 defectID=dt.retrieveDefectId();
		 actual[14]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[15]=dt.updateDefect();
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

	@When("^Search the created defect id and click on edit button$")
	public void search_the_created_defect_id_and_click_on_edit_button() throws Throwable {
	try
	  {
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[16]=dt.searchDefect(defectID);
		 actual[17]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[18]=dt.clickOnEditDefectButton();
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

	@When("^enter the multiple checkbox options$")
	public void enter_the_multiple_checkbox_options() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			String ze_Url_Field_Number=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,58);
			actual[19]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],ze_Url_Field_Number,ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
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

	@Then("^Should be able to create defect with edited checkbox values$")
	public void should_be_able_to_create_defect_with_edited_checkbox_values() throws Throwable {
	try
	   {
            actual[20]=dt.validateDefect(project, issuetype);
		    actual[21]=dt.updateEditDefectWindow();
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
	
	@When("^User launch TestExecution to execute testcase and click on D button$")
	public void user_launch_TestExecution_to_execute_testcase_and_click_on_D_button() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[22]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    
		    bp.waitForElement();
			actual[23]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[24]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[25]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^Create a defect with required fields and save$")
	public void create_a_defect_with_required_fields_and_save() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
			actual[26]=dt.createDefect(project, issuetype);
			actual[27]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[28]=dt.saveDefect();
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

	@Then("^Should be able to update checkbox values in a edit defect window$")
	public void should_be_able_to_update_checkbox_values_in_a_edit_defect_window() throws Throwable {
	try
	   {
		 String[] fields=new String[11];
         for(int i=0;i<=10;i++)
         {
         	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
         }
       
	    String ze_Checkbox=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,63);
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
		actual[29]=dt.enterDefectCustomFields(fields[0],fields[1],ze_Checkbox,fields[2],ze_Multiple_Select_Field,fields[3],ze_Multi_Version_field,fields[4],fields[5],fields[6],ze_Multi_User_Picker,fields[7]);
	    actual[30]=dt.validateDefect(project, issuetype);
	    bp.waitForElement();
	    actual[31]=dt.updateDefect();
	    actual[32]=exep.clickOnCancelDefectWindow();
	    actual[33]=tp.doubleClickOnCycle(releaseName);
	    
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
