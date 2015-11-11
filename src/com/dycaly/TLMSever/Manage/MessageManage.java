package com.dycaly.TLMSever.Manage;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dycaly.TLMSever.Entity.Message;
import com.dycaly.TLMSever.Entity.User;
import com.dycaly.TLMSever.Result.MessageInfo;
import com.dycaly.TLMSever.Result.MessageResult;
import com.google.gson.Gson;

public class MessageManage {

	private UserManage mUserManage;
	private Session session;
	private Transaction transaction;
	private ArrayList<Message> messages;

	public MessageManage(String token) {
		session = HibernateSessionFactory.getSession();
		this.mUserManage = new UserManage(token);
		messages = new ArrayList<Message>();
		String hql = "from Message";
		Query query = session.createQuery(hql);
		messages = (ArrayList<Message>) query.list();
	}

	public int sendMessage(String username, String content) {
		if (!mUserManage.isExist()) {
			return 1;
		}
		transaction = session.beginTransaction();
		Query query = session.createQuery("from User u where u.username='"
				+ username + "'");
		User recUser = (User) query.uniqueResult();
		if (recUser == null) {
			return 2;
		}
		session.save(new Message(mUserManage.getUser(), recUser, content,
				new Timestamp(System.currentTimeMillis()), 0));
		transaction.commit();
		return 0;
	}

	public String getMessagesJson() {
		MessageResult mr = new MessageResult(0);
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		for (Message m : messages) {
			if (m.getIsSaw() == 0 && m.getUserByReceverId().getUserId() == mUserManage.getUserId()) {
				
				UserDitalsManage uManage = new UserDitalsManage(m.getUserBySenderId().getUserId());
				
				mr.addMessageInfo(new MessageInfo(m.getUserBySenderId()
						.getUsername(),uManage.getUserditals().getNickname(), m.getUserByReceverId().getUsername(),
						m.getContent(), m.getSendate().toString()));
				m.setIsSaw(1);
				session.update(m);
			}
		}
		transaction.commit();
		Gson gson = new Gson();
		String result = gson.toJson(mr);
		return result;
	}
	
	public void close(){
		session.close();
	}
}
