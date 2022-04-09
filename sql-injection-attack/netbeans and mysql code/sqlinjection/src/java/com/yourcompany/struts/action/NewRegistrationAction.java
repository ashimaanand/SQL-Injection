/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.yourcompany.struts.form.NewRegistrationForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-28-2008
 * 
 * XDoclet definition:
 * @struts.action path="/NewRegistration" name="newRegistrationForm" attribute="NewRegistrationForm" input="/NewRegistration.jsp" scope="request" validate="true"
 */
public class NewRegistrationAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
		
		NewRegistrationForm NewRegistrationForm = (NewRegistrationForm) form;// TODO Auto-generated method stub
		String name=NewRegistrationForm.getName().trim();
		String dob=NewRegistrationForm.getDob().trim();
		String age=NewRegistrationForm.getAge().trim();
		String gender=NewRegistrationForm.getGender().trim();
		String address=NewRegistrationForm.getAddress().trim();
		String occupation=NewRegistrationForm.getOccupation().trim();
		String acctype=NewRegistrationForm.getAcctype().trim();
		String contactnumber=NewRegistrationForm.getContact().trim();
		String accnumber=NewRegistrationForm.getAccnumber().trim();
		String amount=NewRegistrationForm.getAmount().trim();
		String password=NewRegistrationForm.getPassword().trim();
		String cpassword=NewRegistrationForm.getCpassword().trim();
		String status="failure";
		String type;
		String result="";
		Process compile;
		Vector vector=new Vector();
		vector.add(name);
		vector.add(dob);
		vector.add(age);
		vector.add(gender);
		vector.add(address);
		vector.add(occupation);
		vector.add(acctype);
		vector.add(contactnumber);
		vector.add(accnumber);
		vector.add(amount);
		vector.add(password);
		vector.add(cpassword);
		System.out.println("values in vector  " +vector);
		HttpSession session=request.getSession();
		String process=(String)session.getAttribute("process");
		System.out.println("session value  " +process);
		DataBase.database data=new DataBase.database();
		
		if(process.equals("normal"))
		{
			 data.setTableName("customerdetails");
			 data.setNewReg(vector,accnumber);
			   
			 result=data.getNewReg();
			   System.out.println(result);
		}
		else if(process.equals("positive"))
		{
			String file="D:\\WASP\\";
		      
	    	
		    FileReader fr=new FileReader(file+"Metastringreg.java");
		    System.out.println("file reader");
		    BufferedReader br=new BufferedReader(fr);
		    System.out.println("buffer reader");
            String datas="";
            String s="";
            while((s=br.readLine())!=null)
            {
            	s=s.replace("user",name);
            	s=s.replace("birth", dob);
            	s=s.replace("old", age);
            	s=s.replace("sex",gender );
            	s=s.replace("place", address);
            	s=s.replace("work",occupation);
            	s=s.replace("type", acctype);
            	s=s.replace("phone",contactnumber);
            	s=s.replace("111",accnumber);
            	s=s.replace("000", amount);
            	s=s.replace("333",password);
            	s=s.replace("444",cpassword);
            	
            	datas=datas+"\n"+s;
            }
            System.out.println(datas);
            br.close();
   	     FileWriter fw=new FileWriter(file+"Metastringreg.java");
   	     fw.write(datas);
   	     fw.flush();
   	     fw.close();	
   	     String JAVA_HOME = System.getProperty("java.home");
	 	 String java_dir	= JAVA_HOME.substring(0,JAVA_HOME.lastIndexOf(File.separator));
	 	 String compileCommand = java_dir+File.separator+"bin"+File.separator+"javac.exe ";
	 	 String path="-d "+" "+file;
	 	 String fullpath=file+"Metastringreg.java";
	 	 System.out.println(compileCommand +" "+path+"\\"+" "+fullpath);
	 	
	 	compile = Runtime.getRuntime().exec(compileCommand +" "+path+"\\"+" "+fullpath);
	    System.out.println("comple class created");
	    Thread.sleep(3000);
	    WASP.PositiveTaint positive=new WASP.PositiveTaint();
	      positive.Regcheck();
	      positive.changeclass("samplreg.txt","Metastringreg");
	 	  if(positive.result.equals("notinjected"))
           
	 	  {
	 		 data.setTableName("customerdetails");
			 data.setInsert(vector);
			   
			 result=data.getInsert();
			   System.out.println(result);
	 	  }
	 	  else if(positive.result.equals("injected"))
	 	  {
	 		  result="failure";
	 	  }

		}
		else if(process.equals("character"))
		{
		 WASP.CharacterLevel character=new WASP.CharacterLevel();
		 character.calculate(vector);
		 status=character.injection;
		 System.out.println("status in newregistartion action " +status);
		 type=character.typeofinjection;
		 System.out.println("injection found in newregistration " +type);
		 //session.setAttribute("typeofinje", type);
		 request.setAttribute("typeofinje", type);
		 if(status.equals("sucess"))
		 {
			 data.setTableName("customerdetails");
			 data.setInsert(vector);
			   
			 result=data.getInsert();
			   System.out.println(result);
			 
		 }
		 else
		 {
			 result="failure";
			 System.out.println("else in new registeraction " + data.getInsert());
		 }
		}
		else if(process.equals("syntax"))
		{
			
			
			DataBase.databasesyntax datasyntax=new DataBase.databasesyntax();
			datasyntax.setInsertdetails(name, dob, age, gender, address, occupation, acctype, contactnumber, accnumber, amount, password, cpassword,"customerdetails");
	        String givequery=datasyntax.getInsertdetails();
	        System.out.println(givequery);
	        WASP.SyntaxAware syntax=new WASP.SyntaxAware();
		    syntax.function(givequery,"insert");
		    syntax.setInsertdetails();
		    name=syntax.getName();
			dob=syntax.getDob();
			age=syntax.getAge();
			gender=syntax.getGender();
		    address=syntax.getAddress();
			occupation=syntax.getOccupation();
			acctype=syntax.getAcctype();
			contactnumber=syntax.getContact();
			amount=syntax.getAmount();
			accnumber=syntax.getAccountnumber();
			password=syntax.getPassword();
			cpassword=syntax.getCpassword();
		    String tablename=syntax.getTablename();
			String runquery="insert into "+tablename+" values('"+name+"','"+dob+"','"+age+"','"+gender+"','"+address+"','"+occupation+"','"+acctype+"','"+contactnumber+"','"+amount+"','"+accnumber+"','"+password+"','"+cpassword+"')";
			System.out.println("qyerttgggdgdgdg  " +runquery);
			datasyntax.setRunquery(runquery);
		    result=datasyntax.getRunquery();
			
		}
		  
		  
		return mapping.findForward(result);
	}
}