package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_recipes")
public class Recipes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="menu_code")
    private String menuCode;

    @Column(name="menu_type")
    private String menuType;

    @Column(name="menu_Name")
    private String menuName;

    @Column(name="is_muslim_flag")
    private String isMuslimFlag;

    @Column(name="is_cuisine_flag")
    private String isCuisineFlag;

    @Column(name="use_times")
    private String useTimes;

    @Column(name = "en")
    private String en;

    @Column(name = "pro")
    private String pro;

    @Column(name = "fat")
    private String fat;

    @Column(name = "cab")
    private String cab;

    @Column(name = "fab")
    private String fab;

    @Column(name = "ca")
    private String ca;

    @Column(name = "fe")
    private String fe;

    @Column(name = "na")
    private String na;

    @Column(name = "k")
    private String k;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
