package com.jst.rapidapp.utils.commonConstants;


public class Constants {

    public enum InputControlTypes {
        TEXT_FIELD(1), BUTTON(2), DATE_FIELD(3), CHECK_BOX(4),DROP_DOWN(5),RADIO_BUTTON(6);
        private int value;
        private InputControlTypes(int value) {
            this.value = value;
        }
    };

    public enum AttributeTypes {
        INT(1), STRING(2), DOUBLE(3), LONG(4),FLOAT(5),BOOLEAN(6),DATE(7);
        private int value;
        private AttributeTypes(int value) {
            this.value = value;
        }
    };
}
