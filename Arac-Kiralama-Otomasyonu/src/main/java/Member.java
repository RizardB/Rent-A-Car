import java.awt.Image;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table ( name = "member" )
public class Member {

	@Id
	@Column ( name = "member_tc" )
	private String  memberTc;
	
	@Column ( name = "member_first_name" )
	private String memberFirstName;
	
	@Column ( name = "member_last_name" )
	private String memberLastName;
	
	@Column ( name = "member_email" )
	private String memberEmail;
	
	@Column ( name  = "member_phone" )
	private String memberPhoneNumber;
	
	@Column ( name = "member_address" )
	private String memberAddress;
	
	@Column ( name = "member_gender" )
	private String memberGender;
	
	@Column ( name = "member_job" )
	private String memberJob;
	
	@Column ( name = "member_birthdate" )
	private Date memberBirthdate;
	
	@Column ( name = "member_lincence" )
	private String memberLincence;
	
	@Column (name = "member_lincence_no" )
	private String memberLincenceNo;
	
	@Column (name = "member_notes" )
	private String memberNotes;

	public Member()
	{
		
	}
	
	public Member ( String memberTc, String memberFirstName, String memberLastName, String memberEmail, String memberPhoneNumber, String memberAddress, 
			String memberGender, String memberJob, Date memberBirthDate, String memberLincences, String memberLincenceNo, String memberNotes)
	{
		
		this.memberTc = memberTc;
		this.memberFirstName = memberFirstName;
		this.memberLastName = memberLastName;
		this.memberEmail =  memberEmail;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberAddress = memberAddress;
		this.memberGender = memberGender;
		this.memberJob = memberJob;
		this.memberBirthdate = memberBirthDate;
		this.memberLincence = memberLincences;
		this.memberLincenceNo = memberLincenceNo;
		this.memberNotes = memberNotes;
		
	}

	public String getMemberTc() {
		return memberTc;
	}

	public void setMemberTc(String memberTc) {
		this.memberTc = memberTc;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberJob() {
		return memberJob;
	}

	public void setMemberJob(String memberJob) {
		this.memberJob = memberJob;
	}

	public Date getMemberBirthdate() {
		return memberBirthdate;
	}

	public void setMemberBirthdate(Date memberBirthdate) {
		this.memberBirthdate = memberBirthdate;
	}

	public String getMemberLincence() {
		return memberLincence;
	}

	public void setMemberLincence(String memberLincence) {
		this.memberLincence = memberLincence;
	}

	public String getMemberLincenceNo() {
		return memberLincenceNo;
	}

	public void setMemberLincenceNo(String memberLincenceNo) {
		this.memberLincenceNo = memberLincenceNo;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberNotes() {
		return memberNotes;
	}

	public void setMemberNotes(String memberNotes) {
		this.memberNotes = memberNotes;
	}

}
