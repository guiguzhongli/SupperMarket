package com.atguigu.market.bean;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Role
 * @Description TODO
 * @Author Administrator
 * @Date 2022/5/25 11:20
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role implements Serializable {
    private Integer id;   //id
    private String roleCode; //角色编码
    private String roleName; //角色名称
    private Integer createdBy; //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy; //更新者
    private Date modifyDate;//更新时间
}
