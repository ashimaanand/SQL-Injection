/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 08-21-2008
 * 
 * XDoclet definition:
 * @struts.form name="amountcreditForm"
 */
public class AmountcreditForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** amount property */
	private String amount;

	/** accountnumber property */
	private String accountnumber;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the amount.
	 * @return String
	 */
	public String getAmount() {
		return amount;
	}

	/** 
	 * Set the amount.
	 * @param amount The amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/** 
	 * Returns the accountnumber.
	 * @return String
	 */
	public String getAccountnumber() {
		return accountnumber;
	}

	/** 
	 * Set the accountnumber.
	 * @param accountnumber The accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
}