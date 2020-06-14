package com.github.business.enums;

import lombok.Getter;

import javax.persistence.AttributeConverter;

/**
 * @date 2020/6/15
 */
public enum DeptTypeEnum {

    SECTION_HEAD("Section Head"),

    DEPT_HEAD("Dept Head"),

    BOSS_HEAD("Boss Head");

    @Getter
    private String deptType;

    DeptTypeEnum(String deptType) {
        this.deptType = deptType;
    }

    public static DeptTypeEnum getDeptTypeEnum(String deptType){
        return DeptTypeEnum.valueOf(deptType);
    }

    public static class Converter implements AttributeConverter<DeptTypeEnum, String> {

        @Override
        public String convertToDatabaseColumn(DeptTypeEnum attribute) {
            return attribute.getDeptType();
        }

        @Override
        public DeptTypeEnum convertToEntityAttribute(String dbData) {
            return DeptTypeEnum.getDeptTypeEnum(dbData);
        }
    }
}
