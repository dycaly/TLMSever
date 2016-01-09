package com.dycaly.TLMSever.Manage;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dycaly.TLMSever.Entity.Reqaddfriend;
import com.dycaly.TLMSever.Entity.User;
import com.dycaly.TLMSever.Entity.Userditals;
import com.dycaly.TLMSever.Entity.Userfriend;
import com.dycaly.TLMSever.Result.FriendInfo;
import com.dycaly.TLMSever.Result.FriendsResult;
import com.dycaly.TLMSever.Result.ReqAddFriendInfo;
import com.dycaly.TLMSever.Result.ReqAddFriendResult;
import com.google.gson.Gson;

public class UserManage {

	private User mUser = null;
	private Session session;
	private Transaction transaction;
	private ArrayList<String> friends = new ArrayList<String>();

	public void close() {
		session.close();
	}

	public UserManage() {
		session = HibernateSessionFactory.getSession();
	}

	public UserManage(int Id) {
		session = HibernateSessionFactory.getSession();
		String hql = "from User u where u.userId=" + Id;

		Query query = session.createQuery(hql);
		mUser = (User) query.uniqueResult();
	}

	public UserManage(String username, int method) {
		if (method != 2015111) {
			return;
		}
		session = HibernateSessionFactory.getSession();
		String hql = "from User u where u.username='" + username + "'";
		Query query = session.createQuery(hql);
		mUser = (User) query.uniqueResult();
	}

	public UserManage(String token) {
		session = HibernateSessionFactory.getSession();
		String hql = "from User u where u.token='" + token + "'";

		Query query = session.createQuery(hql);
		mUser = (User) query.uniqueResult();
	}

	public UserManage(String username, String password) {
		session = HibernateSessionFactory.getSession();
		String hql = " from User u where u.username='" + username
				+ "'and u.password='" + password + "' ";
		Query query = session.createQuery(hql);
		mUser = (User) query.uniqueResult();

	}

	public boolean isExist() {
		return (mUser != null);
	}

	public void registUser(String username, String password) {

		String hqlSame = " from User u where u.username = '" + username + "' ";
		Query query = session.createQuery(hqlSame);
		User user = (User) query.uniqueResult();
		if (user == null) {
			transaction = session.beginTransaction();
			String hqlId = " select u.userId from User u where u.userId >=ALL(select u.userId from u)";
			Query queryId = session.createQuery(hqlId);
			int id = (int) queryId.uniqueResult();
			id++;
			mUser = new User(id, username, password, username + "_" + password,
					0);
			session.save(mUser);
			Userditals ud = new Userditals();
			
			ud.setUser(mUser);
			ud.setUserId(id);
			ud.setNickname(username);
			ud.setPicUrl("http://121.42.30.74:8080/TLMSever/LoadImage?name=default.png");
			ud.setName("none");
			ud.setAge(0);
			ud.setSex(0);
			ud.setSchool("none");
			ud.setCollege("none");
			ud.setEmail("none");
			ud.setPhone("none");
			ud.setRegdate(new Timestamp(System.currentTimeMillis()));
			session.save(ud);
			transaction.commit();

		}
	}

	public int updatePassword(String bepassword, String password) {
		if (mUser == null) {
			return 1;
		}
		if (!bepassword.equals(mUser.getPassword())) {
			return 2;
		}
		transaction = session.beginTransaction();
		mUser.setPassword(password);
		mUser.setToken(mUser.getUsername() + "_" + password);
		session.update(mUser);
		transaction.commit();
		return 0;
	}

	public String getToken() {
		if (mUser != null) {
			return mUser.getToken();
		} else {
			return null;
		}

	}

	public String getUserName() {
		if (mUser != null) {
			return mUser.getUsername();
		} else {
			return null;
		}
	}

	public int getUserId() {
		if (mUser != null) {
			return mUser.getUserId();
		} else {
			return -1;
		}
	}

	public int addFriend(String username) {

		if (mUser != null) {
			transaction = session.beginTransaction();

			String hql = " from User u where u.username='" + username + "'";
			Query query = session.createQuery(hql);
			User user = (User) query.uniqueResult();

			String hqlId = " select uf.userfriend from Userfriend uf where uf.userfriend >=ALL(select uf.userfriend from uf)";
			Query queryId = session.createQuery(hqlId);
			int id = (int) queryId.uniqueResult();
			id++;
			Userfriend uf = new Userfriend(id, mUser, user);

			session.save(uf);
			transaction.commit();
		}
		return 1;
	}

	public ArrayList<String> getFriends() {

		friends.clear();

		String hql = " select uf.userByOwnedId from Userfriend uf where uf.userByOwnerId in (from User u where u.userId="
				+ mUser.getUserId() + ")";
		Query query = session.createQuery(hql);
		List<User> users = query.list();
		for (User ur : users) {
			String hqlNickName = "select ud.nickname from Userditals ud where ud.userId = "
					+ ur.getUserId();
			Query nnQuery = session.createQuery(hqlNickName);
			friends.add((String) nnQuery.uniqueResult());
		}

		return friends;
	}

