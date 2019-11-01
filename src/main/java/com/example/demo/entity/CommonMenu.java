package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "t_common_menu")
public class CommonMenu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="menu_code")
    private String menuCode;

    @Column(name="menu_name")
    private String menuName;

    @Column(name = "menu_time")
    private Date menuTime;

    @Column(name = "menu_zhw")
    private String menuZhw;

    @Column(name="season")
    private String season;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
