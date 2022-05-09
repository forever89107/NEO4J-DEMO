package com.example.neo4jdemo;

import org.junit.jupiter.api.Test;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class Neo4jDemoApplicationTests {
	private static void registerShutdownHook(final GraphDatabaseService graphDB) {
		Runtime.getRuntime().addShutdownHook(
				new Thread() {
					public void run() {
						System.out.println("Server is shutting down");
						graphDB.shutdown();
					}
				}
		);
	}


	//Label类型枚举类
	private static enum MyLabels implements Label {
		MOVIES, USERS
	}

	//关系类型枚举类
	private static enum MyRelationshipTypes implements RelationshipType {
		IS_FRIEND_OF, HAS_SEEN
	}


	public static void main(String[] args) {
		//指定 Neo4j 存储路径，这里的test.db不需要提前创建
		File file = new File("/usr/local/neo4j/data/databases/test.db");
		//Create a new Object of Graph Database
		GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(file);
		System.out.println("Server is up and Running");

		try (Transaction tx = graphDB.beginTx()) {
			//新增Actor节点 添加Label以区分节点类型 每个节点设置name属性
			Node user1 = graphDB.createNode(MyLabels.USERS);
			user1.setProperty("name", "John Johnson");

			Node user2 = graphDB.createNode(MyLabels.USERS);
			user2.setProperty("name", "Kate Smith");

			Node user3 = graphDB.createNode(MyLabels.USERS);
			user3.setProperty("name", "Jack Jeffries");

			/**
			 * 为user1添加Friend关系
			 * 注：Neo4j的关系是有向的箭头，正常来讲Friend关系应该是双向的，
			 * 此处为了简单起见，将关系定义成单向的，不会影响后期的查询
			 */
			user1.createRelationshipTo(user2, MyRelationshipTypes.IS_FRIEND_OF);
			user1.createRelationshipTo(user3, MyRelationshipTypes.IS_FRIEND_OF);

			/**
			 * 新增Movie节点
			 * 添加Lable以区分节点类型
			 * 每个节点设置name属性
			 */
			Node movie1 = graphDB.createNode(MyLabels.MOVIES);
			movie1.setProperty("name", "Fargo");

			Node movie2 = graphDB.createNode(MyLabels.MOVIES);
			movie2.setProperty("name", "Alien");

			Node movie3 = graphDB.createNode(MyLabels.MOVIES);
			movie3.setProperty("name", "Heat");

			/**
			 * 为User节点和Movie节点之间添加HAS_SEEN关系, HAS_SEEN关系设置stars属性
			 */
			Relationship relationship1 = user1.createRelationshipTo(movie1, MyRelationshipTypes.HAS_SEEN);
			relationship1.setProperty("stars", 5);
			Relationship relationship2 = user2.createRelationshipTo(movie3, MyRelationshipTypes.HAS_SEEN);
			relationship2.setProperty("stars", 3);
			Relationship relationship6 = user2.createRelationshipTo(movie2, MyRelationshipTypes.HAS_SEEN);
			relationship6.setProperty("stars", 6);
			Relationship relationship3 = user3.createRelationshipTo(movie1, MyRelationshipTypes.HAS_SEEN);
			relationship3.setProperty("stars", 4);
			Relationship relationship4 = user3.createRelationshipTo(movie2, MyRelationshipTypes.HAS_SEEN);
			relationship4.setProperty("stars", 5);

			tx.success();
			System.out.println("Done successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			graphDB.shutdown();    //关闭数据库
		}

		//Register a Shutdown Hook
		registerShutdownHook(graphDB);
	}
}