	public String getFriendsList() {

		friends.clear();

		String hql = " select uf.userByOwnedId from Userfriend uf where uf.userByOwnerId in (from User u where u.userId="
				+ mUser.getUserId() + ")";
		Query query = session.createQuery(hql);
		List<User> users = query.list();
		FriendsResult fr = new FriendsResult(0);
		for (User ur : users) {
			String hqlNickName = "select ud.nickname from Userditals ud where ud.userId = "
					+ ur.getUserId();
			Query nnQuery = session.createQuery(hqlNickName);
			fr.addFriendinfo(new FriendInfo("http", ur.getUsername(),
					(String) nnQuery.uniqueResult()));
		}

		Gson gson = new Gson();

		return gson.toJson(fr);
	}

	public int reqAddFriend(String username) {
		UserManage um = new UserManage(username, 2015111);
		String he = "from Userfriend uf where uf.userByOwnerId in (from User u1 where u1.userId="
				+ this.getUserId()
				+ ") and uf.userByOwnedId in (from User u2 where u2.userId="
				+ um.getUserId() + ")";
		Query query1 = session.createQuery(he);
		Userfriend uf1 = (Userfriend) query1.uniqueResult();
		if (uf1 != null) {
			return 2;
		}
		if (um.isExist()) {
			String hql = "from Reqaddfriend raf where raf.userByReqerId in (from User u where u.userId="
					+ mUser.getUserId()
					+ ") and raf.userByReqedId in (from User uk where uk.userId="
					+ um.getUserId() + ")";
			Query query = session.createQuery(hql);
			Reqaddfriend mRaf = (Reqaddfriend) query.uniqueResult();
			if (mRaf != null) {
				return 1;
			}
			transaction = session.beginTransaction();
			Reqaddfriend raf = new Reqaddfriend(um.getUser(), mUser,
					new Timestamp(System.currentTimeMillis()),
					0);
			session.save(raf);
			transaction.commit();
			return 0;
		} else {
			return 3;
		}

	}

	public int operateAddFriend(String username, int operate) {
		UserManage umReqer = new UserManage(username, 2015111);
		String hql = "from Reqaddfriend raf where raf.userByReqedId in (from User u where u.userId="
				+ mUser.getUserId()
				+ ") and raf.userByReqerId in (from User uk where uk.userId="
				+ umReqer.getUserId() + ")";
		Query query = session.createQuery(hql);
		Reqaddfriend mRaf = (Reqaddfriend) query.uniqueResult();
		if (mRaf == null) {
			return 1;
		}
		transaction = session.beginTransaction();
		session.delete(mRaf);
		transaction.commit();
		if (operate == 0) {
			this.addFriend(username);
			umReqer.addFriend(this.getUserName());
			return 0;
		} else {
			return 0;
		}
	}

	public String getFriendsReq() {
		String hql = "from Reqaddfriend r where r.userByReqedId in (from User u where u.userId="
				+ mUser.getUserId() + ") and r.issaw = 0";
		transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		ReqAddFriendResult rafr = new ReqAddFriendResult(0);
		List<Reqaddfriend> reqaddfriends = query.list();
		for (Reqaddfriend reqaddfriend : reqaddfriends) {
			Iterator<Userditals> udIterator = reqaddfriend.getUserByReqerId().getUserditalses().iterator();
			Userditals userditals = new Userditals();
			if (udIterator.hasNext()) {
				userditals = udIterator.next();
			}
			ReqAddFriendInfo item = new ReqAddFriendInfo(false, userditals.getPicUrl(),reqaddfriend
					.getUserByReqerId().getUsername(), new UserDitalsManage(
					reqaddfriend.getUserByReqerId().getUserId())
					.getUserditals().getNickname(), reqaddfriend
					.getUserByReqedId().getUsername(),reqaddfriend.getReqtime().toString());
			rafr.addReqAddFriendInfo(item);
			reqaddfriend.setIssaw(1);
			session.update(reqaddfriend);
		}
		transaction.commit();
		Gson gson =new Gson();
		return gson.toJson(rafr);
	}

	public int deleteFriend(String username) {

		UserManage um = new UserManage(username, 2015111);

		String hql1 = "from Userfriend uf where uf.userByOwnerId in (from User u1 where u1.userId="
				+ this.getUserId()
				+ ") and uf.userByOwnedId in (from User u2 where u2.userId="
				+ um.getUserId() + ")";
		String hql2 = "from Userfriend uf where uf.userByOwnerId in (from User u1 where u1.userId="
				+ um.getUserId()
				+ ") and uf.userByOwnedId in (from User u2 where u2.userId="
				+ this.getUserId() + ")";
		transaction = session.beginTransaction();
		Query query1 = session.createQuery(hql1);
		Query query2 = session.createQuery(hql2);
		Userfriend uf1 = (Userfriend) query1.uniqueResult();
		Userfriend uf2 = (Userfriend) query2.uniqueResult();
		if (uf1 != null && uf2 != null) {
			session.delete(uf1);
			session.delete(uf2);
			transaction.commit();
			return 0;
		} else {
			return 1;
		}

	}

	public User getUser() {
		return mUser;
	}
}
