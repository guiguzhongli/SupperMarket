package com.atguigu.market.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangzhihao
 * @since 2022-06-15
 */
@Data
@ToString
@TableName("smbms_user")
public class SmbmsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编码
     */
    @TableField("userCode")
    private String userCode;

    /**
     * 用户名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("userPassword")
    private String userPassword;

    /**
     * 性别（1:女、 2:男）
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 用户角色（取自角色表-角色id）
     */
    @TableField("userRole")
    private Integer userRole;

    /**
     * 创建者（userId）
     */
    @TableField("createdBy")
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField("creationDate")
    private LocalDateTime creationDate;

    /**
     * 更新者（userId）
     */
    @TableField("modifyBy")
    private Long modifyBy;

    /**
     * 更新时间
     */
    @TableField("modifyDate")
    private LocalDateTime modifyDate;

    @TableField(exist = false)
    private SmbmsRole role;


}
