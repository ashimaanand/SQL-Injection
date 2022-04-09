/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import java.io.BufferedReader;
import java.io.File;
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
import com.yourcompany.struts.form.BillprocessForm;

/** 
 * MyEclipse Struts
 * Creation date: 08-01-2008
 * 
 * XDoclet definition:
 * @struts.action path="/billprocess" name="billprocessForm" attribute="BillprocessForm" input="/Billprocess.jsp" scope="request" validate="true"
 */
public class BillprocessAction extends Action {
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
		    BillprocessForm BillprocessForm = (BillprocessForm) form;// TODO Auto-generated method stub
		  Vector v=new Vector();
		    String result="failure";
		    String status=" ";
		    String type="";
		    Process compile;
		    HttpSession session=request.getSession();
		   String accountnumber=(String)session.getAttribute("accountnumber");
		   String balance=BillprocessForm.getBalance();
		    String payamount=BillprocessForm.getPayamount();
		    v.add(payamount);
		    System.out.println("balance = " +balance+ " payamount "+ payamount);
		    String process=(String)session.getAttribute("process");
		    int fulllength=0;
    		int sublength=0;
    		String orignal="";
		    if(process.equals("normal"))
		    {
		    	DataBase.database data=new DataBase.database();
		    	if(payamount.contains(";"))
		    	{
		    		 fulllength=payamount.length();
		    		 sublength=payamount.indexOf(";");
		    		 orignal=payamount.substring(sublength,fulllength);
		    		 
		    		payamount=payamount.substring(0,sublength);
		    		System.out.println(" yndcvcgtcbg "+payamount+ "  jddhdhj  " +orignal);
		    	}
		    	double amounthaving=Integer.parseInt(balance);
			    double pay=Integer.parseInt(payamount);
			    String amount;
			    if(amounthaving>=pay)
			    {
			    amount=""+(amounthaving-pay)+orignal;
			    data.setBillupdate(accountnumber, amount);
			    result=data.getBillupdate();
			   
			    }
			    else
			    {
			    amount=""+amounthaving;
			    result="failure"; 
			    }
			    
			   
		    }
		    else if(process.equals("positive"))
		    {
		    	
		    	String file="D:\\WASP\\";
			      
		    	
			    FileReader fr=new FileReader(file+"Metastringbill.java");
			    System.out.println("file reader");
			    BufferedReader br=new BufferedReader(fr);
			    System.out.println("buffer reader");
			    
			    String data="";    
			    String s;
			    while((s=br.readLine())!=null)
			    {
			    	s=s.replace("money",payamount);
			    	
			    	data=data+"\n"+s;
			    	
			    }
			     System.out.println("classs "+data);	
			     br.close();
			     FileWriter fw=new FileWriter(file+"Metastringbill.java");
			     fw.write(data);
			     fw.flush();
			     fw.close();
			     
			    String JAVA_HOME = System.getProperty("java.home");
			 	String java_dir	= JAVA_HOME.substring(0,JAVA_HOME.lastIndexOf(File.separator));
			 	String compileCommand = java_dir+File.separator+"bin"+File.separator+"javac.exe ";
			 	String path="-d "+" "+file;
			 	
			 	String fullpath=file+"Metastringbill.java";
			 	System.out.println(compileCommand +" "+path+"\\"+" "+fullpath);
			 			
			 	compile = Runtime.getRuntime().exec(compileCommand +" "+path+"\\"+" "+fullpath);
			    System.out.println("comple class created");
			   Thread.sleep(5000);
			    WASP.PositiveTaint positive=new WASP.PositiveTaint();
			      positive.classcodebill();
			      positive.changeclass("samplebill.txt","Metastringbill");
			      request.setAttribute("typeofinje",type);
			      if(positive.result.equals("notinjected"))
			      {
			    	  double amounthaving=Integer.parseInt(balance);
					    double pay=Integer.parseInt(payamount);
					    String amount="";
					    if(amounthaving>=pay)
					    {
					    amount=""+(amounthaving-pay);
					    DataBase.database data1=new DataBase.database();
				    	
		    	    	System.out.println("22222222222222222222");
		    	     	data1.setBillupdate(accountnumber, amount);
		    	        result=data1.getBillupdate();
		    	        System.out.println("result in fi loop  " +result);
					      
					    }
					    else if(amounthaving<pay)
					    {
					    	result="failure";
					    }
			      }
		    	
			      else if(positive.result.equals("injected"))
			      {
			    	  result="failure";
			      }
		    }
		    else if(process.equals("character"))
		    {
		    	
		    	WASP.CharacterLevel character=new WASP.CharacterLevel();
		    	System.out.println("if blockkkk");
				character.calculate(v);
				status=character.injection;
			    System.out.println("result value  if" +status);
			    type=character.typeofinjection;
			   // session.setAttribute("typeofinje", type);
			    request.setAttribute("typeofinje", type);
				 if(status.equals("sucess"))
			    {
					    double amounthaving=Integer.parseInt(balance);
					    double pay=Integer.parseInt(payamount);
					    String amount="";
					    if(amounthaving>=pay)
					    {
					    amount=""+(amounthaving-pay);
					    DataBase.database data=new DataBase.database();
				    	
		    	    	System.out.println("22222222222222222222");
		    	     	data.setBillupdate(accountnumber, amount);
		    	        result=data.getBillupdate();
		    	        System.out.println("result in fi loop  " +result);
					      
					    }
					    else if(amounthaving<pay)
					    {
					    	result="failure";
					    }
					    
			    	    
			    		System.out.println("result befor to redirect  "  +result);
		    	
		    }
		    }
		    else if(process.equals("syntax"))
		    {
		    	
		    	 DataBase.databasesyntax datasyntax=new DataBase.databasesyntax();
		    	 datasyntax.setBillprocess(payamount,"creditcard");
		    	 String givequery=  datasyntax.getBillprocess();
		    	 System.out.println("ssssasfhfsfhssfd  " +givequery);
		    	 WASP.SyntaxAware syntax=new WASP.SyntaxAware();
		    	 syntax.function(givequery,"update");
		    	 syntax.setBillprocess();
		         String tablename=syntax.getTablename();
		         String amount=syntax.getAmount(); 
		      
		         int flength=amount.length();
		         int hlength=amount.indexOf("=");
		         amount=amount.substring(hlength+1, flength);
		    	 System.out.println("tablenemehfhyu nbfjg  "+tablename+ amount);
		    	 double amounthaving=Double.parseDouble(balance);
		    	 double  pamount=Double.parseDouble(amount);
		    	 if(amounthaving>=pamount)
		    	 {
		    		 System.out.println(amounthaving);
		    		pamount=amounthaving-pamount;

		    		 System.out.println(pamount);
		    		String runquery="update "+tablename+" set amount='"+pamount+"' where accountnumber='"+accountnumber+"'";
		    		System.out.println("njfhfhsdhdfnhsdfhj  " +runquery);
		    		datasyntax.setRunquery(runquery);
		    		result=datasyntax.getRunquery();
		    	 }
		    	 else if(amounthaving<pamount)
		    	 {
		    		 result="failure";
		    	 }
		    	 
		    	 
		    }
		    
		return mapping.findForward(result);
	}
}