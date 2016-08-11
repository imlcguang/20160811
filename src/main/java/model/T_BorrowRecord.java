package model;

import java.util.Date;

import model.T_Customer;
import model.T_Model;
import model.T_User;

public class T_BorrowRecord {
	private Integer BorrowNo;
	private T_Customer CustomerID ;
	private Date SendDatetime;
	private T_User BorrowPermitPerson;
	private T_User BorrowOperator;
	private Date BorrowOperatDatetime;
	private Date PlanReturnDatetime;
	private T_Model ModelID;
	private Integer BorrowNumber;
	private Integer BorrowCheckNo;
	private Date ReturnDatetime;
	private T_User ReturnOperator;

	public T_BorrowRecord(){
		
	}
	
	
	
	public T_BorrowRecord(Integer borrowNo, T_Customer customerID, Date sendDatetime, T_User borrowPermitPerson,
			T_User borrowOperator, Date borrowOperatDatetime, Date planReturnDatetime, T_Model modelID,
			Integer borrowNumber, Integer borrowCheckNo, Date returnDatetime, T_User returnOperator) {
		//super();
		BorrowNo = borrowNo;
		CustomerID = customerID;
		SendDatetime = sendDatetime;
		BorrowPermitPerson = borrowPermitPerson;
		BorrowOperator = borrowOperator;
		BorrowOperatDatetime = borrowOperatDatetime;
		PlanReturnDatetime = planReturnDatetime;
		ModelID = modelID;
		BorrowNumber = borrowNumber;
		BorrowCheckNo = borrowCheckNo;
		ReturnDatetime = returnDatetime;
		ReturnOperator = returnOperator;
	}



	public Integer getBorrowNo() {
		return BorrowNo;
	}

	public void setBorrowNo(Integer borrowNo) {
		BorrowNo = borrowNo;
	}

	public T_Customer getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(T_Customer customerID) {
		CustomerID = customerID;
	}

	public Date getSendDatetime() {
		return SendDatetime;
	}

	public void setSendDatetime(Date sendDatetime) {
		SendDatetime = sendDatetime;
	}

	public T_User getBorrowPermitPerson() {
		return BorrowPermitPerson;
	}

	public void setBorrowPermitPerson(T_User borrowPermitPerson) {
		BorrowPermitPerson = borrowPermitPerson;
	}

	public T_User getBorrowOperator() {
		return BorrowOperator;
	}

	public void setBorrowOperator(T_User borrowOperator) {
		BorrowOperator = borrowOperator;
	}

	public Date getBorrowOperatDatetime() {
		return BorrowOperatDatetime;
	}

	public void setBorrowOperatDatetime(Date borrowOperatDatetime) {
		BorrowOperatDatetime = borrowOperatDatetime;
	}

	public Date getPlanReturnDatetime() {
		return PlanReturnDatetime;
	}

	public void setPlanReturnDatetime(Date planReturnDatetime) {
		PlanReturnDatetime = planReturnDatetime;
	}

	public T_Model getModelID() {
		return ModelID;
	}

	public void setModelID(T_Model modelID) {
		ModelID = modelID;
	}

	public Integer getBorrowNumber() {
		return BorrowNumber;
	}

	public void setBorrowNumber(Integer borrowNumber) {
		BorrowNumber = borrowNumber;
	}

	public Integer getBorrowCheckNo() {
		return BorrowCheckNo;
	}

	public void setBorrowCheckNo(Integer borrowCheckNo) {
		BorrowCheckNo = borrowCheckNo;
	}

	public Date getReturnDatetime() {
		return ReturnDatetime;
	}

	public void setReturnDatetime(Date returnDatetime) {
		ReturnDatetime = returnDatetime;
	}

	public T_User getReturnOperator() {
		return ReturnOperator;
	}

	public void setReturnOperator(T_User returnOperator) {
		ReturnOperator = returnOperator;
	}

	@Override
	public String toString() {
		return "BorrowRecord [BorrowNo=" + BorrowNo + ", CustomerID=" + CustomerID + ", SendDatetime=" + SendDatetime
				+ ", BorrowPermitPerson=" + BorrowPermitPerson + ", BorrowOperator=" + BorrowOperator
				+ ", BorrowOperatDatetime=" + BorrowOperatDatetime + ", PlanReturnDatetime=" + PlanReturnDatetime
				+ ", ModelID=" + ModelID + ", BorrowNumber=" + BorrowNumber + ", BorrowCheckNo=" + BorrowCheckNo
				+ ", ReturnDatetime=" + ReturnDatetime + ", ReturnOperator=" + ReturnOperator + "]";
	}

}

