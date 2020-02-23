package com.daling.es;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

public class EStest {

	/**
	 * 接ES获取Client对象
	 */
	public TransportClient getClient() throws Exception {
		// on startup
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
		return client;
	}

	// 添加
	@Test
	public void testAdd() throws Exception {
		// 构建请求对象,crm:索引库 user:表名 1:文档ID
		IndexRequestBuilder prepareIndex = getClient().prepareIndex("crm", "user", "1");
		// 添加数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("name", "kd");
		map.put("age", 21);
		map.put("gj", "china");
		// 响应对象,发送数据给客户端
		IndexResponse indexResponse = prepareIndex.setSource(map).get();
		System.out.println(indexResponse);
		// 关闭资源
		getClient().close();
	}

	// 删除
	@Test
	public void testDelete() throws Exception {
		// 构建请求对象,crm:索引库 user:表名 1:文档ID
		DeleteRequestBuilder prepareDelete = getClient().prepareDelete("crm", "user", "1");
		// 响应对象,发送数据给客户端
		DeleteResponse deleteResponse = prepareDelete.get();
		System.out.println(deleteResponse);
		// 关闭资源
		getClient().close();
	}

	// 修改,和Kibana5不同,必须要有数据才能修改,没有添加功能
	@Test
	public void testUpdate() throws Exception {
		// 构建请求对象,crm:索引库 user:表名 1:文档ID
		UpdateRequestBuilder prepareUpdate = getClient().prepareUpdate("crm", "user", "1");
		// 添加数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("name", "kd");
		map.put("age", 23);
		map.put("gj", "china");
		// 响应对象,发送数据给客户端
		// 局部更新,注意:在APIjar包里,java认为局部更新很重要
		UpdateResponse updateResponse = prepareUpdate.setDoc(map).get();
		System.out.println(updateResponse);
	}

	// 查找,根据id查找
	@Test
	public void testGet() throws Exception {
		// 构建请求对象,crm:索引库 user:表名 1:文档ID
		GetRequestBuilder prepareGet = getClient().prepareGet("crm", "user", "1");
		// 响应对象,发送数据给客户端
		GetResponse getResponse = prepareGet.get();
		System.out.println(getResponse.getSource());
		// 关闭资源
		getClient().close();
	}

	// 添加修改,没有就添加,有就修改
	@Test
	public void testUpdateOrSave() throws Exception {
		// 添加数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("name", "kd");
		map.put("age", 33);
		map.put("gj", "china");
		// 创建索引
		IndexRequest indexRequest = new IndexRequest("crm", "user", "1").source(map);
		// 跟新操作
		UpdateRequest updateRequest = new UpdateRequest("crm", "user", "1").doc(map).upsert(indexRequest);
		getClient().update(updateRequest).get();
		// 关闭资源
		getClient().close();
	}

	// 批量操作(这里批量添加)
	@Test
	public void testBulk() throws Exception {
		// 构建批量对象
		BulkRequestBuilder bulkRequest = getClient().prepareBulk();
		// 批量添加数据
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1);
			map.put("name", "kd" + i);
			map.put("age", i + 18);
			map.put("gj", "china");
			bulkRequest.add(getClient().prepareIndex("crm", "vip", 1 + "").setSource(map));
		}
		// ES执行兵获取结果
		BulkResponse bulkResponse = bulkRequest.get();
		// 错误处理
		if (bulkResponse.hasFailures()) {
			System.out.println("出错了!");
		}
		// 关闭资源
		getClient().close();
	}

	//搜索,查询名字(kd),国家(gj),年龄(20-30),页码(1),每页显示数据条数(2),排序方式(根据年龄大小降序)
	@Test
	public void testQuery() throws Exception {
		//构建排序对象
		SortBuilder sortBuilder = new FieldSortBuilder("age");
		sortBuilder.order(SortOrder.DESC);
		//构建查询对象
		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
		//构建mast搜索条件
		boolQueryBuilder.must(new MatchQueryBuilder("name","kd"));
		//构建filter 过滤条件
		List<QueryBuilder> builders = boolQueryBuilder.filter();
		builders.add(new TermQueryBuilder("gj","china"));
		builders.add(new RangeQueryBuilder("age").gte(20).lte(30));
		//构建搜索对象
		SearchResponse searchResponse = getClient().prepareSearch("crm").setTypes("user").
				setFrom(0).setSize(2).addSort(sortBuilder).setQuery(boolQueryBuilder).get();
		//返回结果
		SearchHits searchHits = searchResponse.getHits();
//		System.out.println(searchHits.totalHits());
		//循环
		for (SearchHit searchHit : searchHits.getHits()) {
			System.out.println(searchHit.getScore());
		}
	}

}
