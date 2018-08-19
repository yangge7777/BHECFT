package com.yang.rediestest;
import redis.clients.jedis.Jedis;

/**
 *
 * 数据库
 * 类型	特性	优点	缺点
 * 关系型数据库 Oracle、mysql
 * 特性
 * 1、关系型数据库，是指采用了关系模型来组织数据的数据库；
 * 2、关系型数据库的最大特点就是事务的一致性；
 * 3、简单来说，关系模型指的就是二维表格模型，而一个关系型数据库就是由二维表及其之间的联系所组成的一个数据组织。
 * 优点
 * 1、容易理解：二维表结构是非常贴近逻辑世界一个概念，关系模型相对网状、层次等其他模型来说更容易理解；
 * 2、使用方便：通用的SQL语言使得操作关系型数据库非常方便；
 * 3、易于维护：丰富的完整性(实体完整性、参照完整性和用户定义的完整性)大大减低了数据冗余和数据不一致的概率；
 * 4、支持SQL，可用于复杂的查询。
 * 缺点
 * 1、为了维护一致性所付出的巨大代价就是其读写性能比较差；
 * 2、固定的表结构；
 * 3、高并发读写需求；
 * 4、海量数据的高效率读写；
 * 非关系型数据库 MongoDb、redis、HBase
 * 1、使用键值对存储数据；
 * 2、分布式；
 * 3、一般不支持ACID特性；
 * 4、非关系型数据库严格上不是一种数据库，应该是一种数据结构化存储方法的集合。
 * 优点
 * 1、无需经过sql层的解析，读写性能很高；
 * 2、基于键值对，数据没有耦合性，容易扩展；
 * 3、存储数据的格式：nosql的存储格式是key,value形式、文档形式、图片形式等等，文档形式、图片形式等等，而关系型数据库则只支持基础类型。
 * 缺点
 * 1、不提供sql支持，学习和使用成本较高；
 * 2、无事务处理，附加功能bi和报表等支持也不好；
 *
 * Redis 是完全开源免费的，是一个高性能的key-value数据库。
 * Redis 与其他 key - value 缓存产品有以下特点：
 * Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。
 * Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
 */
public class Test {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.16.17.6",6379);
        jedis.auth("cwbcwb");
        System.out.println("Connection to server sucessfully");

//        jedis.set("name1","cwb");
//        String name = jedis.get("name1");
//        System.out.println(name);
//        //Redis 字符串数据类型
//        jedis.set("s1","v1");
//        System.out.println("Redis 字符串数据类型:"+  jedis.get("s1"));
//
////        //Redis 哈希(Hash)是一个string类型的field和value的映射表，hash特别适合用于存储对象。
////        //Redis 中每个 hash 可以存储 232 - 1 键值对（40多亿）。
//        jedis.hset("student","01_id","01");
//        jedis.hset("student","01_name","zhangsan");
//        jedis.hset("student","01_age","10");

//        jedis.hset("student","02_id","02");
//        jedis.hset("student","02_name","zhangsan");
//        jedis.hset("student","02_age","10");
//        jedis.hget("h1","id_name");
//        jedis.hgetAll("h1");
////        //Redis列表是简单的字符串列表，按照插入顺序排序.你可以添加一个元素到列表的头部（左边）或者尾部（右边）
////        //你可以添加一个元素到列表的头部（左边）或者尾部（右边）

      //  jedis.lpush("l22","al");
      //  jedis.lpush("l22","a2");
//        System.out.println("1:"+jedis.lpop("l23"));
//        System.out.println("2:"+jedis.lpop("l23"));

//        //Redis 的 Set 是 String 类型的无序集合。集合成员是唯一的

//        jedis.sadd("s101","21");
//        jedis.sadd("s101","31");
//        jedis.sadd("s101","31");
//        jedis.sadd("s101","41","51");

//        System.out.println(jedis.smembers("s101"));
//        //Redis 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。
//        //不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
//        //有序集合的成员是唯一的,但分数(score)却可以重复。
//        jedis.zadd("z3",1,"abc");
//        jedis.zadd("z3",10,"abc10");
//        jedis.zadd("z3",2,"abc2");
//
//        System.out.println("aaaa:"+jedis.zrange("z3",1,10));

        jedis.close();

    }
}
