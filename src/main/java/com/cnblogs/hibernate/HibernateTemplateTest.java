package com.cnblogs.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.apache.commons.lang.StringUtils;

import com.cnblogs.json.pojo.Person;

public class HibernateTemplateTest {
	public static void main( String[] args )
    {
		int totalPage =0;
		final int pageSize = 20;
		int tableNumber = 2;
		int pageIndex = 1;
		int count = 100;
		String endTimeStamp="2018-01-06 22:38:00";
		String startTimeStamp ="2018-01-06 22:30:00";
		byte[] startBytes = startTimeStamp.getBytes();
		byte[] endBytes = endTimeStamp.getBytes();
		SlUserPageInfo pageInfos = hibernateTemplateR.execute(new HibernateCallback<SlUserPageInfo>() {

			@Override
			public SlUserPageInfo doInHibernate(Session session) throws HibernateException {
			SlUserPageInfo pageInfo = new SlUserPageInfo();
			String tableName = "tb_";
			if (tableNumber < 10) {
			tableName += "0";
			}
			tableName += tableNumber;
			System.out.println(tableName);
			String andEndTime = "";
			if (!StringUtils.isEmpty(endTimeStamp)) {
			andEndTime = " and TimeStamp<=:endTimeStamp";
			}
			totalPage = (int) Math.ceil(((double) count) / pageSize);
			pageInfo.setTotalPage((long) totalPage);
			String sql = "select * from " + tableName + " where TimeStamp>:startTimeStamp"
			+ andEndTime + " order by TimeStamp desc offset " + ((pageIndex - 1) * 10)
			+ " rows fetch next " + pageSize + " rows only";
			SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Person.class);
			sqlQuery.setBinary("startTimeStamp", startBytes);
			if (!StringUtils.isEmpty(endTimeStamp)) {
			sqlQuery.setBinary("endTimeStamp", endBytes);
			}
			@SuppressWarnings("unchecked")
			List<Person> listQuery = (List<Person>) sqlQuery.list();
			if (listQuery != null && listQuery.size() > 0) {
			pageInfo.setPerson(listQuery);
		}
			}
			return pageInfo;
			}
			});return pageInfos;
}}
