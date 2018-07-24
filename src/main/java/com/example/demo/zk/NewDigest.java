package com.example.demo.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.apache.zookeeper.data.*;
import java.util.*;

public class NewDigest {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        //new一个acl
        List<ACL> acls = new ArrayList<ACL>();
        //添加第一个id，采用用户名密码形式
        Id id1 = new Id("digest",
                DigestAuthenticationProvider.generateDigest("admin:erp@98ep.com"));
        ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);
        acls.add(acl1);
        //添加第二个id，所有用户可读权限
        Id id2 = new Id("world", "anyone");
        ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);
        acls.add(acl2);

        // zk用admin认证，创建/test ZNode。

        ZooKeeper zk = new ZooKeeper(
                "123.56.106.51:2181,47.94.46.230:2181,123.56.165.120:2181",
                2000, null);
        zk.addAuthInfo("digest", "admin:erp@98ep.com".getBytes());
        zk.create("/test", "data".getBytes(), acls, CreateMode.PERSISTENT);
   }
}