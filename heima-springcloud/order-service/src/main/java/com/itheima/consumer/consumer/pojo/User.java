package com.itheima.consumer.consumer.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

//在编译阶段会根据注解自动生成对应的方法；data包含get/set/hashCode/equals/toString等方法
@Data
@Table(name = "tb_user")
public class User {

    @Id
    //主键回填
//    @KeySql(useGeneratedKeys = true)
    private String username;//主键,用户名
    private String password;//密码
    private String phone;//注册手机号
    private String email;//注册邮箱
    private Date created;//创建日期
    private Date updated;//修改日期
    private String sourceType;//会员来源
    private String nickName;//昵称
    private String name;//真是姓名
    private String status;//试用状态
    private String headPic;//t头像地址
    private String qq;//QQ号
    private String isMobileCheck;//手机是否校验
    private String isEmailCheck;//邮箱是否校验
    private String sex;//性别
    private Integer userLevel;//会员等级
    private Integer points;//积分
    private Integer experienceValue;//经验值
    private Date birthday;//出生日期
    private Date lastLoginTime;//最后的登录时间

    private List<Order> orderList;

}
