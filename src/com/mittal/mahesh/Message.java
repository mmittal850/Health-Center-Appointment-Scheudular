/**
 * 
 */
package com.mittal.mahesh;

/**
 * @author mahes
 *
 */
public class Message {
	
	
	private int msgId;
	private int pat_id;
	private int dr_id;
	private String message;
	public Message(int msgId, int pat_id, int dr_id, String message) {
		this.msgId = msgId;
		this.pat_id = pat_id;
		this.dr_id = dr_id;
		this.message = message;
	}
	public Message(int pat_id, int dr_id, String message) {
		super();
		this.pat_id = pat_id;
		this.dr_id = dr_id;
		this.message = message;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", pat_id=" + pat_id + ", dr_id=" + dr_id + ", message=" + message + "]";
	}
	
	
	
	

}
