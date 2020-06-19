package com.github.business.enums;

import javax.persistence.AttributeConverter;

/**
 * @date 2020/6/19
 */
public enum StatusEnum {

    DRAFT,

    COMPLETE;

    public static class Converter implements AttributeConverter<StatusEnum, String> {

        @Override
        public String convertToDatabaseColumn(StatusEnum attribute) {
            return attribute.name();
        }

        @Override
        public StatusEnum convertToEntityAttribute(String statusEnum) {
            return StatusEnum.valueOf(statusEnum);
        }
    }
}
