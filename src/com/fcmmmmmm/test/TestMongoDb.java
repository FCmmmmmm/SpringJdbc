package com.fcmmmmmm.test;

import java.util.LinkedHashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcmmmmmm.config.MongoDB;
import com.fcmmmmmm.entity.Item;
import com.fcmmmmmm.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoDB.class)
public class TestMongoDb {
	@Autowired
	private MongoOperations mongo;

	/*
	 * @Autowired private MongoTemplate template;
	 */
	@Test
	public void creat() {
		Item item = new Item();
		item.setPrice(10);
		item.setProduct("哇哈哈");
		item.setQuantity(0);

		LinkedHashSet<Item> items = new LinkedHashSet<>();
		items.add(item);
		Order order = new Order();
		order.setCustomer("傻逼");
		order.setId("3");
		order.setType("食品");
		order.setItems(items);
		mongo.save(order, "order");

		// mongo.save(order,"ORDER");
		// mongo.save(order, "Order");
		// 这两种一般不推荐 应全部小写
	}

	@Test
	public void queryById() {
		String id = "99";
		String id2 = "5";
		// 其默认从对应类名的全部小写的库中查找
		Order order = mongo.findById(id2, Order.class);
		// 如果存放的库名不是大小写的 可以手动指定库名
		Order rder = mongo.findById(id, Order.class, "Order");
		// List<Order> lists= mongo.find(Query.query(Criteria.where("type").is("食品")),
		// Order.class);
		// System.out.println(lists.get(0).getCustomer()+lists.get(0).getId());
		System.out.println(order.getCustomer());
		System.out.println("rdr:        " + rder.getCustomer());
	}

	@Test
	public void queryUp() {
		Criteria c1 = Criteria.where("type").is("食品");
		Criteria c2 = Criteria.where("client").is("傻逼");
		List<Order> lists = mongo.find(Query.query(c1).addCriteria(c2), Order.class, "ORDER");
		System.out.println(lists.size());
		System.out.println(lists.get(0).getCustomer());
	}
}
